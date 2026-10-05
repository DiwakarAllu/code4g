class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int x:nums){
            if(set.contains(x)){
                return true;
            }
            set.add(x);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer>st=new HashSet<>();
        return Arrays.stream(nums).anyMatch(x->!st.add(x));
    }
}
