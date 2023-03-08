package com.icolak.tasks.array_tasks;

import java.util.Arrays;

public class S11_Array_Reverse {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseArray1(new int[]{1,2,3})));
        System.out.println(Arrays.toString(reverseArray2(new int[]{1,2,3})));
        System.out.println(Arrays.toString(reverseArray1(new int[]{4,9,0,6,8})));
        System.out.println(Arrays.toString(reverseArray2(new int[]{4,9,0,6,8})));
    }

    public static int[] reverseArray1(int[] arr) {
        int l = arr.length;
        int[] reversedArray = new int[l];
        for (int i = 0; i < arr.length; i++) {
            reversedArray[i] = arr[l-i-1];
        }
        return reversedArray;
    }

    public static int[] reverseArray2(int[] arr){
        for (int i = 0, j = arr.length - 1; i < arr.length - 1 && j >= 0; i++, j--) {
            if (i == arr.length / 2)
                break;

            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            if (i == j)
                break;
        }
        return arr;
    }
}
/*
        write a function that can reverse an array

        EXAMPLE:
        Input  : arr[] = {1, 2, 3}
        Output : arr[] = {3, 2, 1}
     */
