package org.example.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits
 * are stored in reverse order, and each of their nodes contains a single digit. Add the two
 * numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbersSolution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() { }

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode curr = head;
        int sum = 0;

        while (l1 != null || l2 != null) {

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            sum = sum / 10;
        }

        if (sum > 0) curr.next = new ListNode(sum);
        return head.next;
    }


    public static void main(String[] args) {
        ListNode l1;
        ListNode l2;

        l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        AddTwoNumbersSolution math = new AddTwoNumbersSolution();
        ListNode res = math.addTwoNumbers(l1, l2);

        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
