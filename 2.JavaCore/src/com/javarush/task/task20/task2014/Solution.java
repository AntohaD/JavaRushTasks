package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution(4));
        File your_file_name = File.createTempFile("your_file_name", null);
        OutputStream outputStream = new FileOutputStream(your_file_name);
        InputStream inputStream = new FileInputStream(your_file_name);

        Solution savedObject = new Solution(0);
        savedObject.save(outputStream);
        outputStream.flush();

        Solution loadedObject = new Solution(0);
        loadedObject.load(inputStream);
        System.out.println(savedObject.string.equals(loadedObject.string));
        inputStream.close();
    }

    private void save(OutputStream outputStream) {
    }

    private void load(InputStream inputStream) {
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
