package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        String[] sLines = result.split(" ");
        result = "";
        for (int i = 0; i < sLines.length - 1; i++) {
            result += sLines[i] + " ";
        }
        int a = Integer.valueOf(sLines[0]), b = Integer.valueOf(sLines[2]), sum = 0;
        if (sLines[1].equals("+")) {
            sum = a + b;
        }
        if (sLines[1].equals("-")) {
            sum = a - b;
        }
        if (sLines[1].equals("*")) {
            sum = a * b;
        }
        result += String.valueOf(sum);

        System.out.print(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

