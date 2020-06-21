package com.stem.pagingdemo062101;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @描述 <在此添加描述信息>
 * @作者 stemt
 * @日期 2020-06-21 16:42
 * @版本
 */
@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {

    static StudentDatabase instance;
    static synchronized StudentDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, StudentDatabase.class, "student_database").build();
        }
        return instance;
    }
    abstract StudentDao getStudentDao();
}
