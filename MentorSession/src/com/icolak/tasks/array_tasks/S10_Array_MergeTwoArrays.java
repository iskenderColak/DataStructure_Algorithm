package com.icolak.tasks.array_tasks;

import java.util.Arrays;

/**
 * these are merging two sorted arrays in order
 * https://leetcode.com/problems/merge-sorted-array/
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays/
 */
public class S10_Array_MergeTwoArrays {

    // Write a return method that can concat two arrays

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeTwoArrays(new int[]{4, 4, 5}, new int[]{2, 4, 6})));
        int[] arr1 = {5, 8, 9, 0, 0, 0}, arr2 = {4, 7, 8};
        merge(arr1, 3, arr2, 3);
    }

    /*
    Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}
    Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}

    Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8}
    Output: arr3[] = {4, 5, 7, 8, 8, 9}
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1, p2 = n - 1, i = m + n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            } else {
                nums1[i--] = nums2[p2--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static int[] mergeTwoArrays(int[] arr1, int[] arr2) {
        int l = arr1.length + arr2.length;
        int[] arr = new int[l];
        int i = 0, j = 0;
        while (i < arr1.length) {
            arr[i] = arr1[i];
            i++;
        }
        while (j < arr2.length) {
            arr[i] = arr2[j];
            i++;
            j++;
        }
        return arr;
    }
}
