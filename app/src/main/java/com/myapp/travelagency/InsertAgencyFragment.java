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
        insertagencybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1i metavliti
                int Var_AgencyId = 0;
                try {
                    Var_AgencyId = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }
                //2i metavliti
                String Var_AgencyName = editText2.getText().toString();
                //3i metavliti
                String Var_AgencyAddress = editText3.getText().toString();
                try {
                    AgencyTable agency = new AgencyTable();
                    agency.setId(Var_AgencyId);
                    agency.setName(Var_AgencyName);
                    agency.setAddress(Var_AgencyAddress);
                    MainActivity.myAppDatabase.myDao().insertAgency(agency);
                    Toast.makeText(getActivity(), "Insert Agency Complete !", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        });
        return view;
    }

}