package com.icolak.tasks.string_tasks;

import java.util.Arrays;

public class S5_String_SumOfAllIntegers {

    public static void main(String[] args) {
        System.out.println(sumOffAllIntegers1("12 some 580 b text 3 7"));
        System.out.println(sumOffAllIntegers2("12 some 580 b text 3 7"));
        System.out.println(sumOffAllIntegers3("12 some 580 b text 3 7"));
    }

    private static int sumOffAllIntegers1(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            int number = 0;
            if (Character.isDigit(chars[i])) {
                number = Integer.parseInt("" + chars[i]);
                i++;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    number = (number * 10) + Integer.parseInt("" + chars[i]);
                    i++;
                }
                sum += number;
            }
        }
        return sum;
    }

    public static int sumOffAllIntegers2(String s) {
        int sum = 0;
        String[] numbers = s.replaceAll("[\\D]+"," ").split(" ");

        for(String each : numbers){
            sum+=Integer.parseInt(each);
        }
        return sum;
    }

    public static int sumOffAllIntegers3(String s) {
        String digits = "0123456789";
        return Arrays.stream(s.split(" ")).filter(p ->
                p.chars().mapToObj(i -> (char)i).allMatch(k -> digits.contains("" + k))).mapToInt(p -> Integer.valueOf(p)).sum();
    }
}

/*
        Find the sum of all integers found in the parameter String.
        You can assume that integers are separated from other parts with one or more spaces (' ' symbol).

        EXAMPLE:
        input = "12 some text 3 7"
        output: 22
        explanation: 12+3+7=22
     */
