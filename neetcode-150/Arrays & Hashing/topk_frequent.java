class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        List<Integer>keys=new ArrayList<>(map.keySet());
        Collections.sort(keys,(a,b)->map.get(b)-map.get(a));
        
        
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=keys.get(i);
        }
        return res;
    }
}
