
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
    Button insert_trip_Bn;

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
        insert_trip_Bn = view.findViewById(R.id.TripInsertButton);
        insert_trip_Bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1i metavliti
                int Var_TripId = 0;
                try {
                    Var_TripId = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }
                //2i metavliti
                String Var_TripCity = editText2.getText().toString();
                //3i metavliti
                String Var_TripCountry = editText3.getText().toString();
                //4i metavliti
                int Var_TripDays = 0;
                try {
                    Var_TripDays = Integer.parseInt(editText4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }
                //5i metavliti
                String Var_TripType = editText5.getText().toString();
                try {
                    TripTable trip = new TripTable();
                    trip.setId(Var_TripId);
                    trip.setCity(Var_TripCity);
                    trip.setCountry(Var_TripCountry);
                    trip.setDays(Var_TripDays);
                    trip.setType(Var_TripType);

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
            }
        });
        return view;
    }
}