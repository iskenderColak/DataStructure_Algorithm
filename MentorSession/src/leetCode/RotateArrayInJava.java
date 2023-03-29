package leetCode;

import java.util.Arrays;

public class RotateArrayInJava {

/*
    Problem: Rotate an array of n elements to the right by k steps.
    For example, with n = 7 and k = 3,
    the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */

    public static void main(String[] args) {
        rotate1(new int[]{1, 2, 3, 4, 5, 6, 7}, 8);
        rotate2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate3(new int[]{1, 2, 3, 4, 5, 6, 7}, 8);
    }

    // Space is O(n) and time is O(n).
    public static void rotate1(int[] arr, int k) {

        if (k > arr.length)
            k = k % arr.length;

        int n = arr.length;
        int[] result = new int[n];

        // if (k >= 0) System.arraycopy(arr, n - k + 0, result, 0, k);
        for (int i = 0; i < k; i++) {
            result[i] = arr[n - k + i];
        }

        int j = 0;
        for (int i = k; i < n; i++) {
            result[i] = arr[j];
            j++;
        }
        System.out.println(Arrays.toString(result));
    }

    // Space is O(1) and time is O(n*k).
    public static void rotate2(int[] arr, int k) {

        if (arr == null || k < 0) {
            throw new IllegalArgumentException("Illegal argument");
        }

        int n = arr.length;
        // [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
        for (int i = 0; i < k; i++) {
            for (int j = n - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

/*
    1. Divide the array two parts: 1,2,3,4 and 5, 6
    2. Rotate first part: 4,3,2,1,5,6
    3. Rotate second part: 4,3,2,1,6,5
    4. Rotate the whole array: 5,6,1,2,3,4
    -- Space is O(1) and time is O(n).
 */
    public static void rotate3(int[] arr, int k) {

        k = k % arr.length;
        if (arr == null || k < 0) {
            throw new IllegalArgumentException("Illegal argument");
        }

        int n = arr.length;

        // length of first part
        int a = n - k;

        reverse(arr, 0, a - 1);
        reverse(arr, a, n - 1);
        reverse(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1)
            return;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}


















