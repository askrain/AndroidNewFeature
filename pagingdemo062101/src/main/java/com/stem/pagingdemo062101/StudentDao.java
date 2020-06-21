package com.stem.pagingdemo062101;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * @描述 <在此添加描述信息>
 * @作者 stemt
 * @日期 2020-06-21 16:34
 * @版本
 */
@Dao
public interface StudentDao {
    @Insert
    void insertStudents(Student...students);

    @Query("DELETE FROM student_table")
    void deleteAllStudents();

    @Query("SELECT * FROM student_table ORDER BY id")
    DataSource.Factory<Integer,Student> getAllStudents();
}
