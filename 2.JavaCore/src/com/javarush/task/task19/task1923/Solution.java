package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));

        while (reader.ready()) {
            String[] s = reader.readLine().split(" ");

            for (String i : s) {
                Pattern p = Pattern.compile("\\d");
                Matcher m = p.matcher(i);

                if (m.find()) {
                    writer.write(i + " ");
                }
            }
        }
        writer.close();
        reader.close();
    }
}
