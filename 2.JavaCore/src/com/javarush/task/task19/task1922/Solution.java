package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(file.readLine());
        file.close();

        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (String s : words) {
            sb.append(s).append("|");
        }

        Pattern p = Pattern.compile(sb.substring(0, sb.length() - 1));
        sb.delete(0, sb.length());

        while (reader.ready()) sb.append((char) reader.read());

        String[] st = sb.toString().split(System.lineSeparator());
        for (String sq : st) {
            list.add(sq);
        }
        for (String s : list) {
            Matcher m = p.matcher(s);
            int i = 0;
            while (m.find()) i++;
            if (i == 2) System.out.println(s);
        }

        reader.close();
    }
}
