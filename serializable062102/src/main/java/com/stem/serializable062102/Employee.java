package com.stem.serializable062102;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 1. Parcelable 代码的自动生成功能
 * 2. 每一个进程都会有对应的Application ， 此application可以作为进程间的公有域进行变量存储，但是不鼓励这样做
 * 3. 进程间传递数据还是建议使用intent 和 Bundle
 */
class Employee implements Parcelable {
    private int number;
    private String name;
    private String department;

    public Employee(int number, String name, String department) {
        this.number = number;
        this.name = name;
        this.department = department;
    }

    protected Employee(Parcel in) {
        number = in.readInt();
        name = in.readString();
        department = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(name);
        dest.writeString(department);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
