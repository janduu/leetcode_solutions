package org.example.leetcode;

import java.util.*;

public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer idx = indices.get(target - nums[i]);

            if (idx != null && idx != i) {
                return new int[] {i, idx};
            } else {
                indices.put(nums[i], i);
            }
        }
        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(Arrays.toString(new TwoSumSolution().twoSum(nums, 6)));
    }
}
