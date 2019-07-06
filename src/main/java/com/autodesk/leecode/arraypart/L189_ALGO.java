package com.autodesk.leecode.arraypart;
import java.util.Arrays;
public class L189_ALGO {
    /*Given an array, rotate the array to the right by k steps, where k is non-negative.
    * --DEMO
    *   Input: [1,2,3,4,5,6,7] and k = 3
    *   Output: [5,6,7,1,2,3,4]
    *   Explanation:
    *   rotate 1 steps to the right: [7,1,2,3,4,5,6]
    *   rotate 2 steps to the right: [6,7,1,2,3,4,5]
    *   rotate 3 steps to the right: [5,6,7,1,2,3,4]
    * */
    private static int[] nums = {0,1,2,3,4,5,6,7,8,9};
    public static void run() {
        System.out.println(Arrays.toString(nums));
        rotate(nums,2);
        System.out.println(Arrays.toString(nums));
        rotate2(nums,2);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
