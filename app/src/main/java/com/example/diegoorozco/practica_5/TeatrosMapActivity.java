package com.example.diegoorozco.practica_5;

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

public class TeatrosMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teatros_map);
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
        LatLng TMetr = new LatLng(6.2432116, -75.5797098);
        builder.include(TMetr); //acumlando posiciones para el rango de vista
        LatLng TPTob = new LatLng(6.2475264,-75.5616541);
        builder.include(TPTob);
        LatLng TUMed = new LatLng(6.2322831,-75.613088);
        builder.include(TUMed);
        LatLng TADes = new LatLng(6.254683,-75.5628707);
        builder.include(TADes);
        LatLng TCPob = new LatLng(6.188123,-75.5830061);
        builder.include(TCPob);
        LatLng Teatr = new LatLng(6.2428311,-75.5952202);
        builder.include(Teatr);
        LatLng PeqTea=new LatLng(6.2475587,-75.5639232);
        builder.include(PeqTea);


        LatLngBounds bounds = builder.build();//grabando rango de vista

        mMap.addMarker(new MarkerOptions().position(TADes).title("Teatro Aguila Descalza"));
        mMap.addMarker(new MarkerOptions().position(PeqTea).title("Pequeño Tetaro"));
        mMap.addMarker(new MarkerOptions().position(TCPob).title("Teatro El Poblado"));
        mMap.addMarker(new MarkerOptions().position(Teatr).title("El Teatrico"));
        mMap.addMarker(new MarkerOptions().position(TMetr).title("Tetaro Metropolitano"));
        mMap.addMarker(new MarkerOptions().position(TPTob).title("Teatro Pablo Tobon Uribe"));
        mMap.addMarker(new MarkerOptions().position(TUMed).title("Tetaro Universidad de Medellin"));

        int padding = 0; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);//Animando la camara en el Rango de vista Obtenido

        mMap.animateCamera(cu);

        mMap.setMyLocationEnabled(true);
    }
}
