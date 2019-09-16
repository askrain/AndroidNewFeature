package com.stem.score;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @描述 <在此添加描述信息>
 * @作者 stemt
 * @日期 2019-09-16 08:21
 * @版本
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;
    private int aBack,bBack;

    public MutableLiveData<Integer> getaTeamScore() {
        if (aTeamScore==null){
            aTeamScore =new MutableLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore==null){
            bTeamScore =new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }
    public void aTeamAdd(int s){
        aBack =getaTeamScore().getValue();
        bBack =getbTeamScore().getValue();
        aTeamScore.setValue(aTeamScore.getValue()+s);
    }
    public void bTeamAdd(int s){
        aBack =getaTeamScore().getValue();
        bBack =getbTeamScore().getValue();
        bTeamScore.setValue(bTeamScore.getValue()+s);
    }
    public void reset(){
        aBack =getaTeamScore().getValue();
        bBack =getbTeamScore().getValue();
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }
    public void undo(){
        aTeamScore.setValue(aBack);
        bTeamScore.setValue(bBack);
    }
}
