package com.aplicaciones13;

import java.io.FileReader;
import java.io.IOException;

import java.util.Enumeration;
import java.util.Properties;

public class TestProperties {
    public TestProperties() {
        super();
    }

    public static void main(String[] args) {
        TestProperties testProperties = new TestProperties();


        Properties p = new Properties();
        try {
            p.load(new FileReader("/home/omarv/jeremias/1391701667001.con1"));
        } catch (IOException e) {
        }

        Enumeration<Object> keys = p.keys();

        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            System.out.println(key + " = " + p.get(key));
        }

    }
}
