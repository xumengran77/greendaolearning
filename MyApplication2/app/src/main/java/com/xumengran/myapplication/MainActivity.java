package com.xumengran.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.xumengran.database.greenDao.db.DaoMaster;
import com.xumengran.database.greenDao.db.DaoSession;
import com.xumengran.database.greenDao.db.StudentDao;
import com.xumengran.db.StudentDaoOpe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;

    MyAdapter myAdapter;
    private List<Student> lists=new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd=(Button) findViewById(R.id.add);
        listView=(ListView) findViewById(R.id.lv);
        //freshList();
        myAdapter=new MyAdapter(this,lists);
        listView.setAdapter(myAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* StudentDaoOpe.deleteAllData(MainActivity.this);*/

                for(int i=0;i<10;i++){
                    Student student=new Student();
                    student.name=i+"";
                    student.address=i+"";
                    student.age=i;
                    lists.add(student);
                }
                try{
                    StudentDaoOpe.insertData(MainActivity.this,lists);
                }catch (Exception e){
                    Log.e("xmrrr",e.toString());
                }
            }
        });
    }

    private void freshList(){
        lists = StudentDaoOpe.queryAll(MainActivity.this);
        Log.e("xxxx",lists.size()+"");
       /* myAdapter.notifyDataSetChanged();*/
    }

    private void initList(){
        Student student;
        for(int i=0;i<10;i++){
            student=new Student();
            student.name="xmr";
            student.address="安徽";
            student.age=18;
            student.grade="dasi";
            student.sex="nan";
            student.telPhone="18556522016";
            student.studentNo=i;
            lists.add(student);
        }
    }

    private void checkSU(){

        lists.clear();

        Log.e("此时list的长度",lists.size()+"");
        List<Student> students = StudentDaoOpe.queryAll(MainActivity.this);
        for (int i = 0; i < students.size(); i++) {
            Log.e("1111",students.size()+"");
            Log.e("Log", students.get(i).getName());
        }


    }


}
