package com.example.getfit.Workout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.getfit.R;


public class FatLossFragment extends Fragment {

    TextView tv1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fat_loss, container, false);

        tv1 = v.findViewById(R.id.muscleG_fragment_tv2);
        tv1.setText("BMI calculated with a higher level than required needs to follow this workout package.");

        return v;

    }
}