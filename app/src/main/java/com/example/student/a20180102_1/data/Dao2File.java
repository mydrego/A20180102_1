package com.example.student.a20180102_1.data;

import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.style.AlignmentSpan;
import android.util.Log;
import android.widget.Button;

import com.example.student.a20180102_1.Main2Activity;
import com.example.student.a20180102_1.MainActivity;
import com.example.student.a20180102_1.addDF;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Created by student on 2018/1/2.
 */

public class Dao2File implements Dao {

    public static ArrayList<Student> arrayList = new ArrayList<>();
    Context context;

    public Dao2File(Context context) {
        this.context = context;
        read();
    }

    @Override
    public Student getStudent(int id) {
        for (Student s : arrayList) {
            if (s.id == id)
                return s;
        }
        return null;
    }



    @Override
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
            save();
        }
        return isAdd;
    }

    public void read() {
        File file = new File(context.getFilesDir(), "SaveFile.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str2 = bufferedReader.readLine();
            Gson gson = new Gson();
            arrayList = gson.fromJson(str2, new TypeToken<ArrayList<Student>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        File file = new File(context.getFilesDir(), "SaveFile.txt");
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file);
            Gson gson = new Gson();
            String str = gson.toJson(arrayList);
            fileWriter.write(str);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printOut() {
        for (Student i : arrayList) {
            Log.d("QAZ1", i.toString());
        }
    }

    public ArrayList<Student> getList() {
        return arrayList;
    }

    @Override
    public boolean sdel(int id) {
        return false;
    }

    @Override
    public void sedit(Student id) {

    }
}
