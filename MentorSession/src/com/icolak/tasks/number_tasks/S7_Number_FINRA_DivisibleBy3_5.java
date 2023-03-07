package com.icolak.tasks.number_tasks;

public class S7_Number_FINRA_DivisibleBy3_5 {

    public static void main(String[] args) {
        finRa(1, 30);
    }

    public static void finRa(int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result += "FINRA ";
            } else if (i % 3 == 0) {
                result += "FIN ";
            } else if (i % 5 == 0) {
                result += "RA ";
            } else {
                result += i + " ";
            }
        }
        System.out.print(result);
    }
}

/*
        Write a function which prints out the numbers from 1 to 30 but
        for numbers which are a multiple of 3, print "FIN" instead of the number
        and for numbers which are a multiple of 5, print "RA" instead of the number.
        for numbers which are a multiple of both 3 and 5, print "FINRA" instead of the number.
     */
