package com.stem.naviviewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @描述 <在此添加描述信息>
 * @作者 stemt
 * @日期 2019-09-21 09:59
 * @版本
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if (number == null){
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public void  changeValue(int x){
        number.setValue(number.getValue()+x);
        if (number.getValue()<0){
            number.setValue(0);
        }
    }
}
