class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        int n=strs.length;
        for(String x:strs){

            int[] freq=new int[26];
            for(char c:x.toCharArray()){
                freq[c-'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int y:freq){
                sb.append("*");
                sb.append(y);
            }
            String key = sb.toString();

            if(map.containsKey(key)){
                map.get(key).add(x);
            }else{
                ArrayList<String>l=new ArrayList<>();
                l.add(x);
                map.put(key,l);
            }
         
        }
        return new ArrayList<>(map.values());
    }    
  
     public List<List<String>> groupAnagrams_second(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        int n=strs.length;
        for(String x:strs){
            char[] s=x.toCharArray();
            Arrays.sort(s);
            String key=new String(s);
            if(map.containsKey(key)){
               map.get(key).add(x);
            }else{
                ArrayList<String>l=new ArrayList<>();
                l.add(x);
                map.put(key,l);
            }
        }
        return new ArrayList<>(map.values());
     }

    public List<List<String>> groupAnagrams_init(String[] strs) {
        HashMap<String,String>map=new HashMap<>();
        int n=strs.length;
        for(int i=0;i<n;i++){
            char[] s= strs[i].toCharArray();
            Arrays.sort(s);
            String x= new String(s);
            if(map.containsKey(x)){
                map.put(x,map.get(x)+","+String.valueOf(i));
            }else{
                map.put(x,String.valueOf(i));
            }
        }
        List<List<String>>ans=new ArrayList<>();
        for(String x:map.keySet()){
            List<String>temp=new ArrayList<>();
            String idx = map.get(x);
            String[] list = idx.split(",");
            for(String c:list){
                temp.add(strs[Integer.valueOf(c)]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
