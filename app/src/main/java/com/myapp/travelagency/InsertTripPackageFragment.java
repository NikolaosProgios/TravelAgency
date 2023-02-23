
package com.myapp.travelagency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class InsertTripPackageFragment extends Fragment {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button insert_trip_Bn;

    public InsertTripPackageFragment() { /* Required empty public constructor*/}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_insert_trip_package, container, false);
        editText1 = view.findViewById(R.id.TripPackageInsetEditText1);
        editText2 = view.findViewById(R.id.TripPackageInsetEditText2);
        editText3 = view.findViewById(R.id.TripPackageInsetEditText3);
        editText4 = view.findViewById(R.id.TripPackageInsetEditText4);
        editText5 = view.findViewById(R.id.TripPackageInsetEditText5);

        insert_trip_Bn = view.findViewById(R.id.TripPackageInsertButton);
        insert_trip_Bn.setOnClickListener(v -> {
            int tripPackageId = 0;
            try {
                tripPackageId = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            int agencyId = 0;
            try {
                agencyId = Integer.parseInt(editText2.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            int tripId = 0;
            try {
                tripId = Integer.parseInt(editText3.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            String dateDeparture = editText4.getText().toString();
            int tripPrice = 0;
            try {
                tripPrice = Integer.parseInt(editText5.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }

            try {
                TripPackageTable tripPackage = new TripPackageTable();
                tripPackage.setId(tripPackageId);
                tripPackage.setAgencyCode(agencyId);
                tripPackage.setTripCode(tripId);
                tripPackage.setDeparture(dateDeparture);
                tripPackage.setPrice(tripPrice);

                MainActivity.myAppDatabase.myDao().insertTripPackage(tripPackage);
                Toast.makeText(getActivity(), "Insert Trip Package Complete !", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                String message = e.getMessage();
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
            editText1.setText("");
            editText2.setText("");
            editText3.setText("");
            editText4.setText("");
            editText5.setText("");
        });
        return view;
    }
}