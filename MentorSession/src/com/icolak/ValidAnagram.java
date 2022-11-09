package com.icolak;

import java.util.HashMap;
import java.util.Set;

public class ValidAnagram {

    public static void main(String[] args) {

        String s = "anagram", t = "nagaram";

        System.out.println(isAnagram(s,t));
        System.out.println(areAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        // Check if length of both strings is same or not
        if (s.length() != t.length()) return false;

        // Create a hashmap containing character as key
        // and integer as value, count of character
        HashMap<Character, Integer> map = new HashMap<>();

        // Loop over all character of string s and put in HashMap
        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                // if hashmap contains current char, increase count by 1
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                // else put that char in map and set count to 1 as char
                // is encountered first time
                map.put(s.charAt(i), 1);
            }
        }

        // Now loop over string t
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                // if contains reduce count of that char by 1
                map.put(t.charAt(i),map.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        // Extract all keys of hashmap
        Set<Character> keys = map.keySet();
        // Loop over all keys and check if all keys are 0
        // if so it means it is anagram
        for (Character key : keys) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        // returning true as all keys are zero
        return true;
    }

    private static boolean areAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] char_counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']--;
        }

        for (int count : char_counts) {
            if (count != 0) return false;
        }
        return true;
    }
}
/*
Please, test your solution here : https://leetcode.com/problems/valid-anagram/

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word
or phrase, typically using all the original letters exactly once.
Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
Example 1:
Input: s = "anagram", t = "nagaram" Output: true
Example 2:
Input: s = "rat", t = "car" Output: false
*/
