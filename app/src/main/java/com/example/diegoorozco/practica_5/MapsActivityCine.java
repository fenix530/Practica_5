package com.example.diegoorozco.practica_5;

import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
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

public class MapsActivityCine extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_activity_cine);
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
        LatLng CColMol = new LatLng(6.23317, -75.6063687);
        builder.include(CColMol); //acumlando posiciones para el rango de vista
        LatLng CColSan = new LatLng(6.1979237,-75.5765434);
        builder.include(CColSan);
        LatLng CColViz = new LatLng(6.208213,-75.5656573);
        builder.include(CColViz);
        LatLng CColOvi = new LatLng(6.199257,-75.5775189);
        builder.include(CColOvi);
        LatLng CColUni = new LatLng(6.24077,-75.5892087);
        builder.include(CColUni);
        LatLng RFPrem = new LatLng(6.2301266,-75.5717978);
        builder.include(RFPrem);
        LatLng RFBosPl=new LatLng(6.2691592,-75.56570);
        builder.include(RFBosPl);
        LatLng RFJumbo65= new LatLng(6.252125,-75.5875487);
        builder.include(RFJumbo65);
        LatLng CPMayo = new LatLng(6.1610158,-75.6073053);
        builder.include(CPMayo);
        LatLng CPMont = new LatLng(6.2142784,-75.5769526);
        builder.include(CPMont);
        LatLng CPLasAm = new LatLng(6.2142543,-75.5970907);
        builder.include(CPLasAm);
        LatLng CPFolri = new LatLng(6.2706642,-75.579648);
        builder.include(CPFolri);
        LatLng CPPuerNor= new LatLng(6.3387645,-75.5444802);
        builder.include(CPPuerNor);
        LatLng CPAvesMa= new LatLng(6.1489392,-75.6193364);
        builder.include(CPAvesMa);

        LatLngBounds bounds = builder.build();//grabando rango de vista

        mMap.addMarker(new MarkerOptions().position(CColMol).title("CineColombia CC Los Molinos"));
        mMap.addMarker(new MarkerOptions().position(CColOvi).title("CineColombia CC Oviedo"));
        mMap.addMarker(new MarkerOptions().position(CColSan).title("CineColombia CC Santa Fe"));
        mMap.addMarker(new MarkerOptions().position(CColUni).title("CineColombia CC Unicentro"));
        mMap.addMarker(new MarkerOptions().position(CColViz).title("CineColombia CC Vizcaya"));
        mMap.addMarker(new MarkerOptions().position(RFBosPl).title("RoyalFilms CC Bosque Plaza"));
        mMap.addMarker(new MarkerOptions().position(RFJumbo65).title("RoyalFilms Jumbo la 65"));
        mMap.addMarker(new MarkerOptions().position(RFPrem).title("RoyalFilms CC Premium Plaza"));
        mMap.addMarker(new MarkerOptions().position(CPAvesMa).title("Procinal CC Aves Marias"));
        mMap.addMarker(new MarkerOptions().position(CPFolri).title("Procinal CC Florida"));
        mMap.addMarker(new MarkerOptions().position(CPLasAm).title("Procinal CC La Amricas"));
        mMap.addMarker(new MarkerOptions().position(CPMayo).title("Procinal CC Mayorca"));
        mMap.addMarker(new MarkerOptions().position(CPMont).title("Procinal CC Monterrey"));
        mMap.addMarker(new MarkerOptions().position(CPPuerNor).title("Procinal CC Puerta del Norte"));

        int padding = 0; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);//Animando la camara en el Rango de vista Obtenido

        mMap.animateCamera(cu);

        mMap.setMyLocationEnabled(true);
    }
}
