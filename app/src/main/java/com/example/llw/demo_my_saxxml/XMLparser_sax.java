package com.example.llw.demo_my_saxxml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llw on 2016/5/8.
 */
public class XMLparser_sax extends DefaultHandler {
    private static final String TAG = "XMLparser_sax";
    public List<Get_student> get_studentList = null;
    public List<Lesson> get_lessonList = null;
    public Get_student get_student = null;
    public Lesson lesson = null;
    public String tageNmae = null;

    public List<Get_student> parser() {
        return get_studentList;
    }

    public List<Lesson> par() {

        return get_lessonList;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        get_studentList = new ArrayList<Get_student>();
        get_lessonList = new ArrayList<Lesson>();
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (qName.equals("student")) {
            get_student = new Get_student();
            get_student.setId(attributes.getValue("id"));

        }


        if (qName.equals("book")) {
            lesson = new Lesson();
        }
        this.tageNmae = qName;
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String str = new String(ch, start, length);

        if (tageNmae != null) {
            if (get_student != null) {

                if (tageNmae.equals("name")) {
                    get_student.setName(str);
                }

                if (tageNmae.equals("age")) {
                    get_student.setAge(Integer.parseInt(str));
                }

                if (tageNmae.equals("price")) {
                    lesson.setPrice(Integer.parseInt(str));
                }

                if (tageNmae.equals("auther")) {
                    lesson.setAuther(str);
                }


                if (tageNmae.equals("title")) {
                    lesson.setTitle(str);
                }
            }
        }

    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("student") && get_student != null) {
            get_student.setLesson(get_lessonList);
            get_studentList.add(get_student);
            get_student = null;
            // lesson = null;
        }

        if (qName.equals("book") && lesson != null) {
            get_lessonList.add(lesson);
            lesson = null;
        }

        this.tageNmae = null;
    }


    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
