package com.example.student.a20180102_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.a20180102_1.data.Dao;
import com.example.student.a20180102_1.data.Student;

public class Main3Activity extends AppCompatActivity {
    TextView tv4;
    EditText ed4, ed5;
    Intent it;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv4 = (TextView) findViewById(R.id.textView4);
        ed4 = (EditText) findViewById(R.id.editText4);
        ed5 = (EditText) findViewById(R.id.editText5);

        it = getIntent();
        id = it.getIntExtra("id", 0);
        Student s = MainActivity.dao.getStudent(id);
        tv4.setText(String.valueOf(s.id));
        ed4.setText(s.name);
        ed5.setText(String.valueOf(s.scor));
    }

    public void click5(View v) {
        Student student = new Student(id,ed4.getText().toString(),Integer.parseInt(ed5.getText().toString()));
        MainActivity.dao.sedit(student);
        finish();
    }
}
