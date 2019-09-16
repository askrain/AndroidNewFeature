package com.stem.viewmodelrestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.stem.viewmodelrestore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MyViewModel mMyViewModel;
    public static final String KEY_NUMBER= "key_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMyViewModel = ViewModelProviders.of(this,new SavedStateViewModelFactory(getApplication(), this)).get(MyViewModel.class);
        /*  常规方式：在页面被回首的时候，保存页面相关的值
        if (savedInstanceState!=null){
            mMyViewModel.getNumber().setValue(savedInstanceState.getInt(KEY_NUMBER));
        }*/

        binding.setData(mMyViewModel);
        binding.setLifecycleOwner(this);
    }

   /* @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_NUMBER,mMyViewModel.getNumber().getValue());
    }*/
}
