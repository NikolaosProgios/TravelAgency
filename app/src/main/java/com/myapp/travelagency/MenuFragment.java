package com.myapp.travelagency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment implements View.OnClickListener {

    Button agencyInsertBtn, agencyDeleteBtn, agencyUpdateBtn,
            tripInsertBtn, tripDeleteBtn, tripUpdateBtn,
            tripPackageInsetBtn, tripPackageDeleteBtn, tripPackageUpdateBtn,
            allQueriesBtn;

    public MenuFragment() { /*Required empty public constructor  */ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        agencyInsertBtn = view.findViewById(R.id.AgencyInsertBN);
        agencyInsertBtn.setOnClickListener(this);
        agencyDeleteBtn = view.findViewById(R.id.AgencyDeleteBN);
        agencyDeleteBtn.setOnClickListener(this);
        agencyUpdateBtn = view.findViewById(R.id.AgencyUpdateBN);
        agencyUpdateBtn.setOnClickListener(this);

        tripInsertBtn = view.findViewById(R.id.TripInsertBN);
        tripInsertBtn.setOnClickListener(this);
        tripDeleteBtn = view.findViewById(R.id.TripDeleteBN);
        tripDeleteBtn.setOnClickListener(this);
        tripUpdateBtn = view.findViewById(R.id.TripUpdateBN);
        tripUpdateBtn.setOnClickListener(this);

        tripPackageInsetBtn = view.findViewById(R.id.TripPackageInsetBN);
        tripPackageInsetBtn.setOnClickListener(this);
        tripPackageDeleteBtn = view.findViewById(R.id.TripPackageDeleteBN);
        tripPackageDeleteBtn.setOnClickListener(this);
        tripPackageUpdateBtn = view.findViewById(R.id.TripPackageUpdateBN);
        tripPackageUpdateBtn.setOnClickListener(this);

        allQueriesBtn = view.findViewById(R.id.AllQueriesBN);
        allQueriesBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.AgencyInsertBN:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new InsertAgencyFragment()).addToBackStack(null).commit();
                break;
            case R.id.AgencyDeleteBN:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new DeleteAgencyFragment()).addToBackStack(null).commit();
                break;
            case R.id.AgencyUpdateBN:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new UpdateAgencyFragment()).addToBackStack(null).commit();
                break;

            case R.id.TripInsertBN:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new InsertTripFragment()).addToBackStack(null).commit();
                break;
            case R.id.TripDeleteBN:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new DeleteTripFragment()).addToBackStack(null).commit();
                break;
            case R.id.TripUpdateBN:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new UpdateTripFragment()).addToBackStack(null).commit();
                break;

            case R.id.TripPackageInsetBN:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new InsertTripPackageFragment()).addToBackStack(null).commit();
                break;
            case R.id.TripPackageDeleteBN:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new DeleteTripPackageFragment()).addToBackStack(null).commit();
                break;
            case R.id.TripPackageUpdateBN:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new UpdateTripPackageFragment()).addToBackStack(null).commit();
                break;

            case R.id.AllQueriesBN:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new QueryFragment()).addToBackStack(null).commit();
                break;
        }
    }
}