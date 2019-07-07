package com.autodesk.leecode.arraypart;
public class L277_FindTheCelebrity {
    public static int callNumber=0;
    public static boolean knows(int[][] nums, int i, int j) {
        callNumber++;
        return nums[i][j] == 1 ? true : false;

    }
    public static void run() {
        //a[i][j] =1 mean i know j
        //a[j][i] =1 mean j know i
        //a[i][i] =2 no meaning.
        int[][] nums = {
                {2, 0, 1, 0, 1, 0, 0, 1},
                {1, 2, 0, 0, 1, 0, 1, 1},
                {1, 1, 2, 0, 1, 0, 0, 1},
                {1, 1, 1, 2, 1, 1, 1, 1},
                {0, 0, 0, 0, 2, 0, 0, 0},
                {1, 0, 0, 1, 1, 2, 1, 1},
                {1, 0, 1, 1, 1, 0, 2, 1},
                {1, 0, 0, 0, 1, 0, 1, 2}
        };
        int pos = FindTheCelebrity(nums);
        System.out.println("called:"+callNumber);
        System.out.println("pos:" + pos);
    }

    public static int FindTheCelebrity(int[][] nums) {
        int candidate = 0;//find a candidate，启发式搜索
        for (int i = 1; i < nums.length; i++) {
            candidate = knows(nums, candidate, i) ? i : candidate;
            System.out.println("i = [" + i + "],candidate = [" + candidate + "]");
        }
        //验证候选是对的，否则说明不存在
        for (int i = 0; i < nums.length; i++) {
            if (i == candidate) {//等于自己没意义，过滤掉
                continue;
            } else if (!knows(nums, i, candidate) || (i < candidate && knows(nums, candidate, i))) {
                return -1;
            }
        }
        return candidate;
    }
}


