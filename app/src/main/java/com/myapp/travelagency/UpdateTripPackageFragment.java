package com.myapp.travelagency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class UpdateTripPackageFragment extends Fragment {
    Button button;
    EditText editText1, editText2, editText3, editText4, editText5;

    public UpdateTripPackageFragment() { /* Required empty public constructor*/}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmnet_update_trip_package, container, false);
        editText1 = view.findViewById(R.id.TripPackageUpdateEditText1);
        editText2 = view.findViewById(R.id.TripPackageUpdateEditText2);
        editText3 = view.findViewById(R.id.TripPackageUpdateEditText3);
        editText4 = view.findViewById(R.id.TripPackageUpdateEditText4);
        editText5 = view.findViewById(R.id.TripPackageUpdateEditText5);

        button = view.findViewById(R.id.TripPackageUpdateButton);
        button.setOnClickListener(v -> {
            //1i metavliti
            int tripPackageId = 0;
            try {
                tripPackageId = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            //2i metavliti
            int agencyId = 0;
            try {
                agencyId = Integer.parseInt(editText2.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            int tripId = 0;
            try {
                agencyId = Integer.parseInt(editText3.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            String dateDeperature = editText4.getText().toString();
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
                tripPackage.setDeparture(dateDeperature);
                tripPackage.setPrice(tripPrice);

                MainActivity.myAppDatabase.myDao().updateTripPackage(tripPackage);
                Toast.makeText(getActivity(), "Update Trip Package Complete !", Toast.LENGTH_LONG).show();
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