class Solution {

    public boolean isPalindrome(String s) {
        int n=s.length();
        int i=0;
        int j=n-1;

        while(i<j){

            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        s=s.toLowerCase();
        s=s.replaceAll("[^a-z0-9]",""); // String.replaceAll() does not modify the original string; it returns a new string. so need to assign the result back to s. 

        int n=s.length();
        int i=0;
        int j=n-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
