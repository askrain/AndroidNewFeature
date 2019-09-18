package com.stem.viewmodelrestorewithsp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

/**
 * @描述 AndroidViewModel 的特点是在于提供的getApplication()的全局域
 * @作者 stemt
 * @日期 2019-09-18 07:26
 * @版本
 */

public class MyViewModel extends AndroidViewModel {
    private final String DATA_KEY;
    private SavedStateHandle mHandle;
    private SharedPreferences sp;

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        mHandle = handle;
        DATA_KEY = getApplication().getResources().getString(R.string.data_key);
        String SP_FILE_NAME = getApplication().getResources().getString(R.string.sp_file_name);
        sp = getApplication().getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);

        if (!mHandle.contains(DATA_KEY)) {
            load();
        }
    }

    public LiveData<Integer> getNumber() {
        return mHandle.getLiveData(DATA_KEY);
    }

    private void load() {
        int x = sp.getInt(DATA_KEY, 0);
        mHandle.set(DATA_KEY, x);
    }

    void save() {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(DATA_KEY, getNumber().getValue());
        editor.apply();

    }

    public void add(int i) {
        int value = getNumber().getValue() == null ? 0 : getNumber().getValue() + i;
        mHandle.set(DATA_KEY, value);
        //        save();  //提升持久化保存的效率
    }

}
