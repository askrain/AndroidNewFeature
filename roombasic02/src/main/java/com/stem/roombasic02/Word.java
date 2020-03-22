package com.stem.roombasic02;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @描述 <在此添加描述信息>
 * @作者 stemt
 * @日期 2020-03-22 10:35
 * @版本
 */
@Entity
public class Word {
   @PrimaryKey(autoGenerate = true)
    private int id ;
   @ColumnInfo(name="english_word")
    private String word;
   @ColumnInfo(name = "chinese_meaning")
    private String chineseMeaning;

    public Word(String word, String chineseMeaning) {
        this.word = word;
        this.chineseMeaning = chineseMeaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChineseMeaning() {
        return chineseMeaning;
    }

    public void setChineseMeaning(String chineseMeaning) {
        this.chineseMeaning = chineseMeaning;
    }
}
