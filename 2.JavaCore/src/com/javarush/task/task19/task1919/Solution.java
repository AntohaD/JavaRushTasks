package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        Map<String, Double> map = new TreeMap<String, Double>();

        while (reader.ready()) {
            String[] splitLine = reader.readLine().split(" ");
            if (map.containsKey(splitLine[0])) {
                map.put(splitLine[0], map.get(splitLine[0]) + Double.parseDouble(splitLine[1]));
            } else {
                map.put(splitLine[0], Double.parseDouble(splitLine[1]));
            }
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        reader.close();
    }
}
