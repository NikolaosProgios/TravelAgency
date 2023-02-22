package com.myapp.travelagency;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

public class Query2FirestoreFragment extends Fragment {

    TextView queryTextResult;
    DocumentReference documentReference;

    public Query2FirestoreFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query2_firestore, container, false);

        queryTextResult = view.findViewById(R.id.txtqueryresult);

        documentReference = MainActivity.firestoreDB.collection("Clients").
                document("4001");

        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    Clients clients = documentSnapshot.toObject(Clients.class);
                    Integer id = clients.getId();
                    String name = clients.getName();
                    Integer born = clients.getBorn();
                    String phone = clients.getPhone();
                    String hotel = clients.getHotel();
                    Integer package_id = clients.getTrip_package();
                    queryTextResult.setText(
                            " id: " + id +
                                    "\n name: " + name +
                                    "\n born: " + born + "\n phone: " + phone +
                                    "\n hotel: " + hotel +
                                    "\n package_id: " + package_id + "\n");
                } else {
                    Toast.makeText(getActivity(), "document does not exist.", Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "query failed", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}