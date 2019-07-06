package com.autodesk.leecode.arraypart;

import java.util.Arrays;

public class L274_ALGO {
    public static void run() {
        int[] citations = {3,0,6,1,5};
        int pos = HIndex(citations);
        System.out.println("hindex:"+pos);
    }

    public static int HIndex(int[] citations) {
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
}
