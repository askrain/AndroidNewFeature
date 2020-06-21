package com.stem.pagingdemo062101;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @描述 <在此添加描述信息>
 * @作者 stemt
 * @日期 2020-06-21 16:31
 * @版本
 */
@Entity(tableName = "student_table")
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "student_number")
    private int studentNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNumber=" + studentNumber +
                '}';
    }
}
