package pl.pollub.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    public TextView t_rozmiar;
    public TextView t_typ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t_rozmiar = (TextView) findViewById(R.id.textSizeChangeable);
        t_typ = (TextView) findViewById(R.id.textTypeChangeable);
        AsyncDownload z = new AsyncDownload();
        Button button = (Button) findViewById(R.id.buttonInfo);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText u = (EditText) findViewById(R.id.editUri);
                z.execute(u.getText().toString());
            }
        });
    }

    public class AsyncDownload extends AsyncTask<String, Void, String[]> {
        private String mRozmiar;
        private String mTyp;
        @Override
        protected String[] doInBackground(String ...args) {
            HttpsURLConnection polaczenie = null;
            try {
                URL url = new URL(args[0]);
                polaczenie = (HttpsURLConnection) url.openConnection();
                polaczenie.setRequestMethod("GET");
                mRozmiar = Integer.toString(polaczenie.getContentLength()) + "B";
                mTyp = polaczenie.getContentType();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (polaczenie != null) polaczenie.disconnect();
            }
            return new String[]{mRozmiar, mTyp};
        }
        @Override
        protected void onProgressUpdate(Void... args) {

        }
        @Override
        protected void onPostExecute(String[] result) {
            t_rozmiar.setText(mRozmiar);
            t_typ.setText(mTyp);
        }
    }

}
