package com.autodesk.leecode.arraypart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L217_ContainsDuplicate {
    public static void run() {
        int[] nums = {1,2,3,4,1};
        System.out.println("is duplicated? "+ containsDuplicateIII(nums));
    }
    public static boolean containsDuplicateI(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] == nums[i]) return true;
            }
        }
        return false;
    }
    public static boolean containsDuplicateII(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static boolean containsDuplicateIII(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

}
