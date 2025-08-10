"""
Date: August 9, 2025
Problem: power-of-two (LeetCode #231)
Link: https://leetcode.com/problems/power-of-two/description/
"""
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        return (n>0)&&(Math.pow(2,30)%n==0);
    }
    public boolean isPowerOfTwo_v3(int n) {
        if(n<=0) return false;
        return ((n&(n-1))==0);
    }

    public boolean isPowerOfTwo_v2(int n) {
        if(n<=0) return false;
        int bit_count=Integer.bitCount(n);
        if(bit_count==1){
            return true;
        }
        return false;
    }

    public boolean isPowerOfTwo_init(int n) {
        if(n==1) return true;
        if(n<=0) return false;

        String bin = Integer.toBinaryString(n);
        String x=bin.substring(1);
        return !x.contains("1");
    }
}  
