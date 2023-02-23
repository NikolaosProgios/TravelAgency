package com.myapp.travelagency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class QueryFragment extends Fragment {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView queryTextView, queryTextResult;
    Button btnQueryRun;
    int test;

    public QueryFragment() { /*Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_query, container, false);

        final String[] queryArray = getResources().getStringArray(R.array.queries_description_array);
        queryTextView = view.findViewById(R.id.txtquery);
        spinner = view.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.queries_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                queryTextView.setText(queryArray[position]);
                test = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        queryTextResult = view.findViewById(R.id.txtqueryresult);
        btnQueryRun = view.findViewById(R.id.queryrun);
        btnQueryRun.setOnClickListener(v -> {
            queryTextResult.setText("test" + test);
            StringBuilder result = new StringBuilder();

            switch (test) {
                case 1:
                    List<AgencyTable> agency = MainActivity.myAppDatabase.
                            myDao().getAgencyTable();
                    for (AgencyTable i : agency) {
                        int code = i.getId();
                        String name = i.getName();
                        String address = i.getAddress();
                        result.append("\n Id: ").append(code).append("\n Name: ").append(name).append("\n Address:").append(address).append("\n");
                    }
                    queryTextResult.setText(result.toString());
                    break;
                case 2:
                    List<TripTable> trip = MainActivity.myAppDatabase.
                            myDao().getTripTable();
                    for (TripTable i : trip) {
                        int code = i.getId();
                        String city = i.getCity();
                        String county = i.getCountry();
                        int Duration = i.getDays();
                        String Type = i.getType();
                        result.append("\n Id: ").append(code).append("\n City: ").append(city).append("\n Country: ").append(county).append("\n Duration: ").append(Duration).append("\n Type: ").append(Type).append("\n");
                    }
                    queryTextResult.setText(result.toString());
                    break;
                case 3:
                    List<TripPackageTable> reserves = MainActivity.myAppDatabase.
                            myDao().getTripPackageTable();
                    for (TripPackageTable i : reserves) {
                        int packageId = i.getId();
                        int agencyCode = i.getAgencyCode();
                        int tripCode = i.getTripCode();
                        String Departure = i.getDeparture();
                        double Price = i.getPrice();
                        result.append(" Package Id: ").append(packageId).append("\n Agency Code: ").append(agencyCode).append("\n TripC ode: ").append(tripCode).append("\n Departure: ").append(Departure).append("\n Price: ").append(Price).append("\n\n");
                    }
                    queryTextResult.setText(result.toString());
                    break;
                case 4:
                    List<ResultString> resultStrings = MainActivity.myAppDatabase.
                            myDao().getQuery4();
                    for (ResultString i : resultStrings) {
                        String agencyName = i.getField1();
                        String agencyAddress = i.getField2();
                        result.append("\n Agency's Name:").append(agencyName).append("\n Agency Address:").append(agencyAddress).append("\n");
                    }
                    queryTextResult.setText(result.toString());
                    break;
                case 5:
                    List<String> cityGreece = MainActivity.myAppDatabase.myDao().getQuery5();
                    result = new StringBuilder("City: ");
                    for (String i : cityGreece) {
                        result.append(i).append("\n          ");
                    }
                    queryTextResult.setText(result.toString());
                    break;

                case 6:
                    List<ResultString> strings6 = MainActivity.myAppDatabase.myDao().getQuery6();
                    for (ResultString i : strings6) {
                        String tripCity = i.field1;
                        String tripCountry = i.field2;
                        result.append("\n Trip city: ").append(tripCity).append("\n Trip Country: ").append(tripCountry).append("\n");
                    }
                    queryTextResult.setText(result.toString());
                    break;
                case 7:
                    List<ResultString> strings7 = MainActivity.myAppDatabase.myDao().getQuery7();
                    for (ResultString i : strings7) {
                        String tripCity = i.field1;
                        String tripCountry = i.field2;
                        result.append("\n Trip city: ").append(tripCity).append("\n Trip Country: ").append(tripCountry).append("\n");
                    }
                    queryTextResult.setText(result.toString());
                    break;
                case 8:
                    List<Integer> integers8 = MainActivity.myAppDatabase.myDao().getQuery8();
                    result = new StringBuilder("Trip Package ID: ");
                    for (Integer i : integers8) {
                        result.append(i).append("\n                               ");
                    }
                    queryTextResult.setText(result.toString());
                    break;

                case 9:
                    List<ResultString> strings9 = MainActivity.myAppDatabase.myDao().getQuery9();
                    for (ResultString i : strings9) {
                        String packageId = i.field1;
                        String tripCity = i.field2;
                        result.append("Trip Package ID:").append(packageId).append("\n").append("City Trip :").append(tripCity).append("\n");
                    }
                    queryTextResult.setText(result.toString());
                    break;
                case 10:
                    List<String> strings10 = MainActivity.myAppDatabase.myDao().getQuery10();
                    result = new StringBuilder("Agency Name: ");
                    for (String i : strings10) {
                        result.append(i).append("\n                              ");
                    }
                    queryTextResult.setText(result.toString());
                    break;

                case 11:
                    List<ResultString> strings11 = MainActivity.myAppDatabase.myDao().getQuery11();
                    for (ResultString i : strings11) {
                        String agencyMame = i.field1;
                        String packagaPrice = i.field2;
                        result.append("Agency Name:").append(agencyMame).append("\n").append("Package Price :").append(packagaPrice).append("\n\n");
                    }
                    queryTextResult.setText(result.toString());
                    break;
            }
        });
        return view;
    }
}