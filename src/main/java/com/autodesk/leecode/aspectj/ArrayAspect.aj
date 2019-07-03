package com.autodesk.leecode.aspectj;
import com.autodesk.leecode.arraypart.L_26.L26_ALGO;
import com.autodesk.leecode.arraypart.L_27.L27_ALGO;
import com.autodesk.leecode.util.helper;

public aspect ArrayAspect {
    pointcut callRunL26Algo(int[] arr): execution(* L26_ALGO.removeDuplicate(int[])) && args(arr);
    pointcut callRunL27Algo(int[] arr,int val): execution(* L27_ALGO.removeElement(int[],int)) && args(arr,val);

    before(int[] arr): callRunL26Algo(arr){
        helper.printInStuff(arr);
    }
    after(int[] arr): callRunL26Algo(arr){
        helper.printOutStuff(arr);
    }
    before(int[] arr,int val): callRunL27Algo(arr,val){
        helper.printInStuff(arr);
    }
    after(int[] arr,int val): callRunL27Algo(arr,val){
        helper.printOutStuff(arr);
    }
}
