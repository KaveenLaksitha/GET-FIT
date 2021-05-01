package com.example.getfit.Supplement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.getfit.R;

import java.util.ArrayList;

public class ViewSupplement extends AppCompatActivity {

    MyDatabaseHelper myDB;
    ArrayList<String> sup_id, sup_name, sup_price, sup_description;
    Button add_button;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_supplement);


        myDB = new MyDatabaseHelper(ViewSupplement.this);

        sup_id = new ArrayList<>();
        sup_name = new ArrayList<>();
        sup_price = new ArrayList<>();
        sup_description = new ArrayList<>();

        storeDataInArray();




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

