package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class AdminActivityAds extends AppCompatActivity {

    RelativeLayout btnvet;
    RelativeLayout petsittingbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ads);

        btnvet = findViewById(R.id.btn_addvet);
        petsittingbtn = findViewById(R.id.btn_petSitting);

        btnvet.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(AdminActivityAds.this,AdminVetCrudActivity.class);
                                          startActivity(intent);
                                      }
                                  }


        );

        petsittingbtn.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {
                                                 Intent intent = new Intent(AdminActivityAds.this,AdminPetSittiingCrudActivity.class);
                                                 startActivity(intent);
                                             }
                                         }


        );


    }
}