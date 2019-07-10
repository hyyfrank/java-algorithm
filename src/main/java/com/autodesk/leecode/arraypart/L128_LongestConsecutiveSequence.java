package com.autodesk.leecode.arraypart;

import java.util.HashSet;

public class L128_LongestConsecutiveSequence {
    public static void run() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int length = LongesetConsecutiveSequence(nums);
        System.out.println("longest consecutive sequence:"+length);
    }

    public static int LongesetConsecutiveSequence(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        int result = 0;
        for(int num: nums){
            int count = 1;
            int down = num-1;
            while(set.contains(down)){
                set.remove(down);
                down--;
                count++;
            }
            int up = num+1;
            while(set.contains(up)){
                set.remove(up);
                up++;
                count++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
