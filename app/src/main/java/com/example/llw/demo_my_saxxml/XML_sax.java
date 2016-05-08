package com.example.llw.demo_my_saxxml;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by llw on 2016/5/8.
 */
public class XML_sax {

    public static List<Get_student> par(InputStream inputStream) throws Throwable {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        XMLparser_sax xmLparser_sax = new XMLparser_sax();
        saxParser.parse(inputStream, xmLparser_sax);

        inputStream.close();
        return xmLparser_sax.parser();
    }
}
