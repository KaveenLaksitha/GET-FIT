package com.example.getfit.ToDo_List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.getfit.R;
import com.example.getfit.ToDo_List.Database.UserManagementDBHelper;

public class UserProfile extends AppCompatActivity {

    EditText SignUpName, SignUpEmail, SignUpGender, SignUpHeight, SignUpWeight, SignUpAge;
    Button UPbtnUpdate, UPtxtDelete;

    String user,ema,gen;
    float wei,hei;
    int age;


    UserManagementDBHelper userManagementDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        user = getIntent().getStringExtra("username");

        SignUpName = findViewById(R.id.SignUpName);
        SignUpEmail = findViewById(R.id.SignUpEmail);
        SignUpGender = findViewById(R.id.SignUpGender);
        SignUpHeight = findViewById(R.id.SignUpHeight);
        SignUpWeight = findViewById(R.id.SignUpWeight);
        SignUpAge = findViewById(R.id.SignUpAge);

        UPbtnUpdate = findViewById(R.id.UPbtnUpdate);
        UPtxtDelete = findViewById(R.id.UPtxtDelete);


        userManagementDBHelper = new UserManagementDBHelper(getApplicationContext());
        Cursor cursor = userManagementDBHelper.retriveDataUserProfile(user);

        if (cursor.moveToFirst()) {
            SignUpName.setText(user);
            SignUpEmail.setText(cursor.getString(1));
            SignUpGender.setText(cursor.getString(3));
            SignUpHeight.setText(cursor.getString(4));
            SignUpWeight.setText(cursor.getString(5));
            SignUpAge.setText(cursor.getString(6));
        }

        UPbtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //UserManagementDBHelper userManagementDBHelper = new UserManagementDBHelper(UserProfile.this);
                user = SignUpName.getText().toString().trim();
                ema = SignUpEmail.getText().toString().trim();
                gen = SignUpGender.getText().toString().trim();
                hei = Float.valueOf(SignUpHeight.getText().toString().trim());
                wei = Float.valueOf(SignUpWeight.getText().toString().trim());
                age = Integer.valueOf(SignUpAge.getText().toString().trim());

                userManagementDBHelper.updateUserProfile(user,ema,gen,hei,wei,age);

            }
        });
        UPtxtDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDeleteAccountBox();
                //Intent intent = new Intent(UserProfile.this,SignUp.class);
                confirmDeleteAccountBox();
                //startActivity(intent);
            }
        });

    }

    void confirmDeleteAccountBox(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + user + " ?");
        builder.setMessage("Are you sure you want to delete " + user + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                UserManagementDBHelper userManagementDBHelper = new UserManagementDBHelper(UserProfile.this);
                userManagementDBHelper.deleteAccount(user);
                finish();
                Intent intent =new Intent(UserProfile.this,SignUp.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}