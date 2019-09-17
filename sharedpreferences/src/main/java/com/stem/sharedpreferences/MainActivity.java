package com.stem.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String SP_FILE_NAME = "sp_file_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*//        SharedPreferences sp = getPreferences(MODE_PRIVATE);//适合做私有文件数据的存储
        SharedPreferences sp = getSharedPreferences(SP_FILE_NAME,MODE_PRIVATE);//适合做公用的文件存储位置
        SharedPreferences.Editor editor =sp.edit();
        editor.putInt("NUMBER", 123);
        editor.apply();//非同步操作
//        editor.commit();//同步操作

        int x = sp.getInt("NUMBER",0);
        Log.d(TAG, "onCreate: x:"+x);*/

        MyData myData = new MyData(getApplicationContext());//使用application的context，防止内存泄漏

        myData.setNumber(8907);

        myData.save();
        Log.d(TAG, "onCreate: myData.number: "+myData.load());


    }
}
