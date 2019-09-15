package com.stem.viewmodeltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    MyViewModel mMyViewModel;
    TextView mTextView;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        mTextView = findViewById(R.id.textView);
        mTextView.setText(String.valueOf(mMyViewModel.number));
        btn1 =findViewById(R.id.button);
        btn2 =findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyViewModel.number++;
                mTextView.setText(String.valueOf(mMyViewModel.number));

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMyViewModel.number+=2;
                mTextView.setText(String.valueOf(mMyViewModel.number));

            }
        });
    }
}
