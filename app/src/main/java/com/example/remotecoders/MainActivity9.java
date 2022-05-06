package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity9 extends AppCompatActivity {
    ImageView dogfoodbtn;
    ImageView catfoodbtn;
    ImageView rabbitfoodbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        dogfoodbtn=findViewById(R.id.dogfood_1);
        catfoodbtn=findViewById(R.id.dogfood_2);
        rabbitfoodbtn=findViewById(R.id.dogfood_3);

        dogfoodbtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent = new Intent(MainActivity9.this,MainActivity10.class);
                   startActivity(intent);
               }
           }
        );

    }
}