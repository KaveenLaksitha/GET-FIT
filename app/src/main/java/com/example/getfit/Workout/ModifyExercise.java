package com.example.getfit.Workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.getfit.R;
import com.example.getfit.Workout.DataBase.DBHelper;

public class ModifyExercise extends AppCompatActivity {

    EditText modifyExe_etn1,modifyExe_etn3,modifyExe_etn2;
    EditText modifyExe_etv1,modifyExe_packageType;
    EditText modifyExe_emt1;

    Button modifyExe_btn1, modifyExe_btn2,modifyExe_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_exercise);

        modifyExe_etn1 =findViewById(R.id.modifyExe_etn1);//workoutId
        modifyExe_etn2 =findViewById(R.id.modifyExe_etn2);//duration
        modifyExe_etn3 =findViewById(R.id.modifyExe_etn3);//calories

        modifyExe_etv1 =findViewById(R.id.modifyExe_etv1);//workoutName
        modifyExe_packageType =findViewById(R.id.modifyExe_packageType);//package

        modifyExe_emt1 = findViewById(R.id.modifyExe_emt1);//steps

        modifyExe_btn1 = findViewById(R.id.modifyExe_btn1);//delete
        modifyExe_btn2 = findViewById(R.id.modifyExe_btn2);//update
        modifyExe_btn3 = findViewById(R.id.modifyExe_btn3);//view


        Intent intent = getIntent();

        String workoutID = intent.getStringExtra("id");
        String workoutName = intent.getStringExtra("name");
        String workoutPkg = intent.getStringExtra("pkg");
        String workoutDuration = intent.getStringExtra("due");
        String workoutCalorie = intent.getStringExtra("cal");
        String workoutStep = intent.getStringExtra("step");


        modifyExe_etn1.setText(workoutID);
        modifyExe_etv1.setText(workoutName);
        modifyExe_packageType.setText(workoutPkg);
        modifyExe_etn3.setText(workoutCalorie);
        modifyExe_etn2.setText(workoutDuration);
        modifyExe_emt1.setText(workoutStep);

        modifyExe_etn1.setEnabled(false);

    }


    public void deleteWorkOutData(View view){
        DBHelper dbHelper = new DBHelper(this);

        boolean res= dbHelper.deleteWorkOutInfo(modifyExe_etn1.getText().toString());
        boolean result = dbHelper.deleteImageInfo(modifyExe_etn1.getText().toString());

        if(res == true && result== true){
            Toast.makeText(this, modifyExe_etv1.getText().toString()+"Data deleted successfully",Toast.LENGTH_LONG).show();
            Intent listIntent =  new Intent(ModifyExercise.this,AllExercises.class);
            startActivity(listIntent);
        }else{
            Toast.makeText(this, "Unsuccessfully",Toast.LENGTH_SHORT).show();
        }
    }


    public void updateWorkOutData(View view){
        try {

            if (TextUtils.isEmpty(modifyExe_etn1.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please enter a workoutId", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty( modifyExe_etv1.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please enter a workout Name", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(modifyExe_packageType.getText().toString()) ){
                Toast.makeText(getApplicationContext(), "Please enter Correct Package Name", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(modifyExe_etn3.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please enter Calorie amount", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(modifyExe_etn2.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please enter Duration", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(modifyExe_emt1.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please enter Steps", Toast.LENGTH_SHORT).show();
            } else {
                DBHelper dbHelper = new DBHelper(this);

                int val = dbHelper.updateWorkOutInfo(modifyExe_etn1.getText().toString(),
                        modifyExe_etv1.getText().toString(),
                        modifyExe_packageType.getText().toString(),
                        Integer.parseInt(modifyExe_etn3.getText().toString()),
                        Integer.parseInt(modifyExe_etn2.getText().toString()),
                        modifyExe_emt1.getText().toString());

                if (val > 0) {
                    Toast.makeText(this, modifyExe_etv1.getText().toString()+"Data Successfully updated !", Toast.LENGTH_LONG).show();
                    Intent listIntent = new Intent(ModifyExercise.this, AllExercises.class);
                    startActivity(listIntent);
                } else {
                    Toast.makeText(this, "Data Cannot be Updated Recheck!", Toast.LENGTH_SHORT).show();
                }
            }
        }catch(NumberFormatException e){

            Toast.makeText(getApplicationContext(),"Invalid Number inserted check again",Toast.LENGTH_SHORT).show();
        }
    }

    public void resetFields(View view){
        modifyExe_etn3.setText("");
        modifyExe_etn2.setText("");
        modifyExe_emt1.setText("");
    }

    public void goToViewImage(View view){
        Intent viewImage = new Intent(ModifyExercise.this,ViewExerciseImage.class);
        modifyExe_etn1.setEnabled(true);
        String id = modifyExe_etn1.getText().toString();
        viewImage.putExtra("imageID",id);
        startActivity(viewImage);
    }

}