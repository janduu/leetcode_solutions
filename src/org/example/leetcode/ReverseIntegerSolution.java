package org.example.leetcode;

public class ReverseIntegerSolution {
    public int reverse(int x) {
        if (x < 10 && x > -10)
            return x;

        int len = (int) (Math.log10(Math.abs(x)) + 1);
        long reversed = 0;

        for (int i = len - 1; i >= 0; x /= 10, i--) {
            int digit = x % 10;
            reversed += digit * Math.pow(10, i);
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;
        return (int) reversed;
    }

    public int reverseSolutionFromLeetCode(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseIntegerSolution().reverse(-123456));
    }
}
