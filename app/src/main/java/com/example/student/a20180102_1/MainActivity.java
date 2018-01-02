package com.example.student.a20180102_1;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.student.a20180102_1.data.Dao2File;
import com.example.student.a20180102_1.data.Student;
import com.example.student.a20180102_1.data.StudentDAOin;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Dao2File studentDAOin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        studentDAOin = new Dao2File(this);
        Student s1 = new Student(1, "aa", 44);
        Student s2 = new Student(2, "bb", 55);
        Student s3 = new Student(3, "cc", 66);
        studentDAOin.add(s1);
        studentDAOin.add(s2);
        studentDAOin.add(s3);
        studentDAOin.printOut();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        addDF adddf = new addDF();
        adddf.show(getFragmentManager(), "myadd");
        return super.onOptionsItemSelected(item);
    }

    public void reFlush() {
        String str[] = new String[studentDAOin.getList().size()];
        int i;
        for (i = 0; i < studentDAOin.getList().size(); i++) {
            str[i] = studentDAOin.getList().get(i).toString();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1,
                str
        );
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        reFlush();
    }
}
