
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

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng ElectraPalace = new LatLng(40.633159, 22.941070);
            googleMap.addMarker(new MarkerOptions().
                    position(ElectraPalace).title("Electra Palace"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(ElectraPalace));

            LatLng PariosPalace = new LatLng(37.057115, 25.118629);
            googleMap.addMarker(new MarkerOptions().
                    position(PariosPalace).title("Parios Palace"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(PariosPalace));

            LatLng NafpioHotel = new LatLng(37.545025, 22.822525);
            googleMap.addMarker(new MarkerOptions().
                    position(NafpioHotel).title("Nafplio Hotel "));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(NafpioHotel));

            LatLng MakedoniaPalace = new LatLng(40.618103, 22.952432);
            googleMap.addMarker(new MarkerOptions().
                    position(MakedoniaPalace).title("Makedonia Palace "));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(MakedoniaPalace));

            LatLng NafplioPalace = new LatLng(37.566068, 22.796979);
            googleMap.addMarker(new MarkerOptions().
                    position(NafplioPalace).title("Nafplio Palace "));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(NafplioPalace));

            LatLng CorfuDreams = new LatLng(39.590718, 19.897450);
            googleMap.addMarker(new MarkerOptions().
                    position(CorfuDreams).title("Corfu dreams"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(CorfuDreams));
        }
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