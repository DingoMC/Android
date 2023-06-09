package pl.pollub.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import pl.pollub.lab1.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.editTextTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String t = s.toString();
                if (t.length() == 0) {
                    binding.editTextTextPersonName.setError("Wypełnij to pole!");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.editTextTextPersonSurname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String t = s.toString();
                if (t.length() == 0) {
                    binding.editTextTextPersonSurname.setError("Wypełnij to pole!");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.editTextTextPersonMark.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String t = s.toString();
                int n;
                try {
                    n = Integer.parseInt(t);
                }
                catch (NumberFormatException e) {
                    n = 0;
                }
                if (n < 5 || n > 15) binding.editTextTextPersonMark.setError("Nieprawidłowa wartość!");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
