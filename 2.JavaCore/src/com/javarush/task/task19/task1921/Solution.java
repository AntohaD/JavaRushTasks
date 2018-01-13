package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            String[] s = reader.readLine().split(" ");
            String name = "";

            if (s.length > 3) {
                Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(s[s.length-3]+"/"+s[s.length-2]+"/"+s[s.length-1]);

                for (int i = 0; i < s.length-3; i++) {
                    name += s[i] + " ";
                }

                name = name.trim();
                PEOPLE.add(new Person(name, birthday));
            }
        }

        reader.close();
    }
}
