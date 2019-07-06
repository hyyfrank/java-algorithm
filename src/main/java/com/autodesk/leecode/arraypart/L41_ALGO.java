package com.autodesk.leecode.arraypart;

import java.util.ArrayList;
import java.util.Arrays;

public class L41_ALGO {
    /**
     * Given an unsorted integer array, find the smallest missing positive integer.
     *
     */
//    private static int[] nums = {3,4,-1,1}; //return 2
    private static int[] nums = {1,-1,-5,-3,3,4,2,8};
    public static void run() {
        System.out.println(Arrays.toString(nums));
        int pos = FindFirstMissingNumber(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("missing:"+pos);

    }

    public static int FindFirstMissingNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0 || arr[i] > arr.length) {
                arr[i] = 0;
            }
        }

        //iterate through the whole array again mapping elements [1,n] to positions [0, n-1]
        for (int i = 0; i < arr.length; i++) {
            int prev = arr[i];
            // while elements are not on their correct positions keep putting them there
            while (prev > 0 && arr[prev - 1] != prev) {
                int next = arr[prev - 1];
                arr[prev - 1] = prev;
                prev = next;
            }
        }

        // now, the first unmapped position is the smallest element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return arr.length + 1;
    }

}
