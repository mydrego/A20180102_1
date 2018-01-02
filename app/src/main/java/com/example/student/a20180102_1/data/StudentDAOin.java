package com.example.student.a20180102_1.data;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by student on 2018/1/2.
 */

public class StudentDAOin {
    public static ArrayList<Student> arrayList = new ArrayList<>();

    public void add(Student s) {
        arrayList.add(s);
    }

    public void printOut() {
        for (Student i : arrayList) {
            Log.d("QAZ1", i.toString());
        }
    }

    public ArrayList<Student> getList() {
        return arrayList;
    }

}
