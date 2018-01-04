package com.example.student.a20180102_1.data;

import java.util.ArrayList;

/**
 * Created by student on 2018/1/4.
 */

public interface Dao {
    public boolean add(Student s);
    public ArrayList<Student> getList();
    public void printOut();
    public Student getStudent(int id);
    public boolean sdel(int id);
    public void sedit(Student id);
}
