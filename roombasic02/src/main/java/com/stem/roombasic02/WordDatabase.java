package com.stem.roombasic02;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @描述 ROOM通过注解的方式，实现entity 、dao、database的 配置，从而实现数据库的操作
 * 注意事项：
 * 数据库的操作需要在子线程中进行
 * @作者 stemt
 * @日期 2020-03-22 10:48
 * @版本
 */


@Database(entities = {Word.class},version = 1,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase INSTANCE;
    static synchronized WordDatabase getDatabase(Context ctx){
        if (INSTANCE==null){
            INSTANCE = Room.databaseBuilder(ctx.getApplicationContext(), WordDatabase.class, "word_database")
            .build();
        }
        return  INSTANCE;
    }
    public abstract WordDao getWordDao();
}
