package com.example.getfit.Supplement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.getfit.R;

import java.util.ArrayList;

public class Supplementview_user extends AppCompatActivity {

    ArrayList<String> sup_id,sup_name, sup_price, sup_description;
    SupplementAdapter customAdapter;
    RecyclerView recycler;

    MyDatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplementview_user);

        recycler = findViewById(R.id.userSupView);


        myDB = new MyDatabaseHelper(Supplementview_user.this);

        sup_id = new ArrayList<>();
        sup_name = new ArrayList<>();
        sup_price = new ArrayList<>();
        sup_description = new ArrayList<>();

        storeDataInArray();

        customAdapter = new SupplementAdapter(Supplementview_user.this, this,sup_id, sup_name, sup_price, sup_description);
        recycler.setAdapter(customAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(Supplementview_user.this));


    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    void storeDataInArray(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                sup_id.add(cursor.getString(0));
                sup_name.add(cursor.getString(1));
                sup_price.add(cursor.getString(2));
                sup_description.add(cursor.getString(3));
            }
        }


    }
}