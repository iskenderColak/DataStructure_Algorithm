package com.icolak.tasks.array_tasks;

import java.util.Arrays;
import java.util.stream.IntStream;

public class S24_Array_FindMinimum {
    // Write a function that can find the maximum number from an int Array
    public static void main(String[] args) {
        System.out.println(findMinimum1(new int[]{8, 7, 2, 5, 3, 1}));
        System.out.println(findMinimum2(new int[]{8, 7, 2, 5, 3, 1}));
    }

    public static int findMinimum1(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static int findMinimum2(int[] arr) {
        return IntStream.of(arr).min().getAsInt();
    }
}