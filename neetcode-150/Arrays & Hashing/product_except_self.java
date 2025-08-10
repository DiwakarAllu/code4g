class Solution {
    public int[] productExceptSelf(int[] nums){
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);

       // Build prefix product (product of all elements to the left of i)
        int curr=1;
        for(int i=0;i<n;i++){ 
            ans[i]=ans[i]*curr;
            curr=curr*nums[i];
        }

      // Build suffix product (product of all elements to the right of i)
        curr=1;
        for(int i=n-1;i>=0;i--){ 
            ans[i]=ans[i]*curr;
            curr=curr*nums[i];
        }
        

        return ans;
    }

    public int[] productExceptSelf_second(int[] nums){
        int n=nums.length;

        // prefix[i] = product of all elements before index i
        int[] prefix = new int[nums.length];
        prefix[0]=1;
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }

        // suffix[i] = product of all elements after index i
        int[] suffix = new int[nums.length];
        suffix[n-1]=1;
        for(int i=n-2;i>=0;i--){
            suffix[i]= suffix[i+1]*nums[i+1];
        }

        int[] ans = new int[nums.length];
        for(int i=0;i<n;i++){
            ans[i]=prefix[i]*suffix[i];
        } 

        return ans;
    }

    public int[] productExceptSelf_init(int[] nums) {
        int prod=1;
        int zero=0;
        for(int i:nums){
            if(i!=0){
                prod=prod*i;
            }else{
                zero++;
            }
        }

        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(zero==1 && nums[i]==0){
                ans[i] = prod;
            }else if(zero>1){
                return ans;
            }else if(zero==0){
               ans[i]=(prod/nums[i]);
            }
        }
        return ans;
    }
}
