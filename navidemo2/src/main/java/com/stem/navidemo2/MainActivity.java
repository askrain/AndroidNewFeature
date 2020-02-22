package com.stem.navidemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Navigation 系列二
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*所以Navigation传递参数有三种方式：
        * 1.fragment中携带的静态的argument
        * 2.action中携带的动态的argument
        * 3.通过navigation方法传递的Bundle*/
    }
}
