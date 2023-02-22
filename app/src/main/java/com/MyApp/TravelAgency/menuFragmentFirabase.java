
package com.MyApp.TravelAgency;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class menuFragmentFirabase extends Fragment implements View.OnClickListener {

    Button  ClientInsertBn, ClientDeleteBn, ClientUpdateBn,
            Query1,Query2,Query3;

    public menuFragmentFirabase() {/* Required empty public constructor*/    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_firabase, container, false);

        ClientInsertBn = view.findViewById(R.id.ClientInsertBN);
        ClientInsertBn.setOnClickListener(this);
        ClientDeleteBn = view.findViewById(R.id.ClientDeleteBN);
        ClientDeleteBn.setOnClickListener(this);
        ClientUpdateBn = view.findViewById(R.id.ClientUpdateBN);
        ClientUpdateBn.setOnClickListener(this);

        Query1 = view.findViewById(R.id.QueryFirabaseBN1);
        Query1.setOnClickListener(this);
        Query2 = view.findViewById(R.id.QueryFirabaseBN2);
        Query2.setOnClickListener(this);
        Query3 = view.findViewById(R.id.QueryFirabaseBN3);
        Query3.setOnClickListener(this);

        return view;
    }
@Override
public void onClick(View v) {
        switch (v.getId()){

        case R.id.ClientInsertBN:
            AgencyActivity.fragmentManager.beginTransaction().
            replace(R.id.fragment_container, new InsertClientFragment()).addToBackStack(null).commit();
        break;
        case R.id.ClientDeleteBN:
            AgencyActivity.fragmentManager.beginTransaction().
            replace(R.id.fragment_container, new DeleteClientFragment()).addToBackStack(null).commit();
        break;
        case R.id.ClientUpdateBN:
            AgencyActivity.fragmentManager.beginTransaction().
            replace(R.id.fragment_container, new UpdateClientFragment()).addToBackStack(null).commit();
        break;
        case R.id.QueryFirabaseBN1:
            AgencyActivity.fragmentManager.beginTransaction().
            replace(R.id.fragment_container, new Query1FirestoreFragment()).addToBackStack(null).commit();
            break;
        case R.id.QueryFirabaseBN2:
            AgencyActivity.fragmentManager.beginTransaction().
            replace(R.id.fragment_container, new Query2FirestoreFragment()).addToBackStack(null).commit();
            break;
        case R.id.QueryFirabaseBN3:
            AgencyActivity.fragmentManager.beginTransaction().
            replace(R.id.fragment_container, new Query3FirestoreFragment()).addToBackStack(null).commit();
            break;
        }
    }
}