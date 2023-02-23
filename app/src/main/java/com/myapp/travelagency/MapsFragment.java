package com.myapp.travelagency;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private final OnMapReadyCallback callback = googleMap -> {

        LatLng electraPalace = new LatLng(40.633159, 22.941070);
        googleMap.addMarker(new MarkerOptions().
                position(electraPalace).title("Electra Palace"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(electraPalace));

        LatLng pariosPalace = new LatLng(37.057115, 25.118629);
        googleMap.addMarker(new MarkerOptions().
                position(pariosPalace).title("Parios Palace"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(pariosPalace));

        LatLng nafplioHotel = new LatLng(37.545025, 22.822525);
        googleMap.addMarker(new MarkerOptions().
                position(nafplioHotel).title("Nafplio Hotel "));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(nafplioHotel));

        LatLng makedoniaPalace = new LatLng(40.618103, 22.952432);
        googleMap.addMarker(new MarkerOptions().
                position(makedoniaPalace).title("Makedonia Palace "));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(makedoniaPalace));

        LatLng nafplioPalace2 = new LatLng(37.566068, 22.796979);
        googleMap.addMarker(new MarkerOptions().
                position(nafplioPalace2).title("Nafplio Palace "));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(nafplioPalace2));

        LatLng corfuDreams = new LatLng(39.590718, 19.897450);
        googleMap.addMarker(new MarkerOptions().
                position(corfuDreams).title("Corfu dreams"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(corfuDreams));
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}