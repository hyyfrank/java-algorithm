package com.autodesk.leecode.arraypart;

import com.autodesk.leecode.util.helper;

public class L27_ALGO {
    /**
     * 给定一个无序数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * -----demo---
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * 注意这五个元素可为任意顺序。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public static void run() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int pos = removeElement(nums,2);
        System.out.println("pos:"+pos);
    }

    public static int removeElement(int[] nums,int val){
        int len = nums.length;
        int pos = 0;
        for (int i=0;i<len;i++){
            if(nums[i] != val){
                nums[pos++]=nums[i];
            }
        }
        return pos;
    }

}
