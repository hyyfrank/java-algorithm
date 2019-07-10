package com.autodesk.leecode.arraypart;

public class L42_TrappingRainWater {
    public static void run() {
       int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
       int maxRain = TappingRainWater(nums);
        System.out.println("max rain collected:"+maxRain);
    }

    public static int TappingRainWater(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while(left < right) {
            if(height[left] < height[right]) {
                int bound = height[left];
                int i = left + 1;
                while(i < right && height[i] < bound) {
                    res += bound - height[i];
                    i ++;
                }
                left = i;
            }
            else {
                int bound = height[right];
                int i = right - 1;
                while(i > left && height[i] < bound) {
                    res += bound - height[i];
                    i --;
                }
                right = i;
            }
        }
        return res;

    }
}
