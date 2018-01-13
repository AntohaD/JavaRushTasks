package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties props = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        reader.close();
        load(file);
        file.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);
        for (Map.Entry<String, String> kv :properties.entrySet()) {
            props.put(kv.getKey(), kv.getValue());
        }
        props.store(new PrintStream(outputStream), "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        props.load(inputStream);
        for (Map.Entry<Object, Object> kv :props.entrySet()) {
            properties.put(kv.getKey().toString(), kv.getValue().toString());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        sol.fillInPropertiesMap();
        FileOutputStream out = new FileOutputStream("d://asd10.txt");
        sol.save(out);
        out.close();
    }
}