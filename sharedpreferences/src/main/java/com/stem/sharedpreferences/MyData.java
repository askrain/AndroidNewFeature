package com.stem.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @描述 <在此添加描述信息>
 * @作者 stemt
 * @日期 2019-09-17 07:38
 * @版本
 */
public class MyData {
    private int number;
    private Context mContext;
    private SharedPreferences sp ;
    private SharedPreferences.Editor mEditor ;
    public static final String SP_FILE_NUMBER_KEY = "sp_file_number_key";
    public MyData(Context context){
        mContext =context;
        String name = context.getResources().getString(R.string.sp_file);
        sp = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        mEditor =sp.edit();


    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void save(){
        String key = mContext.getResources().getString(R.string.sp_file_number_key);
        mEditor.putInt(key,number);
        mEditor.apply();

    }
    public int load(){
        int numKey =mContext.getResources().getInteger(R.integer.defValue);
        return sp.getInt(SP_FILE_NUMBER_KEY, numKey);
    }
}
