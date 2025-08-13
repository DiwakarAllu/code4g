class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        int[] ans=new int[2];
        while(l<r){
            int sum = nums[l]+nums[r];
            if(sum==target){
                ans[0]=l+1;
                ans[1]=r+1;
                return ans;
            }else if(sum>target){
                r--;
            }else{
                l++;
            }
        }
        return ans;
    }
}
