package com.patterns.factories;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Iterator;

public class FactoryVariation1 {
    public static void main(String[] args){
        try {

            URL mySite = new URL("www.prorigosoftware.com");

            URLConnection connection = mySite.openConnection();

            InputStream in = connection.getInputStream();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseStrings(Collection<String> collection){
        Iterator<String> i = collection.iterator();
        if (!i.hasNext()) {
            return;
        }
        String s = i.next();
        parseString(s);
        //more business logic
    }

    public static String parseString(String s) {

        Boolean b1 = Boolean.valueOf("true");

        Boolean b2 = Boolean.valueOf(false);

        return  s;
    }
}
