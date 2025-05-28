package com.example.atividadeadapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.atividadeadapters.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment implements AdapterView.OnItemClickListener {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //ArrayAdapter ListView
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.shreks, android.R.layout.simple_list_item_1);
        binding.lista.setAdapter(adapter);
        binding.lista.setOnItemClickListener(this);

        //ArrayAdapter Spinner
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.shreks, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapterSpinner);

        //ArrayAdapter AutoCompleteTextView
        ArrayAdapter<CharSequence> adapterAuto = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.shreks, android.R.layout.simple_list_item_1);
        binding.auto.setAdapter(adapterAuto);
        binding.auto.setThreshold(1);

        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity().getApplicationContext(), (CharSequence) adapterView.getItemAtPosition(i),
                Toast.LENGTH_SHORT).show();
    }
}