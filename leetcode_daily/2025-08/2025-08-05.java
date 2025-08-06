"""
Date: August 5, 2025
Problem:fruit-into-baskets-ii (LeetCode #3477)
Link: https://leetcode.com/problems/fruits-into-baskets-ii/description/
"""
  class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        boolean[] val = new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(fruits[i]<=baskets[j] && !val[j]){
                    cnt++;
                    val[j]=true;
                    break;
                }
            }
        }
        return n-cnt;
    }
}
