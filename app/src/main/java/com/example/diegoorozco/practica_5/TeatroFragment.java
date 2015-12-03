package com.example.diegoorozco.practica_5;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeatroFragment extends Fragment {


    public TeatroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inputfragment=inflater.inflate(R.layout.fragment_teatro,container,false);
        Button mapa=(Button)inputfragment.findViewById(R.id.bTeatroMapa);

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),TeatrosMapActivity.class );
                getActivity().startActivity(i);
            }
        });
        return inputfragment;
    }


}
