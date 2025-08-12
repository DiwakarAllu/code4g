import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        // HashSet for fast lookups
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {
            // Only start counting if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the consecutive sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update maxLen with the maximum streak found
                maxLen = Math.max(maxLen, currentStreak);
            }
        }

        return maxLen;
    }
}
