package com.example.getfit.Workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.getfit.Nutrition.MainActivity;
import com.example.getfit.Nutrition.ViewMeals;
import com.example.getfit.R;
import com.example.getfit.Supplement.ViewSupplement;
import com.example.getfit.ToDo_List.To_Do_List;

public class WorkOuts extends AppCompatActivity {

    //navigation bar buttons
    Button navigate_todo,navigate_workout,navigate_nutrition,navigate_supplement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_outs);

        navigate_nutrition = findViewById(R.id.navigate_nutrition);
        navigate_supplement = findViewById(R.id.navigate_supplement);
        navigate_todo =findViewById(R.id.navigate_todo);
        navigate_workout = findViewById(R.id.navigate_workout);
    }

    //lower navigation bar button page directions
    protected void onResume() {
        super.onResume();

        navigate_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkOuts.this, To_Do_List.class);
                startActivity(intent);
            }
        });

        navigate_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkOuts.this, WorkOuts.class);
                startActivity(intent);

            }
        });

        navigate_nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkOuts.this, ViewMeals.class);
                startActivity(intent);

            }
        });

        navigate_supplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WorkOuts.this, ViewSupplement.class);
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