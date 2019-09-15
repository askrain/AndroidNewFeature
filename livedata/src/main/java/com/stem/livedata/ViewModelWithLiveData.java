package com.stem.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @描述 LiveData作为数据的容器，具有订阅数据变化的功能
 * @作者 stemt
 * @日期 2019-09-15 21:37
 * @版本
 */
public class ViewModelWithLiveData extends ViewModel {
    private MutableLiveData<Integer> likedNumber;

    public MutableLiveData<Integer> getLikedNumber() {
        if (likedNumber == null){
            likedNumber =new MutableLiveData<>();
            likedNumber.setValue(0);
        }
        return likedNumber;
    }
    public void addLikedNumber(int n ){
        likedNumber.setValue(likedNumber.getValue()+n);
    }
}
