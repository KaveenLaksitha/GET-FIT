package com.example.getfit.Workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.getfit.R;
import com.example.getfit.Workout.DataBase.DBHelper;
import com.example.getfit.Workout.DataBase.WorkOut;
import com.example.getfit.Workout.DataBase.WorkOutMaster;

import java.util.ArrayList;
import java.util.List;

public class AllExercises extends AppCompatActivity {

    private ListView lworkout;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_exercises);

        lworkout = (ListView)findViewById(R.id.lworkouts);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);

        lworkout.setAdapter(adapter);


        viewAll();

    }


    public void viewAll(){
        DBHelper dbHelper = new DBHelper(this);

        List unames = dbHelper.readAllInfo();

        for(Object woName : unames){
            arrayList.add(woName.toString());
        }
        //Toast.makeText(this, unames.toString(),Toast.LENGTH_SHORT).show();

        lworkout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String listItemName = parent.getItemAtPosition(position).toString();
                WorkOut wt = new WorkOut();
                wt = dbHelper.readOneWorkOutInfo(listItemName);


                String woId = wt.getWorkoutID();
                String name = wt.getWorkoutName();
                String pkg = wt.getWorkoutPackage();
                String due = wt.getWorkoutDuration();
                String cal = wt.getWorkoutCalorie();
                String steps = wt.getWorkoutSteps();


                Intent intent = new Intent(AllExercises.this, ModifyExercise.class);
                intent.putExtra("id", woId);
                intent.putExtra("name", name);
                intent.putExtra("pkg", pkg);
                intent.putExtra("due", due);
                intent.putExtra("cal", cal);
                intent.putExtra("step", steps);
                startActivity(intent);

            }
        });
    }

}