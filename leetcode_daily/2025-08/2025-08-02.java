"""
Date: August 2, 2025
Problem: Rearranging Fruits (LeetCode #2561)
Link: https://leetcode.com/problems/rearranging-fruits/description/
"""
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int mini = Integer.MAX_VALUE;  // Track smallest fruit cost

        // Count fruit frequencies from basket1
        for (int x : basket1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            mini = Math.min(mini, x);
        }

        // Subtract fruit frequencies from basket2
        for (int x : basket2) {
            map.put(x, map.getOrDefault(x, 0) - 1);
            mini = Math.min(mini, x);
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Check if balancing is possible and collect fruits to swap
        for (int fruit : map.keySet()) {
            int diff = map.get(fruit);
            if (diff % 2 != 0) {
                return -1;  // Odd difference means impossible to balance
            }

            // Add half of the difference to the swap list
            for (int i = 0; i < Math.abs(diff) / 2; i++) {
                list.add(fruit);
            }
        }

        Collections.sort(list);  // Sort to pick cheaper swaps first

        long totalCost = 0;
        int n = list.size();

        // Loop only half because each swap fixes two fruits
        for (int i = 0; i < n / 2; i++) {
            int fruitCost = list.get(i);
            // Choose cheaper between direct swap and double smallest fruit swap
            totalCost += Math.min(fruitCost, 2 * mini);
        }

        return totalCost;
    }
}


// Refer it : https://medium.com/@diwakar.allu.3435/understanding-the-solution-to-leetcode-2561-rearranging-fruits-688a042496b9
