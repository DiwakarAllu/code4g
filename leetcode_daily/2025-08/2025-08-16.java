"""
Date: August 16, 2025
Problem: maximum-69-number (LeetCode #1323)
Link: https://leetcode.com/problems/maximum-69-number/
"""
  class Solution {
    public int maximum69Number (int num) {
        int idx=-1;
        int cnt=0;
        int temp=num;
        while(temp>0){
          int digit = temp%10;
          if(digit == 6 ){
             idx=cnt;
          }
          temp = temp/10;
          cnt++;
        }
        if (idx==-1) return num;

        return (num+3*(int)Math.pow(10,idx));
    }
    
    public int maximum69Number2 (int num) {
        String x = String.valueOf(num);
        int idx = x.indexOf('6');
        StringBuilder sb = new StringBuilder(x);
        if(idx!=-1) sb.setCharAt(idx,'9');
        return Integer.parseInt(sb.toString());
    }
}
