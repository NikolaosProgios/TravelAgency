
package com.MyApp.TravelAgency;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class UpdateAgencyFragment extends Fragment {
    EditText editText1, editText2, editText3;
    Button button;

    public UpdateAgencyFragment() { /* Required empty public constructor*/}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_update_agency, container, false);
        editText1 = view.findViewById(R.id.AgencyUpdateEditText1);
        editText2 = view.findViewById(R.id.AgencyUpdateEditText2);
        editText3 = view.findViewById(R.id.AgencyUpdateEditText3);
        button = view.findViewById(R.id.AgencyUpdateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1i metavliti
                int Var_agencyId = 0;
                try {
                    Var_agencyId = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse + ex");
                }
                //2i metavliti
                String Var_agencyName = editText2.getText().toString();
                //3i metavliti
                String Var_agencyAddress = editText3.getText().toString();
                try {
                    AgencyTable agency = new AgencyTable();
                    agency.setId(Var_agencyId);
                    agency.setName(Var_agencyName);
                    agency.setAddress(Var_agencyAddress);

                    MainActivity.myAppDatabase.myDao().updateAgency(agency);
                    Toast.makeText(getActivity(), "Update Agency !", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        });
        return view;
    }
}