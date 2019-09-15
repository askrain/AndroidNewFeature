package com.stem.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.stem.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//    private TextView  mTextView;
//    private Button button;
    private MyViewModel mMyViewModel;
    private ActivityMainBinding binding;//xml文件名+Bing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
//        mTextView=findViewById(R.id.textView);
//        button =findViewById(R.id.button);
        mMyViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
       /* mMyViewModel.getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.textView.setText(String.valueOf(integer));
            }
        });*/
       binding.setData(mMyViewModel);
       binding.setLifecycleOwner(this);//保证数据被观察

       /* binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyViewModel.add();
            }
        });*/
    }
}
