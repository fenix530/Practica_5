package com.example.diegoorozco.practica_5;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class BaresMapaActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bares_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLngBounds.Builder builder = new LatLngBounds.Builder(); // para acumular las poscionees y crear un rango de vista

        // Add a marker in Sydney and move the camera
        LatLng PLler = new LatLng(6.2088716, -75.5699317);
        builder.include(PLler); //acumlando posiciones para el rango de vista
        LatLng LPalm = new LatLng(6.2231504,-75.5675161);
        builder.include(LPalm);
        LatLng BCol = new LatLng(6.22736,-75.5738387);
        builder.include(BCol);
        LatLng CCLaStr = new LatLng(6.2020084,-75.5741693);
        builder.include(CCLaStr);
        LatLng CCRioS = new LatLng(6.1988323,-75.5755426);
        builder.include(CCRioS);
        LatLng La33 = new LatLng(6.2392454,-75.5876659);
        builder.include(La33);


        LatLngBounds bounds = builder.build();//grabando rango de vista

        mMap.addMarker(new MarkerOptions().position(BCol).title("Barrio Colombia"));
        mMap.addMarker(new MarkerOptions().position(CCLaStr).title("CC La Strada"));
        mMap.addMarker(new MarkerOptions().position(CCRioS).title("CC Rio Sur"));
        mMap.addMarker(new MarkerOptions().position(La33).title("La 33"));
        mMap.addMarker(new MarkerOptions().position(LPalm).title("Las Palmas"));
        mMap.addMarker(new MarkerOptions().position(PLler).title("Parque Lleras"));

        int padding = 0; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);//Animando la camara en el Rango de vista Obtenido

        mMap.animateCamera(cu);

        mMap.setMyLocationEnabled(true);
        Location miubi=mMap.getMyLocation();
    }
}
