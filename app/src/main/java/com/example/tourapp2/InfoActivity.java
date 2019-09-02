package com.example.tourapp2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.tourapp2.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the explode animation is only available Api 21 and higher so before enable window content transition i make this check
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // To enable window content transitions
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            // set an exit transition
            getWindow().setExitTransition(new Explode());

        }
        //inflate layout using dataBinding
        ActivityInfoBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_info);
        //get the intent coming from the MainActivity
        Intent intent=getIntent();
        //binding the view with its data using data coming from intent
        binding.setListModel(intent.getParcelableExtra("item"));
        //set toolbar as default action bar
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
