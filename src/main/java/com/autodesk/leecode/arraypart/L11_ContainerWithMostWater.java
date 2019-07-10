package com.autodesk.leecode.arraypart;

public class L11_ContainerWithMostWater {
    public static void run() {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int area = mostWater(nums);
        System.out.println("max area:"+area);
    }

    public static int mostWater(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
