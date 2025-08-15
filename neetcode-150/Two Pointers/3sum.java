class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n=nums.length;
        HashSet<List<Integer>>set=new HashSet<>();

        for(int i=0;i<n;i++){
            HashMap<Integer,Integer>map=new HashMap<>();
            for(int j=i+1;j<n;j++){
                int k = -(nums[i]+nums[j]);

                if(map.containsKey(k)){
                    int a = nums[i], b = nums[j], c = k;
                    int min = Math.min(a, Math.min(b, c));
                    int max = Math.max(a, Math.max(b, c));
                    int mid = a + b + c - min - max;

                    List<Integer>l=new ArrayList<>();
                    
                    l.add(min);
                    l.add(mid);
                    l.add(max);

                   // l.sort(null);
                    set.add(l);
                }
                map.put(nums[j],j);
            }
        }

        List<List<Integer>>ans=new ArrayList<>(set);
        return ans; 

    }

  
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int target = 0;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i); 
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { 
                int twoSum = nums[i] + nums[j];
                int complement = target - twoSum;

                if (map.containsKey(complement)) {
                    int k = map.get(complement);
                    if (k != i && k != j) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
