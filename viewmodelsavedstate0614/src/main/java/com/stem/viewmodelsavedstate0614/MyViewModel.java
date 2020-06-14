package com.stem.viewmodelsavedstate0614;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * @描述 <在此添加描述信息>
 * @作者 stemt
 * @日期 2020-06-14 11:05
 * @版本
 */
public class MyViewModel extends ViewModel {
    private SavedStateHandle handle;
    public static final String NUMBER   ="number";

    public MyViewModel(SavedStateHandle handle) {
        if (!handle.contains(NUMBER)){//初始化操作
            handle.set(NUMBER, 0);
        }
        this.handle = handle;
    }

    public LiveData<Integer> getNumber(){
        return handle.getLiveData(NUMBER);
    }

    public void add(){
        handle.set(NUMBER, (int)handle.get(NUMBER)+1);
    }
}
