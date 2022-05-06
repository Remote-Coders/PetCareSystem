package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button foodbtn;

    Button adsBtn;

    Button pets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        adsBtn = findViewById(R.id.btn_Ads);

        adsBtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(MainActivity2.this, AdminActivityAds.class);
                                          startActivity(intent);
                                      }
                                  }
      );

        pets = findViewById(R.id.btn_pets);
        pets.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(MainActivity2.this,DashActivity2.class);
                                          startActivity(intent);
                                      }
                                  }



        );

        foodbtn=findViewById(R.id.btn_view_food);

        foodbtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(MainActivity2.this,MainActivity4.class);
                  startActivity(intent);
              }
          }
          );

    }
}