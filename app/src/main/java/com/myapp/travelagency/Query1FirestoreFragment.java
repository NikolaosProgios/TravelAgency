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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Query1FirestoreFragment extends Fragment {

    TextView queryTextResult;

    public Query1FirestoreFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_query1_firestore, container, false);

        queryTextResult = view.findViewById(R.id.txtqueryresult);
        CollectionReference collectionReference = MainActivity.firestoreDB.
                collection("Clients");
        Query query = collectionReference.orderBy("born", Query.Direction.DESCENDING).limit(4);
        query.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String result = "";
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Clients clients = documentSnapshot.toObject(Clients.class);
                    Integer id = clients.getId();
                    String name = clients.getName();
                    Integer born = clients.getBorn();
                    String phone = clients.getPhone();
                    String hotel = clients.getHotel();
                    Integer package_id = clients.getTrip_package();
                    result += " id: " + id +
                            "\n name: " + name +
                            "\n born: " + born + "\n phone: " + phone +
                            "\n hotel: " + hotel +
                            "\n package_id: " + package_id + "\n\n";
                }
                queryTextResult.setText(result);
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