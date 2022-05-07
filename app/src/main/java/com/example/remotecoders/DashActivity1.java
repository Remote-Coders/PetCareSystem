package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashActivity1 extends AppCompatActivity {

    private Button button;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash1);

        button = findViewById(R.id.button24);
        button1 = findViewById(R.id.button37);

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(DashActivity1.this,PetActivity2.class);
                                          startActivity(intent);
                                      }
                                  }


        );

        button1.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(DashActivity1.this,petActivity1.class);
                                          startActivity(intent);
                                      }
                                  }


        );
    }
}