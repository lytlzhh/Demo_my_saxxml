package com.example.llw.demo_my_saxxml;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView textviewId;

    private Lesson lesson;

    private void assignViews() {
        textviewId = (TextView) findViewById(R.id.textview_id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        // lesson = new Lesson();
        fun();
    }


    public void fun() {
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("student.xml");
            List<Get_student> list = XML_sax.par(inputStream);
            for (Get_student get_student : list) {
                Log.e(TAG, "fun: " + get_student.getId() + "," + get_student.getName() + "," + get_student.getAge());
                List<Lesson> lsit = get_student.getLesson();
                Log.e(TAG, "fun: " + lsit.toString());
                for (Lesson lesson : lsit) {
                    //  Log.d("l", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    //Log.e(TAG, "fun:dkjjfkldjgklfdjg " + lesson.getAuther() + "," + lesson.getTitle() + "," + lesson.getPrice());
                    Log.e("hello", lesson.getAuther() + "," + lesson.getTitle() + "," + lesson.getPrice());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


}
