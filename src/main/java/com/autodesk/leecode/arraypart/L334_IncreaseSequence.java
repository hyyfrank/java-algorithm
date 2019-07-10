package com.autodesk.leecode.arraypart;

public class L334_IncreaseSequence {
    public static void run() {
        int[] nums = {1,7,3,8,5};
        boolean included = IncreaseTripleSequence(nums);
        System.out.println("include triple increase sequence:"+included);
    }

    public static boolean IncreaseTripleSequence(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for(int i : nums){
            if(i<=x){x=i;}
            else if(i<=y){y=i;}
            else{return true;}
        }
        return false;
    }
}
