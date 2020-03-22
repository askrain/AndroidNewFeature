package com.stem.lifecycles01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private MyChronometer chronometer;
//    private long elapsedTime ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = (MyChronometer)findViewById(R.id.meter);
        getLifecycle().addObserver(chronometer);
//        chronometer.setBase(SystemClock.elapsedRealtime());//System.currentTimeMillis() unix time 1970 1-1
    }

   /* @Override
    protected void onPause() {
        super.onPause();
        elapsedTime = SystemClock.elapsedRealtime()-chronometer.getBase();
        chronometer.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        chronometer.setBase(SystemClock.elapsedRealtime()-elapsedTime);
        chronometer.start();
    }*/
}
