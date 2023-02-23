
package com.myapp.travelagency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AgencyFragment extends Fragment implements View.OnClickListener {

    TextView agencyId, agencyName, agencyAddress;
    Button editTableBtn;

    public AgencyFragment() { /*Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_agency,
                container, false);

        agencyId = view.findViewById(R.id.textViewIdFill);
        agencyId.setText(getResources().getString(R.string.agency_id));

        agencyName = view.findViewById(R.id.textViewNameFill);
        agencyName.setText(getResources().getString(R.string.agency_name));

        agencyAddress = view.findViewById(R.id.textViewAddressFill);
        agencyAddress.setText(getResources().getString(R.string.agency_address));

        editTableBtn = view.findViewById(R.id.FireBaseBN);
        editTableBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.FireBaseBN:
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new MenuFragmentFirabase()).addToBackStack(null).commit();
                break;
        }
    }
}