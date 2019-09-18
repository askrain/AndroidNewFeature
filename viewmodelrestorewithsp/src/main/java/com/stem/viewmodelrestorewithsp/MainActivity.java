package com.stem.viewmodelrestorewithsp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.stem.viewmodelrestorewithsp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyViewModel mMyViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMyViewModel = ViewModelProviders.of(this,new SavedStateViewModelFactory(getApplication(), this)).get(MyViewModel.class);
        binding.setData(mMyViewModel);
        binding.setLifecycleOwner(this);
    }

    @Override  //为什么选择这个生命周期？ 进程被杀掉的时候，很大程度上这个生命周期方法会被调用
    protected void onPause() {
        super.onPause();  //系统意外关机不会调用
        mMyViewModel.save();
    }
}
