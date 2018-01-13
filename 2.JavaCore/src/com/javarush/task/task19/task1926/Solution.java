package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));

        while (file.ready()) {
            String[] s = file.readLine().split("\n");
            for (String i : s) {
                String reverse = new StringBuffer(i).reverse().toString();
                System.out.println(reverse);
            }
        }

        reader.close();
        file.close();

    }
}
