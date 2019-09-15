package com.stem.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewModelWithLiveData mViewModelWithLiveData;
    TextView mTextView;
    ImageButton ib1,ib2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView =findViewById(R.id.textView);
        ib1 = findViewById(R.id.ib1);
        ib2 = findViewById(R.id.ib2);
        mViewModelWithLiveData = ViewModelProviders.of(this).get(ViewModelWithLiveData.class);
        mViewModelWithLiveData.getLikedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mTextView.setText(String.valueOf(integer));
            }
        });
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModelWithLiveData.addLikedNumber(1);

            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModelWithLiveData.addLikedNumber(-1);

            }
        });
    }
}
