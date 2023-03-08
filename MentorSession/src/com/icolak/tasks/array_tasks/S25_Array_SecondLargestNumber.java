package com.icolak.tasks.array_tasks;

import java.util.Arrays;

public class S25_Array_SecondLargestNumber {

    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{12, 35, 1, 10, 34, 1}));
        System.out.println(kthLargestNumber(new String[]{"3","6","7","10"}, 4));
        System.out.println(kthLargestNumber(new String[]{"2","21","12","1"}, 3));
    }

    private static int secondLargest(int[] arr) {
        int first, second;
        if (arr.length < 2) {
            System.err.println("Invalid input");
            return -1;
        }

        first = second = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.err.println("There is no second largest element");
            return -1;
        }

        return second;
    }

    public static String kthLargestNumber(String[] nums, int k) {
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Long.parseLong(nums[i]);
        }
        Arrays.sort(arr);
        return "" + arr[nums.length-k];
    }

}

/**
 * https://www.geeksforgeeks.org/find-second-largest-element-array/
 * https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
 */

/*
        Given an array of integers, our task is to write a program that efficiently finds the second largest element present in the array.

        EXAMPLE:
        Input: arr[] = {12, 35, 1, 10, 34, 1}
        Output: The second largest element is 34.
        Explanation: The largest element of the
        array is 35 and the second
        largest element is 34
     */
