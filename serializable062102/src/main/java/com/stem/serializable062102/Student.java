package com.stem.serializable062102;

import java.io.Serializable;

/**
 * @描述 <在此添加描述信息>
 * @作者 stemt
 * @日期 2020-06-21 21:24
 * @版本
 */
class Student implements Serializable {

    private static final long serialVersionUID = -7027685273182701060L;
    private String name;
     private int age;
     private Score score;

    public Student(String name, int age, Score score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

 class Score implements Serializable {
     private static final long serialVersionUID = 5089124543723050753L;
     private int chinese;
    private int english;
    private int math;

    public Score(int chinese, int english, int math) {
        this.chinese = chinese;
        this.english = english;
        this.math = math;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    @Override
    public String toString() {
        return "Score{" +
                "chinese=" + chinese +
                ", english=" + english +
                ", math=" + math +
                '}';
    }
}
