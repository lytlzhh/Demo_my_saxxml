package com.example.llw.demo_my_saxxml;

import java.util.List;

/**
 * Created by llw on 2016/5/8.
 */
public class Get_student {
    public String id = null;
    public String name = null;
    public int age = 0;
    public List<Lesson> lesson = null;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setLesson(List<Lesson> lesson) {
        this.lesson = lesson;
    }

    public List<Lesson> getLesson() {
        return lesson;
    }
}
