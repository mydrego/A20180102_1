package com.example.student.a20180102_1.data;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by student on 2018/1/2.
 */

public class StudentDAOin implements Dao {
    public static ArrayList<Student> arrayList = new ArrayList<>();

    public boolean add(Student s) {
        boolean isAdd = true;
        for (Student tmp : arrayList) {
            if (tmp.id == s.id) {
                isAdd = false;
                break;
            }
        }
        if (isAdd) {
            arrayList.add(s);
        }
        return isAdd;
    }


    public void printOut() {
        for (Student i : arrayList) {
            Log.d("QAZ1", i.toString());
        }
    }

    @Override
    public Student getStudent(int id) {
        for (Student s : arrayList) {
            if (s.id == id)
                return s;
        }
        return null;

    }


    public ArrayList<Student> getList() {
        return arrayList;
    }

    @Override
    public boolean sdel(int id) {
        int i;
        for (i = arrayList.size(); i >= 0; i--) {
            if (arrayList.get(i).id == id) {
                arrayList.remove(i);
            }
        }

        return false;

    }

    @Override
    public void sedit(Student id) {
        for (Student s : arrayList) {
            if (s.id == id.id) {
                id.name = s.name;
                id.scor = s.scor;
                break;
            }
        }
    }
}
