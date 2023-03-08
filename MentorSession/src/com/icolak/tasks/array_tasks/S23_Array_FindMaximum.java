package com.icolak.tasks.array_tasks;

import java.util.Arrays;

public class S23_Array_FindMaximum {
    // Write a function that can find the maximum number from an int Array
    public static void main(String[] args) {
        System.out.println(findMaximum1(new int[]{8, 7, 2, 5, 3, 1}));
        System.out.println(findMaximum2(new int[]{8, 7, 2, 5, 3, 1}));
    }

    public static int findMaximum1(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int findMaximum2(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
}