"""
Date: August 1, 2025
Problem: Pascal's triangle (LeetCode #118)
Link: https://leetcode.com/problems/pascals-triangle/description/
"""
 class Solution { -----------> O(n^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {  // For each row (1-indexed)
            List<Integer> temp = new ArrayList<>();
            int res = 1;                     // First element is always 1
            temp.add(res);

            for (int j = 1; j < i; j++) {  
                res = res * (i - j);
                res = res / j;
                temp.add(res);
            }

            ans.add(temp);
        }

        return ans;
    }
}
---------------------------------------------------------
  class Solution { ------> O(n^3)
    static int ncr(int n,int r){
        int res=1;
        for(int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
       
        for(int i=1;i<=numRows;i++){ // nth row = n elements
           List<Integer>temp=new ArrayList<>();
           for(int j=1;j<=i;j++){
            int res=ncr(i-1,j-1);
            temp.add(res);
           }
           ans.add(temp);
        }
        return ans;
    }
}
 
