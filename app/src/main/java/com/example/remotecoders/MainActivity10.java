package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity10 extends AppCompatActivity {
    RecyclerView recyclerview;
    foodAdapter2 adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        //recyclerview.setLayoutManager(new LinearLayoutManager(this));
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerview.setLayoutManager(gridLayoutManager);

        FirebaseRecyclerOptions<ModelFood> options =
                new FirebaseRecyclerOptions.Builder<ModelFood>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Food"), ModelFood.class)
                        .build();

        adapter2=new foodAdapter2(options);
        recyclerview.setAdapter(adapter2);

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