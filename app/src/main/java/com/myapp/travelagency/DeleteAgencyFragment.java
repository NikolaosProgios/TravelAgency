package com.myapp.travelagency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class DeleteAgencyFragment extends Fragment {
    EditText editText;
    Button button;

    public DeleteAgencyFragment() { /*Required empty public constructor*/}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete_agency, container, false);

        editText = view.findViewById(R.id.AgencyDeleteEditText1);
        button = view.findViewById(R.id.AgencyDeleteButton);
        button.setOnClickListener(v -> {
            int varId = 0;
            try {
                varId = Integer.parseInt(editText.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            AgencyTable agency = new AgencyTable();
            agency.setId(varId);

            MainActivity.myAppDatabase.myDao().deleteAgency(agency);
            Toast.makeText(getActivity(), "Delete Agency Complete !", Toast.LENGTH_LONG).show();

            editText.setText("");
        });
        return view;
    }
}