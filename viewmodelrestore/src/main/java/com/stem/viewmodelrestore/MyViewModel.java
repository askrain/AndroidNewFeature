package com.stem.viewmodelrestore;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * @描述 <在此添加描述信息>
 * @作者 stemt
 * @日期 2019-09-16 22:07
 * @版本
 */
public class MyViewModel extends ViewModel {
//    private MutableLiveData<Integer> number;
        private SavedStateHandle handle;//只保存应用生命周期的数据，对于主动finish的页面不具有保存数据的效果。建议使用持久化保存手段
        public MyViewModel(SavedStateHandle handle){
           this.handle =handle;

        }
    public MutableLiveData<Integer> getNumber() {
       /* if (number == null){
            number =new MutableLiveData<>();
            number.setValue(0);
        }
        return number;*/
       if (!handle.contains(MainActivity.KEY_NUMBER)){
           handle.set(MainActivity.KEY_NUMBER, 0);
       }
       return handle.getLiveData(MainActivity.KEY_NUMBER);
    }
    public void add (){
//        number.setValue(number.getValue()+1);
        getNumber().setValue(getNumber().getValue()+1);
    }
}
