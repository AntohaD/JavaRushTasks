package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(args[0]));

        Map<String, Double> map = new TreeMap<>();

        while (reader.ready()) {
            String[] s = reader.readLine().split(" ");
            if (map.containsKey(s[0])) {
                map.put(s[0], map.get(s[0]) + Double.parseDouble(s[1]));
            } else {
                map.put(s[0], Double.parseDouble(s[1]));
            }
        }

        double max = Collections.max(map.values());

        for (Map.Entry<String, Double> entry: map.entrySet())
        {
            if (entry.getValue() > max)
                max = entry.getValue();
        }

        for (Map.Entry<String, Double> entry: map.entrySet())
        {
            if (entry.getValue().equals(max))
                System.out.print(entry.getKey()+" ");
        }

        reader.close();
    }
}
