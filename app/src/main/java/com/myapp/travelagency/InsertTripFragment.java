
package com.myapp.travelagency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class InsertTripFragment extends Fragment {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button insertTripBtn;

    public InsertTripFragment() { /* Required empty public constructor*/}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_insert_trip, container, false);
        editText1 = view.findViewById(R.id.TripInsertEditText1);
        editText2 = view.findViewById(R.id.TripInsertEditText2);
        editText3 = view.findViewById(R.id.TripInsertEditText3);
        editText4 = view.findViewById(R.id.TripInsertEditText4);
        editText5 = view.findViewById(R.id.TripInsertEditText5);
        insertTripBtn = view.findViewById(R.id.TripInsertButton);
        insertTripBtn.setOnClickListener(v -> {
            int tripId = 0;
            try {
                tripId = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            String tripCity = editText2.getText().toString();
            String tripCountry = editText3.getText().toString();
            int tripDays = 0;
            try {
                tripDays = Integer.parseInt(editText4.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            String tripType = editText5.getText().toString();
            try {
                TripTable trip = new TripTable();
                trip.setId(tripId);
                trip.setCity(tripCity);
                trip.setCountry(tripCountry);
                trip.setDays(tripDays);
                trip.setType(tripType);

                MainActivity.myAppDatabase.myDao().insertTrip(trip);
                Toast.makeText(getActivity(), "Insert Trip Complete !", Toast.LENGTH_LONG).show();
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