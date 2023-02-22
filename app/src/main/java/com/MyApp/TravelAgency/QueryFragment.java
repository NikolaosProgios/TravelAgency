package com.MyApp.TravelAgency;

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
    TextView querytextView, querytextresult;
    Button bnqueryrun;
    int test;

    public QueryFragment() { /*Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_query, container, false);

        final String[] queryArray = getResources().getStringArray(R.array.queries_description_array);
        querytextView = view.findViewById(R.id.txtquery);
        spinner = view.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.queries_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                querytextView.setText(queryArray[position]);
                test = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        querytextresult = view.findViewById(R.id.txtqueryresult);
        bnqueryrun = view.findViewById(R.id.queryrun);
        bnqueryrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                querytextresult.setText("test" + test);
                String result = "";

                switch (test) {
                    case 1:
                        List<AgencyTable> agency = MainActivity.myAppDatabase.
                                myDao().getAgencyTable();
                        for (AgencyTable i : agency) {
                            int code = i.getId();
                            String name = i.getName();
                            String address = i.getAddress();
                            result = result + "\n Id: " + code + "\n Name: " + name + "\n Address:" + address + "\n";
                        }
                        querytextresult.setText(result);
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
                            result = result + "\n Id: " + code + "\n City: " + city + "\n Country: " + county + "\n Duration: " + Duration + "\n Type: " + Type + "\n";
                        }
                        querytextresult.setText(result);
                        break;
                    case 3:
                        List<TripPackageTable> reserves = MainActivity.myAppDatabase.
                                myDao().getTripPackageTable();
                        for (TripPackageTable i : reserves) {
                            int Package_id = i.getId();
                            int AgencyCode = i.getAgencyCode();
                            int TripCode = i.getTripCode();
                            String Departure = i.getDeparture();
                            double Price = i.getPrice();
                            result = result + " Package Id: " + Package_id + "\n Agency Code: " + AgencyCode
                                    + "\n TripC ode: " + TripCode + "\n Departure: " + Departure + "\n Price: " + Price + "\n\n";
                        }
                        querytextresult.setText(result);
                        break;
                    case 4:
                        List<ResultString> resultStrings = MainActivity.myAppDatabase.
                                myDao().getQuery4();
                        for (ResultString i : resultStrings) {
                            String Agency_Name = i.getField1();
                            String Agency_address = i.getField2();
                            result = result + "\n Agency's Name:" + Agency_Name + "\n Agency Address:" + Agency_address + "\n";
                        }
                        querytextresult.setText(result);
                        break;
                    case 5:
                        List<String> CityGreece = MainActivity.myAppDatabase.myDao().getQuery5();
                        result = "City: ";
                        for (String i : CityGreece) {
                            result = result + i + "\n          ";
                        }
                        querytextresult.setText(result);
                        break;

                    case 6:
                        List<ResultString> strings6 = MainActivity.myAppDatabase.myDao().getQuery6();
                        for (ResultString i : strings6) {
                            String trip_city = i.field1;
                            String trip_country = i.field2;
                            result = result + "\n Trip city: " + trip_city + "\n Trip Country: " + trip_country + "\n";
                        }
                        querytextresult.setText(result);
                        break;
                    case 7:
                        List<ResultString> strings7 = MainActivity.myAppDatabase.myDao().getQuery7();
                        for (ResultString i : strings7) {
                            String trip_city = i.field1;
                            String trip_country = i.field2;
                            result = result + "\n Trip city: " + trip_city + "\n Trip Country: " + trip_country + "\n";
                        }
                        querytextresult.setText(result);
                        break;
                    case 8:
                        List<Integer> integers8 = MainActivity.myAppDatabase.myDao().getQuery8();
                        result = "Trip Package ID: ";
                        for (Integer i : integers8) {
                            result = result + i + "\n                               ";
                        }
                        querytextresult.setText(result);
                        break;

                    case 9:
                        List<ResultString> strings9 = MainActivity.myAppDatabase.myDao().getQuery9();
                        for (ResultString i : strings9) {
                            String packageid = i.field1;
                            String tripcity = i.field2;
                            result = result + "Trip Package ID:" + packageid + "\n" + "City Trip :" + tripcity + "\n";
                        }
                        querytextresult.setText(result);
                        break;
                    case 10:
                        List<String> strings10 = MainActivity.myAppDatabase.myDao().getQuery10();
                        result = "Agency Name: ";
                        for (String i : strings10) {
                            result = result + i + "\n                              ";
                        }
                        querytextresult.setText(result);
                        break;

                    case 11:
                        List<ResultString> strings11 = MainActivity.myAppDatabase.myDao().getQuery11();
                        for (ResultString i : strings11) {
                            String agencyname = i.field1;
                            String packagaprice = i.field2;
                            result = result + "Agency Name:" + agencyname + "\n" + "Package Price :" + packagaprice + "\n\n";
                        }
                        querytextresult.setText(result);
                        break;
                }
            }
        });
        return view;
    }
}