package com.example.diegoorozco.practica_5;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CineFragment extends Fragment {


    public CineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inputfragment=inflater.inflate(R.layout.fragment_cine,container,false);
        Button mapa=(Button)inputfragment.findViewById(R.id.bCineMapa);

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MapsActivityCine.class );
                getActivity().startActivity(i);
            }
        });
        return inputfragment;
    }



}
