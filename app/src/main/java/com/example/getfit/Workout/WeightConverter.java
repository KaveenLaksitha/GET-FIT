package com.example.getfit.Workout;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.getfit.R;

public class WeightConverter extends AppCompatActivity {

    EditText weight;
    RadioGroup radioGroup;
    RadioButton weight_radioBtn1;
    RadioButton weight_radioBtn2;
    RadioButton weight_radioBtn3;
    float weightValue;
    TextView weight_tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_converter);

        weight =findViewById(R.id.weight_etnd1);
        weight_tv2 =findViewById(R.id.weight_tv2);
        radioGroup =findViewById(R.id.weight_radioGrp);
        weight_radioBtn1 =findViewById(R.id.weight_radioBtn1);
        weight_radioBtn2 =findViewById(R.id.weight_radioBtn2);
        weight_radioBtn3 =findViewById(R.id.weight_radioBtn3);

    }


    public void calculateWeight(View view){
        weightValue =  Float.parseFloat(weight.getText().toString());

        if(weight_radioBtn1.isChecked()){
            float value = (float) (weightValue * 2.205f);
            weight_tv2.setText("Your Weight is "+value+" pounds");
        }else if(weight_radioBtn2.isChecked()){
            float value = (float) (weightValue / 2.205f);
            weight_tv2.setText("Your Weight is "+value+" kilograms");
        }else if (weight_radioBtn3.isChecked()){
            float value = (float) (weightValue / 6.34f);
            weight_tv2.setText("Your Weight is "+value+" stones");
        }

        emptyForm();
    }

    public void emptyForm(){
        weight.setText("");
        weight_radioBtn1.setChecked(false);
        weight_radioBtn2.setChecked(false);
        weight_radioBtn3.setChecked(false);
    }
}