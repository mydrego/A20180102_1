package com.example.student.a20180102_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.student.a20180102_1.data.Student;

public class Main2Activity extends AppCompatActivity {
    TextView tv, tv2, tv3;
    Button bt, bt2, bt3;
    int id;
    Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        bt = (Button) findViewById(R.id.button2);
        bt2 = (Button) findViewById(R.id.button3);
        bt3 = (Button) findViewById(R.id.button4);

        it = getIntent();
        id = it.getIntExtra("id", 0);
        Student s = MainActivity.dao.getStudent(id);
        tv.setText(String.valueOf(s.id));
        tv2.setText(s.name);
        tv3.setText(String.valueOf(s.scor));

    }

    public void clickesc(View v) {
        finish();
    }

    public void clickdel(View v) {
        MainActivity.dao.sdel(id);
        finish();
    }

    public void clickedit(View v) {
        it = new Intent(Main2Activity.this, Main3Activity.class);
        it.putExtra("id", id);
        startActivity(it);
    }
}
