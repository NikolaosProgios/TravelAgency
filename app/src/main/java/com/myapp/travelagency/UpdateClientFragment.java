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

public class UpdateClientFragment extends Fragment {

    Button button1;
    EditText editText1, editText2, editText4, editText5, editText6, editText3;

    public UpdateClientFragment() {/* Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_update_client, container, false);

        editText1 = view.findViewById(R.id.ClientUpdateEditText1);
        editText2 = view.findViewById(R.id.ClientUpdateEditText2);
        editText3 = view.findViewById(R.id.ClientUpdateEditText3);
        editText4 = view.findViewById(R.id.ClientUpdateEditText4);
        editText5 = view.findViewById(R.id.ClientUpdateEditText5);
        editText6 = view.findViewById(R.id.ClientUpdateEditText6);
        button1 = view.findViewById(R.id.ClientUpdateButton);

        button1.setOnClickListener(v -> {
            int clientId = 0;
            try {
                clientId = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            String clientName = editText2.getText().toString();
            int clientBorn = 0;
            try {
                clientBorn = Integer.parseInt(editText3.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            String clientPhone = editText4.getText().toString();

            String clientHotel = editText5.getText().toString();

            int clientPackageID = 0;
            try {
                clientPackageID = Integer.parseInt(editText6.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }

            try {
                Clients client = new Clients();
                client.setId(clientId);
                client.setName(clientName);
                client.setBorn(clientBorn);
                client.setPhone(clientPhone);
                client.setHotel(clientHotel);
                client.setTripPackage(clientPackageID);

                MainActivity.firestoreDB.
                        collection("Clients").
                        document("" + clientId).set(client).
                        addOnCompleteListener(task -> Toast.makeText(getActivity(), "Client Update", Toast.LENGTH_SHORT).show()).
                        addOnFailureListener(e -> Toast.makeText(getActivity(), "Client update FAILED", Toast.LENGTH_SHORT).show());

            } catch (Exception e) {
                String message = e.getMessage();
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
            editText1.setText("");
            editText2.setText("");
            editText3.setText("");
            editText4.setText("");
            editText5.setText("");
            editText6.setText("");
        });
        return view;
    }
}