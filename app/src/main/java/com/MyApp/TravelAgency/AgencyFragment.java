
package com.MyApp.TravelAgency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AgencyFragment extends Fragment implements View.OnClickListener {

    TextView aid, aname, aaddress;
    Button EditTablebn;

    public AgencyFragment() { /*Required empty public constructor  */ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_agency,
                container, false);

        aid = view.findViewById(R.id.textViewIdFill);
        aid.setText(getResources().getString(R.string.agency_id));

        aname = view.findViewById(R.id.textViewNameFill);
        aname.setText(getResources().getString(R.string.agency_name));

        aaddress = view.findViewById(R.id.textViewAddressFill);
        aaddress.setText(getResources().getString(R.string.agency_address));

        EditTablebn = view.findViewById(R.id.FireBaseBN);
        EditTablebn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.FireBaseBN: // for firebase
                AgencyActivity.fragmentManager.beginTransaction().
                        replace(R.id.fragment_container, new menuFragmentFirabase()).addToBackStack(null).commit();
                break;
        }
    }
}