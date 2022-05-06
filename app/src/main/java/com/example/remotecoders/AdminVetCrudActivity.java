package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class AdminVetCrudActivity extends AppCompatActivity {

    RelativeLayout btnaddvet;
    RelativeLayout btnviewvet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_vet_crud);

        btnaddvet = findViewById(R.id.btn_addvet);
        btnviewvet = findViewById(R.id.btn_viewVet);

        btnaddvet.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(AdminVetCrudActivity.this,AdminActivityAddVet.class);
                                          startActivity(intent);
                                      }
                                  }


        );

        btnviewvet.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {
                                                 Intent intent = new Intent(AdminVetCrudActivity.this,AdminActivityViewVet.class);
                                                 startActivity(intent);
                                             }
                                         }


        );
    }
}