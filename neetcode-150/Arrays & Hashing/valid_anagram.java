class Solution {
    boolean isAna(String s1,String s2){ 
        if(s1.length()!=s2.length()) return false;

        int[] count = new int[26]; // O(1) — Fixed size array of 26 ints
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }

        for(int x:count){
            if(x!=0) return false;
        }
        return true;
    }
  
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);

       // return Arrays.equals(s1,s2);
       return isAna(s,t);
    }
}
