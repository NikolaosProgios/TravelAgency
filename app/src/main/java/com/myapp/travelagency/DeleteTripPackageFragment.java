package com.myapp.travelagency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class DeleteTripPackageFragment extends Fragment {
    EditText editText1;
    Button button;

    public DeleteTripPackageFragment() { /* Required empty public constructor*/}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_delete_trip_package
                , container, false);
        editText1 = view.findViewById(R.id.TripPackageEditText1);

        button = view.findViewById(R.id.TripPackageDeleteButton);
        button.setOnClickListener(v -> {
            //1i metavliti
            int tripPackageID = 0;
            try {
                tripPackageID = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }

            try {
                TripPackageTable tripPackage = new TripPackageTable();
                tripPackage.setId(tripPackageID);
                MainActivity.myAppDatabase.myDao().deleteTripPackage(tripPackage);
                Toast.makeText(getActivity(), "Delete Trip Package Complete !", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                String message = e.getMessage();
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
            editText1.setText("");
        });
        return view;
    }
}