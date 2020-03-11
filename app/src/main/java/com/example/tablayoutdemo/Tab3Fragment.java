package com.example.tablayoutdemo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab3Fragment extends Fragment implements OnClickListener{

    TextView amtEdit, tipEdit, quantEdit;
    public Tab3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);
        amtEdit = (TextView) view.findViewById(R.id.amtEdit);
        tipEdit = (TextView) view.findViewById(R.id.tipEdit);
        quantEdit = (TextView) view.findViewById(R.id.sizeEdit);
        Button b = (Button)view.findViewById(R.id.calcButton);
        b.setOnClickListener( this );

        return view;
    }

    @Override
    public void onClick(View v) {

        String cost, tip, quant;

        cost = amtEdit.getText().toString();
        tip = tipEdit.getText().toString();
        quant = quantEdit.getText().toString();

        if(cost.isEmpty()){
            Toast t = Toast.makeText(this.getContext(), "Please enter the dinner cost.", Toast.LENGTH_SHORT);
            t.show();
        }

        else if(tip.isEmpty()){
            Toast t = Toast.makeText(this.getContext(), "Enter your tip amount", Toast.LENGTH_SHORT);
            t.show();
        }
        else if(quant.isEmpty()){
            Toast t = Toast.makeText(this.getContext(), "Enter the number of diners", Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            double totalCost = Double.parseDouble(cost) * (1+(Double.parseDouble(tip)/100));
            totalCost = totalCost / Double.parseDouble(quant);
            DecimalFormat df = new DecimalFormat("0.00");
            df.setRoundingMode(RoundingMode.UP);
            amtEdit.setText(df.format(totalCost));
        }

    }

}
