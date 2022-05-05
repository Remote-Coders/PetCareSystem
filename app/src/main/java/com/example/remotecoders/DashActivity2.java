package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashActivity2 extends AppCompatActivity {
    Button dogbtn;
    Button catbtn;
    Button rabbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash2);

        dogbtn = findViewById(R.id.btndog);
        catbtn = findViewById(R.id.btncat);
        rabbtn = findViewById(R.id.btnrab);

        dogbtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(DashActivity2.this,DashActivity1.class);
                                          startActivity(intent);
                                      }
                                  }


        );

        catbtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(DashActivity2.this,DashActivity3.class);
                                          startActivity(intent);
                                      }
                                  }


        );

        rabbtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(DashActivity2.this,DashActivity4.class);
                                          startActivity(intent);
                                      }
                                  }


        );

    }
}