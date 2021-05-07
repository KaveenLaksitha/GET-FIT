package com.example.getfit.Supplement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.getfit.R;
import com.example.getfit.ToDo_List.Database.UserAdapter;
import com.example.getfit.ToDo_List.To_Do_List;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ViewSupplement extends AppCompatActivity {

    FloatingActionButton add_sup_btn;


    ArrayList<String> sup_id,sup_name, sup_price, sup_description;
    CustomAdapter customAdapter;
    RecyclerView recycler;

    MyDatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_supplement);

        recycler = findViewById(R.id.recycler);
        add_sup_btn = findViewById(R.id.add_sup_btn);

        add_sup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ViewSupplement.this, AddSupplement.class);
                startActivity(myIntent);
            }
        });

        myDB = new MyDatabaseHelper(ViewSupplement.this);

        sup_id = new ArrayList<>();
        sup_name = new ArrayList<>();
        sup_price = new ArrayList<>();
        sup_description = new ArrayList<>();

        storeDataInArray();

        customAdapter = new CustomAdapter(ViewSupplement.this, this,sup_id, sup_name, sup_price, sup_description);
        recycler.setAdapter(customAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(ViewSupplement.this));


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

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_supplement,menu);
        return  super.onCreateOptionsMenu(menu);

    }
    public boolean onOptionsItemSelected(MenuItem item){



        if(item.getItemId() == R.id.delete_all){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirm deletion");
            builder.setMessage("Are you sure want to delete all ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(ViewSupplement.this);
                    myDB.deleteAllData();
                    finish();
                    Intent intent = new Intent(ViewSupplement.this,ViewSupplement.class);
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.create().show();


            /*Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show();
            MyDatabaseHelper myDB = new MyDatabaseHelper(this);
            myDB.deleteAllData();
            //Refresh Activity
            Intent intent = new Intent(this,ViewSupplement.class);
            startActivity(intent);
            finish();*/
        }

        return super.onOptionsItemSelected(item);
    }
}

