package com.example.tablayoutdemo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;


import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment implements OnClickListener{

    TextView miles, kilometers;
    public Tab2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tab2, container, false);


        Button b = (Button)view.findViewById(R.id.convertDistBtn);
        miles = (TextView) view.findViewById(R.id.mileEdit);
        kilometers = (TextView) view.findViewById(R.id.kmEdit);
        b.setOnClickListener( this );


        return view;
    }

    @Override
    public void onClick(View v) {
        String milesStr, km;
        milesStr = miles.getText().toString();
        km = kilometers.getText().toString();

        if(milesStr.isEmpty() && km.isEmpty()){
            Toast t = Toast.makeText(this.getContext(), "At least one of the fields must be populated", Toast.LENGTH_SHORT);
            t.show();
        }
        else if(!milesStr.isEmpty() && !km.isEmpty()){
            //Convert to kilometers by default
            kilometers.setText(Double.toString(milesTokm(milesStr)));
        }
        else{
            if(milesStr.isEmpty()){
                miles.setText(Double.toString(kmTomiles(km)));
            }
            else{
                kilometers.setText(Double.toString(milesTokm(milesStr)));
            }
        }
    }

    private static double milesTokm(String milesDist) {

        return Double.parseDouble(milesDist) * 1.60934;
    }

    private static double kmTomiles(String distanceInKm) {
        return Double.parseDouble(distanceInKm) * 0.621371;
    }

}
