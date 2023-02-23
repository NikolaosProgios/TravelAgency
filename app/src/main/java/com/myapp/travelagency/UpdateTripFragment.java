package com.myapp.travelagency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class UpdateTripFragment extends Fragment {
    Button button;
    EditText editText1, editText2, editText3, editText4, editText5;

    public UpdateTripFragment() { /* Required empty public constructor*/}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_update_trip, container, false);
        editText1 = view.findViewById(R.id.TripUpdateEditText1);
        editText2 = view.findViewById(R.id.TripUpdateEditText2);
        editText3 = view.findViewById(R.id.TripUpdateEditText3);
        editText4 = view.findViewById(R.id.TripUpdateEditText4);
        editText5 = view.findViewById(R.id.TripUpdateEditText5);
        button = view.findViewById(R.id.TripUpdateButton);
        button.setOnClickListener(v -> {
            int tripID = 0;
            try {
                tripID = Integer.parseInt(editText1.getText().toString());
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
                trip.setId(tripID);
                trip.setCity(tripCity);
                trip.setCountry(tripCountry);
                trip.setDays(tripDays);
                trip.setType(tripType);

                MainActivity.myAppDatabase.myDao().updateTrip(trip);
                Toast.makeText(getActivity(), "Update Trip Complete !", Toast.LENGTH_LONG).show();
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
