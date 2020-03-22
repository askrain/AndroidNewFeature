package com.stem.calculationtest;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import java.util.Random;


/**
 * MyViewModel 和Activity 相关联。本demo只有一个Activity，所以所有Fragment相关联的ViewModel都是同一个
 * @作者 stemt
 * @日期 2020-02-23 17:08
 * @版本
 */
public class MyViewModel extends AndroidViewModel {


    private SavedStateHandle handle;
    private static final String KEY_HIGH_SCORE = "key_high_score";
    private static final String KEY_CURRENT_SCORE = "key_current_score";
    private static final String KEY_LEFT_NUMBER = "key_left_number";
    private static final String KEY_RIGHT_NUMBER = "key_right_number";
    private static final String KEY_OPERATOR = "key_right_number";
    private static final String KEY_ANSWER = "key_answer";
    private static final String SAVE_SHP_DATA_NAME = "save_shp_data_name";
    boolean win_flag =false;

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        if (!handle.contains(KEY_HIGH_SCORE)) {
            SharedPreferences shp = getApplication().getSharedPreferences(SAVE_SHP_DATA_NAME, Context.MODE_PRIVATE);
            handle.set(KEY_HIGH_SCORE, shp.getInt(KEY_HIGH_SCORE, 0));
            handle.set(KEY_LEFT_NUMBER, 0);
            handle.set(KEY_RIGHT_NUMBER, 0);
            handle.set(KEY_OPERATOR, "+");
            handle.set(KEY_ANSWER, 0);
            handle.set(KEY_CURRENT_SCORE, 0);
        }
        this.handle = handle;
    }

    public MutableLiveData<Integer> getLeftNumber() {
        return handle.getLiveData(KEY_LEFT_NUMBER);
    }

    public MutableLiveData<Integer> getRightNumber() {
        return handle.getLiveData(KEY_RIGHT_NUMBER);
    }

    public MutableLiveData<String> getOperator() {
        return handle.getLiveData(KEY_OPERATOR);
    }

    public MutableLiveData<Integer> getHighScore() {
        return handle.getLiveData(KEY_HIGH_SCORE);
    }

    public MutableLiveData<Integer> getCurrentScore() {
        return handle.getLiveData(KEY_CURRENT_SCORE);
    }
    public MutableLiveData<Integer> getAnwser() {
        return handle.getLiveData(KEY_ANSWER);
    }

    void generator(){
        int LEVEL =20;
        Random random =new Random();
        int x,y;

        x =random.nextInt(LEVEL)+1;
        y =random.nextInt(LEVEL)+1;

        if (x%2==0){
            getOperator().setValue("+");
            if (x>y){ // x=10 y=8   此逻辑是避免计算的数字过大
                getAnwser().setValue(x);
                getLeftNumber().setValue(y);
                getRightNumber().setValue(x-y);
            }else {
                getAnwser().setValue(y);
                getLeftNumber().setValue(x);
                getRightNumber().setValue(y-x);
            }
        }else {
            getOperator().setValue("-");
            if (x>y){
                getAnwser().setValue(x-y);
                getLeftNumber().setValue(x);
                getRightNumber().setValue(y);
            }else{
                getAnwser().setValue(y-x);
                getLeftNumber().setValue(y);
                getRightNumber().setValue(x);
            }
        }
    }


    @SuppressWarnings("ConstantConditions")
    void save(){
        SharedPreferences shp = getApplication().getSharedPreferences(SAVE_SHP_DATA_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = shp.edit();
        edit.putInt(KEY_HIGH_SCORE, getHighScore().getValue());
        edit.apply();
    }

    @SuppressWarnings("ConstantConditions")
    void answerCorrect(){
        getCurrentScore().setValue(getCurrentScore().getValue()+1);
        if (getCurrentScore().getValue()>getHighScore().getValue()){
            getHighScore().setValue(getCurrentScore().getValue());
            win_flag=true;
        }
        generator();
    }
}
