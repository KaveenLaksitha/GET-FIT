package com.example.getfit.Supplement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.getfit.R;

public class SupDashboard extends AppCompatActivity {

    Button addsup1, viewsup1, updatesup1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sup_dashboard);

        addsup1 = findViewById(R.id.addsup1);
        viewsup1 = findViewById(R.id.viewsup1);
        updatesup1 = findViewById(R.id.updatesup1);

        addsup1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupDashboard.this,AddSupplement.class);
                startActivity(intent);
            }
        });

        viewsup1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupDashboard.this,ViewSupplement.class);
                startActivity(intent);

            }
        });

        updatesup1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupDashboard.this,UpdateSupplement.class);
                startActivity(intent);

            }
        });



    }
}