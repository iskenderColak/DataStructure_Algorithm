package com.icolak.string_tasks;

import java.util.Arrays;

public class S4_String_RemoveExtraSpaces {

    public static void main(String[] args) {
        System.out.println(removeExtraSpaces1("   Hello world       I       love     Java      "));
        System.out.println(removeExtraSpaces2("   Hello world       I       love     Java      "));
    }

    public static String removeExtraSpaces1(String sentence) {
        String[] words = sentence.trim().split(" ");
        String result = "";
        for (String each : words) {
            if (!each.isEmpty()) {
                result += each + " ";
            }
        }
        return result.trim();
    }

    public static String removeExtraSpaces2(String sentence) {
        while (sentence.contains("  ")) {
            sentence = sentence.replace("  ", " ");
        }
        return sentence.trim();
    }
}

/*
    Remove All Extra Space from String
        Input: "  Hello world      I      love      Java    "
        Output: Hello world I love Java

     */
