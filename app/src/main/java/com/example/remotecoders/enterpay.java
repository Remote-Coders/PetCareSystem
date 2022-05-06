package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class enterpay extends AppCompatActivity {

    ListAdapterClss listAdapterClss;
    ArrayList<modelClass> mData;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterpay);

        recyclerView=findViewById(R.id.rv_list);
        getData();
        setDataAdapter();
    }

    private void setDataAdapter() {
        listAdapterClss = new ListAdapterClss(enterpay.this,mData);
        recyclerView.setAdapter(listAdapterClss);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void getData() {
        mData = new ArrayList<>();
        mData.add(new modelClass(R.drawable.rec2));
        mData.add(new modelClass(R.drawable.rec2));
        mData.add(new modelClass(R.drawable.rec2));
        mData.add(new modelClass(R.drawable.rec2));
        mData.add(new modelClass(R.drawable.rec2));
        mData.add(new modelClass(R.drawable.rec2));
        mData.add(new modelClass(R.drawable.rec2));
        mData.add(new modelClass(R.drawable.rec2));
        mData.add(new modelClass(R.drawable.rec2));
        mData.add(new modelClass(R.drawable.rec2));
        mData.add(new modelClass(R.drawable.rec2));
    }


}