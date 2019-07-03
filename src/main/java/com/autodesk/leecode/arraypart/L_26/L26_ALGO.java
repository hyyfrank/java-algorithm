package com.autodesk.leecode.arraypart.L_26;

import com.autodesk.leecode.util.helper;

public class L26_ALGO {
    private static int[] nums = {0,0,1,1,1,2,2,3,3,4};
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * ---demo--
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素
     */
    public static void run() {
        int pos = removeDuplicate(nums);
        System.out.println("pos:"+pos);
    }
    public static int removeDuplicate(int[] nums){
        int pos = 0;
        int len = nums.length;
        for (int i=1;i<len;i++){
            if(nums[i]>nums[pos]){
                nums[++pos] = nums[i];
            }
        }
        return pos+1;
    }
}
