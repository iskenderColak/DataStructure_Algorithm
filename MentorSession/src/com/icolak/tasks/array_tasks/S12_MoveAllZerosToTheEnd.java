package com.icolak.tasks.array_tasks;

import java.util.Arrays;
import java.util.stream.IntStream;

public class S12_MoveAllZerosToTheEnd {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZerosToTheEnd1(new int[]{4,4,0,0,5})));
        System.out.println(Arrays.toString(moveZerosToTheEnd2(new int[]{4,0,6,4,0,0,5,0})));
        System.out.println(Arrays.toString(moveZerosToTheEnd3(new int[]{4,4,0,5})));
    }

    public static int[] moveZerosToTheEnd1(int[] arr) {
        int i = 0;
        for (int each : arr) {
            if (each != 0) {
                arr[i++] = each;
            }
        }
        while (i < arr.length) {
            arr[i++] = 0;
        }
        return arr;
    }

    public static int[] moveZerosToTheEnd2(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                swap(array, i, j);
                j++;
            }
        }
        return array;
    }

    private static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static int[] moveZerosToTheEnd3(int[] array) {
        if (array == null || array.length == 1)
            return array;

        return Arrays.copyOf(IntStream.of(array).filter(i -> i != 0).toArray(), array.length);
    }
}

/**
 * https://www.geeksforgeeks.org/move-zeroes-end-array/
 * https://leetcode.com/problems/move-zeroes/
 */

// write a program that can move all the zeros to the end of an array
