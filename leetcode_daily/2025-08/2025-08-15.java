"""
Date: August 15, 2025
Problem: power-of-four (LeetCode #342)
Link: https://leetcode.com/problems/power-of-four/
"""
  class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        
        boolean is_2pow = (n & (n - 1)) == 0; // ? n is a power of two = only one set bit.
        int x = 0x55555555; // 0b 0101 0101 0101 0101 0101 0101 0101 0101 = 32-bit pattern with 1s in even bits                
        
        boolean is_at_even = (n & x) != 0;    
        
        return is_2pow && is_at_even;
    }
}

  
