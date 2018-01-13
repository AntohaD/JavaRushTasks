package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(fileName2));

        StringBuilder stringBuilder = new StringBuilder("");

        while (file1.ready()) {
            String[] s = file1.readLine().split(" ");

            for (String i : s) {
                if (i.length() > 6) {
                    stringBuilder.append(i + ",");
                }
            }
        }

        file2.write(stringBuilder.toString().substring(0, stringBuilder.length()-1));

        file1.close();
        file2.close();
    }
}
