"""
Date: August 4, 2025
Problem:fruit-into-baskets (LeetCode #904)
Link: https://leetcode.com/problems/fruit-into-baskets/description/
"""
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int totalFruit(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0;
        int j = 0;
        int n = arr.length;
        int k = 2;

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        while (j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                while (map.size() > k && i < n) {
                    map.put(arr[i], map.get(arr[i]) - 1);
                    if (map.get(arr[i]) == 0) {
                        map.remove(arr[i]);
                    }
                    i++;
                }
                j++;
            }
        }

        max = Math.max(max, j - i);
        return max;
    }
}
