package com.example.getfit.Workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.getfit.R;

public class AddExercise extends AppCompatActivity {

    EditText addExe_etn1, addExe_etn2,addExe_etn3;
    EditText addExe_etv1;
    EditText addExe_emt1;
    Button addExe_btn;
    Spinner addExe_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        addExe_etn1 = findViewById(R.id.addExe_etn1);//workout id
        addExe_etn2 = findViewById(R.id.addExe_etn2);//time duration
        addExe_etn3 = findViewById(R.id.addExe_etn3);//calorie burnout

        addExe_etv1 = findViewById(R.id.addExe_etv1);//workout name
        addExe_emt1 = findViewById(R.id.addExe_emt1);//steps in the workout

        addExe_spinner = (Spinner)(findViewById(R.id.addExe_spinner));//packageType

        addExe_btn =findViewById(R.id.addExe_btn);//add button
        
    }
}