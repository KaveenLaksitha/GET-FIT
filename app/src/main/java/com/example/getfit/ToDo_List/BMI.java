package com.example.getfit.ToDo_List;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.getfit.Nutrition.MainActivity;
import com.example.getfit.R;

public class BMI extends AppCompatActivity {

    TextView SignUpHeight, SignUpWeight, SignUpAge;
    TextView BMIResult, txtResultHbmi, txtResultHweight;
    Button getfitBMI;


    String H, W, A;

    float finalheight, finalweight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

        String userName = getIntent().getStringExtra("username");

        SignUpHeight = findViewById(R.id.SignUpHeight);
        SignUpWeight = findViewById(R.id.SignUpWeight);
        SignUpAge = findViewById(R.id.SignUpAge);
        BMIResult = findViewById(R.id.BMIResult);
        txtResultHbmi = findViewById(R.id.txtResultHbmi);
        txtResultHweight = findViewById(R.id.txtResultHweight);
        getfitBMI = findViewById(R.id.getfitBMI);

        getfitBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BMI.this, MainActivity.class);

                intent.putExtra("username",userName);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();

        H = intent.getStringExtra("height");
        W = intent.getStringExtra("weight");
        A = intent.getStringExtra("age");

        SignUpHeight.setText(H);
        SignUpWeight.setText(W);
        SignUpAge.setText(A);
        finalheight = Float.valueOf(H);
        finalweight = Float.valueOf(W);

        float healthybmi = calculate(finalheight, finalweight);

        BMIResult.setText("BMI =" + healthybmi);
        showhealthyBMI(healthybmi, finalheight);


    }

    public float calculate(float finalheight, float finalweight) {
        return finalweight / ((finalheight / 100) * (finalheight / 100));
    }

    public void showhealthyBMI(float healthybmi, float finalheight) {
        if ((healthybmi == 18.49) || (healthybmi < 18.49)) {
            txtResultHbmi.setText("Under Weight");
            if (finalheight < 149) {
                txtResultHweight.setText("40kg - 52kg");
            } else if ((finalheight > 149) &&(finalheight == 149) &&  (finalheight < 152)) {
                txtResultHweight.setText("41kg - 54kg");
            } else if ((finalheight > 152) && (finalheight == 152) && (finalheight < 154)) {
                txtResultHweight.setText("45kg - 56kg");
            } else if ((finalheight > 154) && (finalheight == 154) && (finalheight < 157)) {
                txtResultHweight.setText("45kg - 59kg");
            } else if ((finalheight > 157) && (finalheight == 157) && (finalheight < 160)) {
                txtResultHweight.setText("47kg - 61kg");
            } else if ((finalheight > 160) && (finalheight == 160) &&(finalheight < 162)) {
                txtResultHweight.setText("47kg - 63kg");
            } else if ((finalheight > 162) && (finalheight == 162) && (finalheight < 165)) {
                txtResultHweight.setText("50kg - 65kg");
            } else if ((finalheight > 165) && (finalheight == 165) && (finalheight < 167)) {
                txtResultHweight.setText("52kg - 65kg");
            } else if ((finalheight > 167) && (finalheight == 167) &&(finalheight < 170)) {
                txtResultHweight.setText("52kg - 68kg");
            } else if ((finalheight > 170) && (finalheight == 170) && (finalheight < 172)) {
                txtResultHweight.setText("54kg - 70kg");
            } else if ((finalheight > 172) && (finalheight == 172) && (finalheight < 177)) {
                txtResultHweight.setText("56kg - 72kg");
            } else if ((finalheight > 177) && (finalheight == 177) &&(finalheight < 180)) {
                txtResultHweight.setText("59kg - 75kg");
            } else if ((finalheight > 180) && (finalheight == 180) &&(finalheight < 182)) {
                txtResultHweight.setText("59kg - 77kg");
            } else if ((finalheight > 182) && (finalheight == 182) && (finalheight < 185)) {
                txtResultHweight.setText("63kg - 81kg");
            } else if ((finalheight > 185) && (finalheight == 185) &&(finalheight < 187)) {
                txtResultHweight.setText("63kg - 84kg");
            } else if ((finalheight > 187) && (finalheight == 187) && (finalheight < 190)) {
                txtResultHweight.setText("65kg - 86kg");
            } else if ((finalheight > 190) && (finalheight == 190) && (finalheight < 193)) {
                txtResultHweight.setText("68kg - 88kg");
            } else {
                txtResultHweight.setText("70kg - 90kg");
            }

        }

        else if (((healthybmi == 18.5) || (healthybmi > 18.5)) && ((healthybmi == 24.99) || (healthybmi < 24.99))) {
                txtResultHbmi.setText("Normal Weight");
                if (finalheight < 149) {
                    txtResultHweight.setText("40kg - 52kg");
                } else if ((finalheight > 149) &&(finalheight == 149) &&  (finalheight < 152)) {
                    txtResultHweight.setText("41kg - 54kg");
                } else if ((finalheight > 152) && (finalheight == 152) && (finalheight < 154)) {
                    txtResultHweight.setText("45kg - 56kg");
                } else if ((finalheight > 154) && (finalheight == 154) && (finalheight < 157)) {
                    txtResultHweight.setText("45kg - 59kg");
                } else if ((finalheight > 157) && (finalheight == 157) && (finalheight < 160)) {
                    txtResultHweight.setText("47kg - 61kg");
                } else if ((finalheight > 160) && (finalheight == 160) &&(finalheight < 162)) {
                    txtResultHweight.setText("47kg - 63kg");
                } else if ((finalheight > 162) && (finalheight == 162) && (finalheight < 165)) {
                    txtResultHweight.setText("50kg - 65kg");
                } else if ((finalheight > 165) && (finalheight == 165) && (finalheight < 167)) {
                    txtResultHweight.setText("52kg - 65kg");
                } else if ((finalheight > 167) && (finalheight == 167) &&(finalheight < 170)) {
                    txtResultHweight.setText("52kg - 68kg");
                } else if ((finalheight > 170) && (finalheight == 170) && (finalheight < 172)) {
                    txtResultHweight.setText("54kg - 70kg");
                } else if ((finalheight > 172) && (finalheight == 172) && (finalheight < 177)) {
                    txtResultHweight.setText("56kg - 72kg");
                } else if ((finalheight > 177) && (finalheight == 177) &&(finalheight < 180)) {
                    txtResultHweight.setText("59kg - 75kg");
                } else if ((finalheight > 180) && (finalheight == 180) &&(finalheight < 182)) {
                    txtResultHweight.setText("59kg - 77kg");
                } else if ((finalheight > 182) && (finalheight == 182) && (finalheight < 185)) {
                    txtResultHweight.setText("63kg - 81kg");
                } else if ((finalheight > 185) && (finalheight == 185) &&(finalheight < 187)) {
                    txtResultHweight.setText("63kg - 84kg");
                } else if ((finalheight > 187) && (finalheight == 187) && (finalheight < 190)) {
                    txtResultHweight.setText("65kg - 86kg");
                } else if ((finalheight > 190) && (finalheight == 190) && (finalheight < 193)) {
                    txtResultHweight.setText("68kg - 88kg");
                } else {
                    txtResultHweight.setText("70kg - 90kg");
                }

                }
            else if (((healthybmi == 25) || (healthybmi > 25)) && ((healthybmi == 29.99) || (healthybmi < 29.99))) {
                    txtResultHbmi.setText("OVER WEIGHT");
            if (finalheight < 149) {
                txtResultHweight.setText("40kg - 52kg");
            } else if ((finalheight > 149) &&(finalheight == 149) &&  (finalheight < 152)) {
                txtResultHweight.setText("41kg - 54kg");
            } else if ((finalheight > 152) && (finalheight == 152) && (finalheight < 154)) {
                txtResultHweight.setText("45kg - 56kg");
            } else if ((finalheight > 154) && (finalheight == 154) && (finalheight < 157)) {
                txtResultHweight.setText("45kg - 59kg");
            } else if ((finalheight > 157) && (finalheight == 157) && (finalheight < 160)) {
                txtResultHweight.setText("47kg - 61kg");
            } else if ((finalheight > 160) && (finalheight == 160) &&(finalheight < 162)) {
                txtResultHweight.setText("47kg - 63kg");
            } else if ((finalheight > 162) && (finalheight == 162) && (finalheight < 165)) {
                txtResultHweight.setText("50kg - 65kg");
            } else if ((finalheight > 165) && (finalheight == 165) && (finalheight < 167)) {
                txtResultHweight.setText("52kg - 65kg");
            } else if ((finalheight > 167) && (finalheight == 167) &&(finalheight < 170)) {
                txtResultHweight.setText("52kg - 68kg");
            } else if ((finalheight > 170) && (finalheight == 170) && (finalheight < 172)) {
                txtResultHweight.setText("54kg - 70kg");
            } else if ((finalheight > 172) && (finalheight == 172) && (finalheight < 177)) {
                txtResultHweight.setText("56kg - 72kg");
            } else if ((finalheight > 177) && (finalheight == 177) &&(finalheight < 180)) {
                txtResultHweight.setText("59kg - 75kg");
            } else if ((finalheight > 180) && (finalheight == 180) &&(finalheight < 182)) {
                txtResultHweight.setText("59kg - 77kg");
            } else if ((finalheight > 182) && (finalheight == 182) && (finalheight < 185)) {
                txtResultHweight.setText("63kg - 81kg");
            } else if ((finalheight > 185) && (finalheight == 185) &&(finalheight < 187)) {
                txtResultHweight.setText("63kg - 84kg");
            } else if ((finalheight > 187) && (finalheight == 187) && (finalheight < 190)) {
                txtResultHweight.setText("65kg - 86kg");
            } else if ((finalheight > 190) && (finalheight == 190) && (finalheight < 193)) {
                txtResultHweight.setText("68kg - 88kg");
            } else {
                txtResultHweight.setText("70kg - 90kg");
            }

        }

            else {
                        txtResultHbmi.setText("OBESE");
            if (finalheight < 149) {
                txtResultHweight.setText("40kg - 52kg");
            } else if ((finalheight > 149) &&(finalheight == 149) &&  (finalheight < 152)) {
                txtResultHweight.setText("41kg - 54kg");
            } else if ((finalheight > 152) && (finalheight == 152) && (finalheight < 154)) {
                txtResultHweight.setText("45kg - 56kg");
            } else if ((finalheight > 154) && (finalheight == 154) && (finalheight < 157)) {
                txtResultHweight.setText("45kg - 59kg");
            } else if ((finalheight > 157) && (finalheight == 157) && (finalheight < 160)) {
                txtResultHweight.setText("47kg - 61kg");
            } else if ((finalheight > 160) && (finalheight == 160) &&(finalheight < 162)) {
                txtResultHweight.setText("47kg - 63kg");
            } else if ((finalheight > 162) && (finalheight == 162) && (finalheight < 165)) {
                txtResultHweight.setText("50kg - 65kg");
            } else if ((finalheight > 165) && (finalheight == 165) && (finalheight < 167)) {
                txtResultHweight.setText("52kg - 65kg");
            } else if ((finalheight > 167) && (finalheight == 167) &&(finalheight < 170)) {
                txtResultHweight.setText("52kg - 68kg");
            } else if ((finalheight > 170) && (finalheight == 170) && (finalheight < 172)) {
                txtResultHweight.setText("54kg - 70kg");
            } else if ((finalheight > 172) && (finalheight == 172) && (finalheight < 177)) {
                txtResultHweight.setText("56kg - 72kg");
            } else if ((finalheight > 177) && (finalheight == 177) &&(finalheight < 180)) {
                txtResultHweight.setText("59kg - 75kg");
            } else if ((finalheight > 180) && (finalheight == 180) &&(finalheight < 182)) {
                txtResultHweight.setText("59kg - 77kg");
            } else if ((finalheight > 182) && (finalheight == 182) && (finalheight < 185)) {
                txtResultHweight.setText("63kg - 81kg");
            } else if ((finalheight > 185) && (finalheight == 185) &&(finalheight < 187)) {
                txtResultHweight.setText("63kg - 84kg");
            } else if ((finalheight > 187) && (finalheight == 187) && (finalheight < 190)) {
                txtResultHweight.setText("65kg - 86kg");
            } else if ((finalheight > 190) && (finalheight == 190) && (finalheight < 193)) {
                txtResultHweight.setText("68kg - 88kg");
            } else {
                txtResultHweight.setText("70kg - 90kg");
            }

        }
    }
}
