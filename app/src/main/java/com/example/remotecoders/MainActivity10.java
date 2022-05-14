package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity10 extends AppCompatActivity {
    RecyclerView recyclerview;
    foodAdapter2 adapter2;
    RelativeLayout food_view_rela;

    //11 badu
    TextView itemname,price;
    EditText quantity;
    Button buttonCart;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        food_view_rela=(RelativeLayout)findViewById(R.id.food_view_rela);
        //recyclerview.setLayoutManager(new LinearLayoutManager(this));
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerview.setLayoutManager(gridLayoutManager);

        FirebaseRecyclerOptions<ModelFood> options =
                new FirebaseRecyclerOptions.Builder<ModelFood>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Food"), ModelFood.class)
                        .build();

        adapter2=new foodAdapter2(options);
        recyclerview.setAdapter(adapter2);

        //11
        itemname=findViewById(R.id.tv_foodtype);
        price=findViewById(R.id.tv_oldprice);
        quantity=findViewById(R.id.et_quantity);
        buttonCart=findViewById(R.id.buttonCart);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter2.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter2.stopListening();
    }

}