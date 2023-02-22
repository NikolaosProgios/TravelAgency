
package com.myapp.travelagency;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

public class InsertClientFragment extends Fragment {

    EditText editText1, editText2, editText4, editText5, editText6, editText7;
    Button button1;

    public InsertClientFragment() {/* Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_insert_client, container, false);

        editText1 = view.findViewById(R.id.ClientInsertEditText1);
        editText2 = view.findViewById(R.id.ClientInsertEditText2);
        editText4 = view.findViewById(R.id.ClientInsertEditText4);
        editText5 = view.findViewById(R.id.ClientInsertEditText5);
        editText6 = view.findViewById(R.id.ClientInsertEditText6);
        editText7 = view.findViewById(R.id.ClientInsertEditText7);

        button1 = view.findViewById(R.id.ClientInsertButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for the client's ID
                int var_ClientId = 0;
                try {
                    var_ClientId = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }
                // for client's name
                String var_ClientName = editText2.getText().toString();
                // for client's year of birth
                int var_ClientBorn = 0;
                try {
                    var_ClientBorn = Integer.parseInt(editText4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }
                // for client's phone number
                String var_ClientPhone = editText5.getText().toString();

                // for client's hotel
                String var_ClientHotel = editText6.getText().toString();

                int var_ClientPackageID = 0;
                try {
                    var_ClientPackageID = Integer.parseInt(editText7.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }

                try {
                    // creating the client object to add to fire store
                    Clients client = new Clients();
                    client.setId(var_ClientId);
                    client.setName(var_ClientName);
                    client.setBorn(var_ClientBorn);
                    client.setPhone(var_ClientPhone);
                    client.setHotel(var_ClientHotel);
                    client.setTrip_package(var_ClientPackageID);

                    MainActivity.firestoreDB.
                            collection("Clients").
                            document("" + var_ClientId).set(client).
                            addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getActivity(), "Client added", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(), "Client add FAILED", Toast.LENGTH_SHORT).show();
                                }
                            });

                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
                editText2.setText("");
                editText4.setText("");
                editText5.setText("");
                editText6.setText("");
                editText7.setText("");
            }
        });


        return view;
    }
}