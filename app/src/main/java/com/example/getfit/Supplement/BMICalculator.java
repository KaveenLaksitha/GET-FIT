package com.example.getfit.Supplement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.getfit.Nutrition.MainActivity;
import com.example.getfit.Nutrition.ViewMeals;
import com.example.getfit.R;
import com.example.getfit.ToDo_List.To_Do_List;
import com.example.getfit.Workout.WorkOuts;

public class BMICalculator extends AppCompatActivity {

    Button navigate_todo,navigate_workout,navigate_nutrition,navigate_supplement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i_calculator);

        EditText edWeg,edHei;
        TextView txtRes, txtInter;
        Button btnRes,btnReset;

        edWeg =(EditText) findViewById(R.id.edweg);
        edHei = (EditText) findViewById(R.id.edhei);

        txtInter = (TextView) findViewById(R.id.txtinter);
        txtRes = (TextView) findViewById(R.id.txtres);

        btnRes = (Button) findViewById(R.id.btnres);
        btnReset= (Button) findViewById(R.id.btnreset);

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strweg= edWeg.getText().toString();
                String strhei= edHei.getText().toString();

                if(strweg.equals("")){
                    edWeg.setError("Please Enter Your Weight");
                    edWeg.requestFocus();
                    return;
                }
                if(strhei.equals("")){
                    edHei.setError("Please Enter Your height");
                    edHei.requestFocus();
                    return;
                }

                float weight = Float.parseFloat(strweg);
                float height = Float.parseFloat(strhei)/100;

                float bmiValue = BMICalculator(weight,height);

                txtInter.setText(interpreteBMI(bmiValue));
                txtRes.setText("BMI= "+bmiValue);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edHei.setText("");
                edWeg.setText("");
                txtInter.setText("");
                txtRes.setText("");
            }
        });
        //bottom navigation bar
        navigate_todo = findViewById(R.id.navigate_todo);
        navigate_workout = findViewById(R.id.navigate_workout);
        navigate_nutrition = findViewById(R.id.navigate_nutrition);
        navigate_supplement = findViewById(R.id.navigate_supplement);

        //redirects to todoList
        navigate_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BMICalculator.this, To_Do_List.class);
                startActivity(intent);

            }
        });

        //redirects to workout
        navigate_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BMICalculator.this, WorkOuts.class);
                startActivity(intent);

            }
        });

        //redirects to meal list
        navigate_nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BMICalculator.this, ViewMeals.class);
                startActivity(intent);

            }
        });

        //redirects to supplement list
        navigate_supplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BMICalculator.this, ViewSupplement.class);
                startActivity(intent);

            }
        });

    }
    //BMI Calculator
    public float BMICalculator(float weight, float height){
        return weight / (height * height);
    }
    public String interpreteBMI(float bmiValue){
        if(bmiValue <16){
            return "Servely Underweight";
        }
        else if (bmiValue < 18.5){
            return "Underweight";
        }
        else if (bmiValue < 25){
            return "Normal";
        }
        else if (bmiValue <30){
            return "Overweight";
        }
        else
            return "Obese";
    }



}


