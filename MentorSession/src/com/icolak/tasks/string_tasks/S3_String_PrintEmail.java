package com.icolak.tasks.string_tasks;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S3_String_PrintEmail {

    public static void main(String[] args) {
        System.out.println(printEmail1("I love Java name@gmail.com, I don't like python"));
        System.out.println(printEmail2("I love Java name@gmail.com, I don't like python"));
        System.out.println(printEmail3("I love Java name@gmail.com, I don't like python"));
        System.out.println(printEmail4("I love Java name@gmail.com, I don't like python"));
    }

    public static String printEmail1(String sentence) {
        String[] str = sentence.split(" ");
        for (String each : str) {
            if (each.contains("@")) {
                return each;
            }
        }
        return null;
    }

    private static String printEmail2(String sentence){
        Matcher match = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(sentence);
        return match.find() ? match.group() : null;
    }

    private static String printEmail3(String sentence){
        return sentence.replaceAll(".*\\b(\\w\\S*@\\S*\\w)\\b.*", "$1");
    }

    private static String printEmail4(String sentence){
        String dirtyEmail = Arrays.stream(sentence.split(" ")).filter(p -> p.contains("@")).findFirst().get();
        dirtyEmail = new StringBuilder(dirtyEmail).reverse().toString();

        while (!Character.isLetter(dirtyEmail.charAt(0))){
            dirtyEmail = dirtyEmail.replaceFirst("" + dirtyEmail.charAt(0), "");
        }
        return new StringBuilder(dirtyEmail).reverse().toString();
    }
}

/*
        Given a String that contains email address, write a function that extracts and returns the email only
        Do not use substring function.

        EXAMPLE:
        input: "I love Java name@gmail.com, I don't like python";
        output: name@gmail.com
     */
