class Solution {

    public String encode(String[] s) {
        StringBuilder sb = new StringBuilder();
        for (String str : s) {
            sb.append(str.length()).append("*").append(str);
        }
        return sb.toString();
    }

    public String[] decode(String s) {
        int i = 0;
        int n = s.length();
        List<String> l = new ArrayList<>();

        while (i < n) {
          
            // Find the '*'
            int j = i;
            while (s.charAt(j) != '*') {
                j++;
            }

            // Get the length
            int len = Integer.parseInt(s.substring(i, j));

            // Extract the actual string
            String str = s.substring(j + 1, j + 1 + len);
            l.add(str);

            // Move i to the start of next encoded segment
            i = j + 1 + len;
        }

        return l.toArray(new String[0]);
    }
}
