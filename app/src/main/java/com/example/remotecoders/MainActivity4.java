package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {
    Button addfoodbtn;
    Button viewfoodbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        addfoodbtn=findViewById(R.id.btn_add_food);
        viewfoodbtn=findViewById(R.id.btn_view_food);

        addfoodbtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
                   startActivity(intent);
               }
           }
        );
        viewfoodbtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(MainActivity4.this,MainActivity6.class);
                  startActivity(intent);
              }
          }
        );


    }
}