package pl.pollub.myapplication;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

public class AsyncDownload extends AsyncTask<Integer, Integer, Integer> {
    @Override
    protected Integer doInBackground(Integer... params) {
        int i = params[0].intValue();
        publishProgress(new Integer[] {i+1});
        return 42;
    }
    @Override
    protected void onProgressUpdate(Integer... values) {

    }
    @Override
    protected void onPostExecute(Integer result) {

    }
}
