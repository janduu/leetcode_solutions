package org.example.leetcode;

import java.util.*;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LengthOfLongestSubstringSolution {

    // best working implementation for task
    private static int lsSlidingWindowFaster(String s) {
        Integer[] index = new Integer[128]; // ASCII

        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (index[ch] != null && index[ch] >= left) {
                max = Math.max(max, i - left);
                left = index[ch] + 1;
            }

            index[ch] = i;
        }

        return Math.max(max, s.length() - left);
    }

    // first solution that came to brain
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (charSet.contains(s.charAt(i))) {
                max = Math.max(max, charSet.size());
                i = i - charSet.size() + 1;
                charSet.clear();
            }
            charSet.add(s.charAt(i));
        }

        return Math.max(max, charSet.size());
    }

    // tried to improve before knowing better algorithm
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        boolean[] symbols = new boolean[256];
        int j;

        for (int i = 0; i < s.length(); i++) {
            symbols[s.charAt(i)] = true;
            for (j = i + 1; j < s.length(); j++) {
                if (symbols[s.charAt(j)]) {
                    max = Math.max(max, j - i);
                    break;
                }
                symbols[s.charAt(j)] = true;
            }
            max = Math.max(max, j - i);
            Arrays.fill(symbols, false);
        }

        return max;
    }

    // better algorithm with HashMap
    private static int lsSlidingWindow(String str) {

        Map<Character, Integer> chInds = new HashMap<>();

        int max = 0;
        int left = 0;

        for (int i = 0; i < str.length(); i++) {

            if (chInds.containsKey(str.charAt(i)) && left <= chInds.get(str.charAt(i))) {
                max = Math.max(max, i - left);
                left = chInds.get(str.charAt(i)) + 1;
            }

            chInds.put(str.charAt(i), i);
        }

        return Math.max(max, str.length() - left);
    }

    public static void main(String[] args) {
        LengthOfLongestSubstringSolution solution = new LengthOfLongestSubstringSolution();
        String test1 = "abcabcbb"; // 3
        String test2 = "bbbbb"; // 1
        String test3 = "pwwkew"; // 3
        String test4 = "dvdf"; // 3
        String test5 = "cdd"; // 2
        String test6 = "tmmzuxt"; // 5
        String test7 = " "; //1

        System.out.println(solution.lengthOfLongestSubstring(test1));
        System.out.println(solution.lengthOfLongestSubstring(test2));
        System.out.println(solution.lengthOfLongestSubstring(test3));
        System.out.println(solution.lengthOfLongestSubstring(test4));
        System.out.println(solution.lengthOfLongestSubstring(test5));
        System.out.println(solution.lengthOfLongestSubstring(test6));
        System.out.println(solution.lengthOfLongestSubstring(test7));


        System.out.println("====================");
        System.out.println(solution.lengthOfLongestSubstring2(test1));
        System.out.println(solution.lengthOfLongestSubstring2(test2));
        System.out.println(solution.lengthOfLongestSubstring2(test3));
        System.out.println(solution.lengthOfLongestSubstring2(test4));
        System.out.println(solution.lengthOfLongestSubstring2(test5));
        System.out.println(solution.lengthOfLongestSubstring2(test6));
        System.out.println(solution.lengthOfLongestSubstring2(test7));

        System.out.println("====================");
        System.out.println(lsSlidingWindow(test1));
        System.out.println(lsSlidingWindow(test2));
        System.out.println(lsSlidingWindow(test3));
        System.out.println(lsSlidingWindow(test4));
        System.out.println(lsSlidingWindow(test5));
        System.out.println(lsSlidingWindow(test6));
        System.out.println(lsSlidingWindow(test7));

        System.out.println("====================");
        System.out.println(lsSlidingWindowFaster(test1));
        System.out.println(lsSlidingWindowFaster(test2));
        System.out.println(lsSlidingWindowFaster(test3));
        System.out.println(lsSlidingWindowFaster(test4));
        System.out.println(lsSlidingWindowFaster(test5));
        System.out.println(lsSlidingWindowFaster(test6));
        System.out.println(lsSlidingWindowFaster(test7));
    }
}
