package com.example.remotecoders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//    public void changeFragment(View view){
//        Fragment fragment;
//        if(view==findViewById(R.id.home)){
//            fragment=new HomeFragment();
//            FragmentManager fm=getSupportFragmentManager();
//            FragmentTransaction ft=fm.beginTransaction();
//            ft.replace(R.id.fragmentDefault,fragment);
//            ft.commit();
//        }
//        if(view==findViewById(R.id.payment)){
//            fragment=new PaymentFragment();
//            FragmentManager fm=getSupportFragmentManager();
//            FragmentTransaction ft=fm.beginTransaction();
//            ft.replace(R.id.fragmentDefault,fragment);
//            ft.commit();
//        }
//        if(view==findViewById(R.id.food)){
//            fragment=new FoodFragment();
//            FragmentManager fm=getSupportFragmentManager();
//            FragmentTransaction ft=fm.beginTransaction();
//            ft.replace(R.id.fragmentDefault,fragment);
//            ft.commit();
//        }
//        if(view==findViewById(R.id.care)){
//            fragment=new CareFragment();
//            FragmentManager fm=getSupportFragmentManager();
//            FragmentTransaction ft=fm.beginTransaction();
//            ft.replace(R.id.fragmentDefault,fragment);
//            ft.commit();
//        }
//        if(view==findViewById(R.id.account)){
//            fragment=new AccountFragment();
//            FragmentManager fm=getSupportFragmentManager();
//            FragmentTransaction ft=fm.beginTransaction();
//            ft.replace(R.id.fragmentDefault,fragment);
//            ft.commit();
//        }
//    }


}