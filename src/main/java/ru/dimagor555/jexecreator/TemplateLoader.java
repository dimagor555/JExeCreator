package ru.dimagor555.jexecreator;

import java.io.InputStream;
import java.util.Scanner;

public class TemplateLoader {

    public static String loadTemplate() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("C++Template.cpp");
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
