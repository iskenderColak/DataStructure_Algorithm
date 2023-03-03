package com.icolak.number_tasks;

public class S6_Number_SwapTwoNumbers {

    public static void main(String[] args) {
       swapTwoNumbers1(3,5);
       swapTwoNumbers2(3,5);
    }

    private static void swapTwoNumbers1(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void swapTwoNumbers2(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

// Swap two variable' values without using a third variable
