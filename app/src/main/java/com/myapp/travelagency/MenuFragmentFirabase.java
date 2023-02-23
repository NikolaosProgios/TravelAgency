package com.myapp.travelagency;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragmentFirabase extends Fragment implements View.OnClickListener {

    Button clientInsertBtn, clientDeleteBtn, clientUpdateBtn,
            query1, query2, query3;

    public MenuFragmentFirabase() {/* Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_firabase, container, false);

        clientInsertBtn = view.findViewById(R.id.ClientInsertBN);
        clientInsertBtn.setOnClickListener(this);
        clientDeleteBtn = view.findViewById(R.id.ClientDeleteBN);
        clientDeleteBtn.setOnClickListener(this);
        clientUpdateBtn = view.findViewById(R.id.ClientUpdateBN);
        clientUpdateBtn.setOnClickListener(this);

        query1 = view.findViewById(R.id.QueryFirabaseBN1);
        query1.setOnClickListener(this);
        query2 = view.findViewById(R.id.QueryFirabaseBN2);
        query2.setOnClickListener(this);
        query3 = view.findViewById(R.id.QueryFirabaseBN3);
        query3.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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