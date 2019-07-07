package com.autodesk.leecode.arraypart;

public class L55_JumpGameI {
    public static void run() {
        int[] nums = {2,3,1,1,4};
        System.out.println("1.can jump return: "+canJumpI(nums));
        int[] nums2={2,3,1,1,4};
        System.out.println("2.can jump return:"+canJumpII(nums2));
    }

    public static boolean canJumpI (int[] nums) {
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i + nums[i] >= lastPos) {
                    lastPos = i;
                }
            }
            return lastPos == 0;
    }

    /**
     *
     * Input: [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2.
     *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * @param nums
     * @return
     */
    public static int canJumpII(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int lastReach = 0;
        int reach = 0;
        int step = 0;
        for (int i = 0; i <= reach && i < nums.length; i++) {
            //when last jump can not read current i, increase the step by 1
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            //update the maximal jump
            reach = Math.max(reach, nums[i] + i);
        }
        if (reach < nums.length - 1)
            return 0;
        return step;
    }
}
