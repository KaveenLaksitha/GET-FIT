package com.example.getfit.Workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.getfit.R;

public class WorkOuts extends AppCompatActivity {

    Button todoBtn;
    Button btn3;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_outs);

        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        todoBtn =findViewById(R.id.todoBtn);
    }

    protected void onResume() {
        super.onResume();

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkOuts.this, WorkoutDashBoard.class);
                startActivity(intent);
            }
        });
    }

    public void changeFragment(View view){

        Fragment fragment;//object or the variable name must always be in simple letters

        if(view == findViewById(R.id.pckg_btn1)){//checking if we clicked the fragment 1 button
            fragment = new MuscleGainFragment();//fragment 1 object is created
            FragmentManager fm = getSupportFragmentManager();//make an object of fragment
            FragmentTransaction ft = fm.beginTransaction();//using the fragment manager object then we create an fragmnet transaction objetct
            ft.replace(R.id.fgmntDefault,fragment);//we can have add.replace or remove fragment options
            ft.commit();//at this point transaction finishes
        }

        if(view == findViewById(R.id.pckg_btn2)){
            fragment = new FatLossFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fgmntDefault,fragment);
            ft.commit();
        }

    }


}