package com.stem.roombasic02;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @描述 database access object  访问数据库对象
 * @作者 stemt
 * @日期 2020-03-22 10:39
 * @版本
 */


@Dao
public interface WordDao {

    @Insert
    void insertWords(Word... words);

    @Update
    int updateWords(Word... words);

    @Delete
    void deleteWords(Word...words);

    @Query("DELETE FROM WORD")
    void deleteAllWords();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    List<Word> getAllWords();

}
