package com.stem.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.stem.score.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel mMyViewModel;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMyViewModel= ViewModelProviders.of(this).get(MyViewModel.class);
        binding.setData(mMyViewModel);
        binding.setLifecycleOwner(this);
    }
}
