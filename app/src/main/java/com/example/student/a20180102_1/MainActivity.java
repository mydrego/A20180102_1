package com.example.student.a20180102_1;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.student.a20180102_1.data.Dao;
import com.example.student.a20180102_1.data.Dao2File;
import com.example.student.a20180102_1.data.Student;
import com.example.student.a20180102_1.data.StudentDAOin;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public static Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        //dao = new Dao2File(this);
        dao = new StudentDAOin();
        Student s1 = new Student(1, "aa", 44);
        Student s2 = new Student(2, "bb", 55);
        Student s3 = new Student(3, "cc", 66);
        dao.add(s1);
        dao.add(s2);
        dao.add(s3);
        dao.printOut();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = dao.getList().get(i).id;
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("id" , id);
                startActivity(intent);
            }
        });
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
        String str[] = new String[dao.getList().size()];
        int i;
        for (i = 0; i < dao.getList().size(); i++) {
            str[i] = dao.getList().get(i).toString();
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
