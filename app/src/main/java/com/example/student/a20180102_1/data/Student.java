package com.example.student.a20180102_1.data;

/**
 * Created by student on 2018/1/2.
 */

public class Student {
    public int id;
    public String name;
    public int scor;

    public Student(int i, String n, int s) {
        this.id = i;
        this.name = n;
        this.scor = s;
    }

    public String toString()
    {
        return "id= "+id + " , name= " + name + " , scor= " + scor;
    }
}
