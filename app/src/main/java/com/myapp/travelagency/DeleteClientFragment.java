
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

public class DeleteClientFragment extends Fragment {

    EditText editText1;
    Button button1;

    public DeleteClientFragment() {/* Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_delete_client, container, false);
        editText1 = view.findViewById(R.id.ClientDeleteEditText1);
        button1 = view.findViewById(R.id.ClientDeleteButton);
        button1.setOnClickListener(v -> {

            int clientId = 0;
            try {
                clientId = Integer.parseInt(editText1.getText().toString());
            } catch (NumberFormatException ex) {
                System.out.println("Could not parse + ex");
            }
            try {
                MainActivity.firestoreDB.
                        collection("Clients").
                        document("" + clientId).delete().
                        addOnCompleteListener(task -> Toast.makeText(getActivity(), "Client DELETE", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(getActivity(), "Client delete FAILED", Toast.LENGTH_SHORT).show());
            } catch (Exception e) {
                String message = e.getMessage();
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
            editText1.setText("");
        });
        return view;
    }
}