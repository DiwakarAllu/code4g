"""
Date: August 14, 2025
Problem: largest-3-same-digit-number-in-string (LeetCode #2264)
Link: https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/
"""
class Solution {
  
    private static final List<String> sameDigitNumbers = List.of(
        "999", "888", "777", "666", "555", "444", "333", "222", "111", "000"
    );

    public String largestGoodInteger(String num) {
        for (String good : sameDigitNumbers) {
            if (num.contains(good)) {
                return good;
            }
        }
        return "";
    }


    public String largestGoodInteger2(String num) {
        int n=num.length();
        int max=0;
        String ans="";
        for(int i=0;i<n-2;i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i)==num.charAt(i+2)){
               
                String temp=num.substring(i,i+3);
                if(ans.compareTo(temp)<0){  // a.compareTo(b) < 0 => a is less than b
                    ans=temp;
                }

            }
        }
      
       return ans;
    }
}
