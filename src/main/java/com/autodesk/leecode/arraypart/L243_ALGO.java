package com.autodesk.leecode.arraypart;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class L243_ALGO {
    public static void run() {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        int distance = shortestDistanceI(words,"practice","coding");
        System.out.println("distance is:"+distance);

    }
    public static int shortestDistanceI(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                p1 = i;
            }
            if(words[i].equals(word2)){
                p2 = i;
            }
            if(p1 != -1 && p2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(p1 - p2));
            }
        }
        return minDistance;
    }


    public static void WordDistanceII(String[] words) {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String curWord = words[i];
            if (map.containsKey(curWord)) {
                map.get(curWord).add(i);
            } else {
                List<Integer> list = map.get(curWord);
                list.add(i);
                map.put(curWord, list);
            }
        }
    }

    public static int shortestDistance(String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        List<Integer> indexList1 = map.get(word1);
        List<Integer> indexList2 = map.get(word2);
        int minDistance = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        while (p1 < indexList1.size() && p2 < indexList2.size()) {
            int idx1 = indexList1.get(p1);
            int idx2 = indexList2.get(p2);
            minDistance = Math.min(minDistance, Math.abs(idx1 - idx2));
            if (idx1 < idx2) p1++;
            else p2++;
        }
        return minDistance;
    }
    int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, minDistance = Integer.MAX_VALUE;
        for(int i=0; i < words.length; ++i){
            String curWord = words[i];
            if(word1.equals(word2)){
                if(curWord.equals(word1)){
                    // let p1, p2 point to the two largest indexes
                    if(p2 < p1) p2 = i;
                    else p1 = i;
                }
            }else{
                if(curWord.equals(word1)) p1 = i;
                if(curWord.equals(word2)) p2 = i;
            }
            if(p1 >= 0 && p2 >= 0)
                minDistance = Math.min(minDistance, Math.abs(p1 - p2));
        }
        return minDistance;
    }
}
