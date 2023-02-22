
package com.myapp.travelagency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class menuFragment extends Fragment implements View.OnClickListener {

    Button AgencyInsertBn, AgencyDeleteBn, AgencyUpdateBn,
            TripInsertBn, TripDeleteBn, TripUpdateBn,
            TripPackageInsetBn, TripPackageDeleteBn, TripPackageUpdateBn,
            AllQueriesBn;

    public menuFragment() { /*Required empty public constructor  */ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        AgencyInsertBn = view.findViewById(R.id.AgencyInsertBN);
        AgencyInsertBn.setOnClickListener(this);
        AgencyDeleteBn = view.findViewById(R.id.AgencyDeleteBN);
        AgencyDeleteBn.setOnClickListener(this);
        AgencyUpdateBn = view.findViewById(R.id.AgencyUpdateBN);
        AgencyUpdateBn.setOnClickListener(this);

        TripInsertBn = view.findViewById(R.id.TripInsertBN);
        TripInsertBn.setOnClickListener(this);
        TripDeleteBn = view.findViewById(R.id.TripDeleteBN);
        TripDeleteBn.setOnClickListener(this);
        TripUpdateBn = view.findViewById(R.id.TripUpdateBN);
        TripUpdateBn.setOnClickListener(this);

        TripPackageInsetBn = view.findViewById(R.id.TripPackageInsetBN);
        TripPackageInsetBn.setOnClickListener(this);
        TripPackageDeleteBn = view.findViewById(R.id.TripPackageDeleteBN);
        TripPackageDeleteBn.setOnClickListener(this);
        TripPackageUpdateBn = view.findViewById(R.id.TripPackageUpdateBN);
        TripPackageUpdateBn.setOnClickListener(this);

        AllQueriesBn = view.findViewById(R.id.AllQueriesBN);
        AllQueriesBn.setOnClickListener(this);

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