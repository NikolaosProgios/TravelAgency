package com.myapp.travelagency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class InsertAgencyFragment extends Fragment {
    EditText editText1, editText2, editText3;
    Button insertagencybutton;

    public InsertAgencyFragment() { /* Required empty public constructor*/}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_insert_agency, container, false);
        editText1 = view.findViewById(R.id.AgencyInsertEditTex1);
        editText2 = view.findViewById(R.id.AgencyInsertEditTex2);
        editText3 = view.findViewById(R.id.AgencyInsertEditTex3);
        insertagencybutton = view.findViewById(R.id.AgencyInsertButton);
        insertagencybutton.setOnClickListener(v -> {
            int agencyId = 0;
            try {
                agencyId = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            String agencyName = editText2.getText().toString();
            String agencyAddress = editText3.getText().toString();
            try {
                AgencyTable agency = new AgencyTable();
                agency.setId(agencyId);
                agency.setName(agencyName);
                agency.setAddress(agencyAddress);
                MainActivity.myAppDatabase.myDao().insertAgency(agency);
                Toast.makeText(getActivity(), "Insert Agency Complete !", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                String message = e.getMessage();
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
            editText1.setText("");
            editText2.setText("");
            editText3.setText("");
        });
        return view;
    }
}