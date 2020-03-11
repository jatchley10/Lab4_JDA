package com.example.tablayoutdemo;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment implements OnClickListener {


    TextView fahText, celText ;
    public Tab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        fahText = (TextView) view.findViewById(R.id.fahEdit);
        celText = (TextView) view.findViewById(R.id.celEdit) ;

        Button b = (Button)view.findViewById(R.id.convertBtn);
        b.setOnClickListener( this );

        return view;
    }

    @Override
    public void onClick(View v) {

        /* the body f your method goes here */
        String fahrenheit, celcius;
        fahrenheit = fahText.getText().toString();
        celcius = celText.getText().toString();
        if(fahrenheit.isEmpty() && celcius.isEmpty()){
            //do nothing
            Toast t = Toast.makeText(this.getContext(), "At least one of the fields must be populated", Toast.LENGTH_SHORT);
            t.show();
        }

        else if(!fahrenheit.isEmpty() && !celcius.isEmpty()){
            //Convert from fahrenheit to celcius by default
            celText.setText(Double.toString(convertToCelcius(fahrenheit)));
        }
        else{
            // this means we have a valid entry and should do a conversion
            if(!fahrenheit.isEmpty()){
                celText.setText(Double.toString(convertToCelcius(fahrenheit)));
            }
            else {
                fahText.setText(Double.toString(convertToFahrenheit(celcius)));
            }
        }
    }
    static double convertToCelcius(String f)
    {
        double fahTemp = Double.parseDouble(f);
        return  (fahTemp-32)*5/9;
    }

    static double convertToFahrenheit(String c){
        double celTemp = Double.parseDouble(c);
        double fahrenheit = (9.0/5.0)*celTemp + 32;
        return fahrenheit;
    }
}
