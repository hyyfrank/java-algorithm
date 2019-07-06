package com.autodesk.leecode.arraypart;

import java.util.Arrays;

public class L274_ALGO {
    public static void run() {
        int[] citations = {3,0,6,1,5};
        int pos = hIndexIII(citations);
        System.out.println("hindex:"+pos);
    }

    public static int HIndexI(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        for(int i=citations.length-1; i>=0; i--){
            int cnt = citations.length-i;
            if(citations[i]>=cnt){
                result = cnt;
            }else{
                break;
            }
        }

        return result;
    }
    public static int HIndexII(int[] citations) {
        int len = citations.length;
        int[] counter = new int[len+1];
        for(int c: citations){
            counter[Math.min(len,c)]++;
        }
        int k=len;
        for(int s=counter[len]; k > s; s += counter[k]){
            k--;
        }

        return k;
    }
    public static int hIndexIII(int[] citations) {
        int len = citations.length;
        int low = 0;
        int high = len - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (len - mid > citations[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return len - low;
    }
}
