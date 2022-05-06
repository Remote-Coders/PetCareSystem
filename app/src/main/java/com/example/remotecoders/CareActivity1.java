package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CareActivity1 extends AppCompatActivity {

    ImageView vetcusbtn;
    ImageView petsittingcusbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care1);

        vetcusbtn = findViewById(R.id.VetCusbtn);
        petsittingcusbtn = findViewById(R.id.PetSittingCusbtn);

        vetcusbtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(CareActivity1.this,CareActivity3.class);
                                          startActivity(intent);
                                      }
                                  }


        );

        petsittingcusbtn.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {
                                                 Intent intent = new Intent(CareActivity1.this,CareActivity5.class);
                                                 startActivity(intent);
                                             }
                                         }


        );
    }
}