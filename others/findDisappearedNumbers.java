class Solution {
    /**
1. Math.abs(nums[i])
   ↓
   Get the original number even if we've made it negative.

2. - 1
   ↓
   Convert number → array index.
   Number 5 → index 4.

3. nums[idx] = -Math.abs(nums[idx])
   ↓
   Mark that number as "seen".

4. ans.add(i + 1)
   ↓
   Convert missing index → missing number.

     */
    public List<Integer> fdn2(int[] nums){
        List<Integer> ans = new ArrayList<>();
// nums range = [1,n] i.e. their idx = [0,n-1] ===> idx = num - 1
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i]) - 1;  
            nums[idx] = - Math.abs(nums[idx]);
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans.add(i+1);
            }
        }

        return ans;
    }

    public List<Integer> fdn(int[] nums){
       StringBuilder sb = new StringBuilder();
       
       List<Integer> ans = new ArrayList<>();
       for(int i : nums){
           sb.append("*");
           sb.append(i);
           sb.append("*");
       }
       String s = sb.toString();
       for(int i=1;i<=nums.length;i++){
          if(!s.contains("*"+i+"*")) ans.add(i);
       }

       return ans;

    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> hs = new HashSet<>(); // -- extra space 
        for(int i:nums) hs.add(i);

        List<Integer>ans=new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if(!hs.contains(i))
                ans.add(i);
        }
       // return ans;
       return fdn2(nums);
    }
}
