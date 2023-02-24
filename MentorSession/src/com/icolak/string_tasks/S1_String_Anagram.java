package com.icolak.string_tasks;

import java.util.Arrays;
import java.util.TreeSet;

public class S1_String_Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram1("anagram", "nagaram"));
        System.out.println("************************");
        System.out.println(isAnagram2("anagram", "nagaram"));
        System.out.println("************************");
        System.out.println(isAnagram3("anagram", "nagaram"));
    }

    public static boolean isAnagram1(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
//        System.out.println("ch1: " + Arrays.toString(ch1));
//        System.out.println("ch2: " + Arrays.toString(ch2));

        Arrays.sort(ch1);
        Arrays.sort(ch2);
//        System.out.println("ch1: " + Arrays.toString(ch1));
//        System.out.println("ch2: " + Arrays.toString(ch2));

        String a1 = "", a2 = "";

        for (char each : ch1) {
            a1 += each;
        }

        for (char each : ch2) {
            a2 += each;
        }
        return a1.equals(a2);
    }

    public static boolean isAnagram2(String s, String t) {
        s = new TreeSet<String>(Arrays.asList(s.split(""))).toString();
        t = new TreeSet<String>(Arrays.asList(t.split(""))).toString();
//        System.out.println("s: " + s);
//        System.out.println("t: " + t);
        return s.equals(t);
    }

    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;

        int sIndex = 0;
        while (sIndex < s.length()) {
            String currentSChar = "" + s.charAt(sIndex++);
            if (t.contains(currentSChar)) {
                t = t.replaceFirst(currentSChar, "");
            } else {
                return false;
            }
        }
        return true;
    }
}
/*
        Write a  function that check if a string is build out of the same letters as another string.

        ANAGRAM:
        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
        typically using all the original letters exactly once.

        EXAMPLE:
        inputs: "abc", "cab"
        output: true

        EXAMPLE:
        inputs: "abc", "abb"
        output: false
     */
/**
 * https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 * https://leetcode.com/problems/valid-anagram/
 */