package leet.code.solution;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    /**
     * Runtime: 31 ms.
     * Memory Usage: 41.8 MB.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<String> firstNumber = new ArrayList<>();
        List<String> secondNumber = new ArrayList<>();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                firstNumber.add(String.valueOf(l1.val));
                l1 = l1.next;
            }
            if (l2 != null) {
                secondNumber.add(String.valueOf(l2.val));
                l2 = l2.next;
            }
        }

        Collections.reverse(firstNumber);
        Collections.reverse(secondNumber);

        String sum = new BigInteger(firstNumber.toString().replaceAll("\\W+", ""))
                .add(new BigInteger(secondNumber.toString().replaceAll("\\W+", ""))).toString();

        char[] revSum = sum.toCharArray();
        ListNode node = new ListNode(Integer.valueOf(String.valueOf(revSum[revSum.length - 1])));
        ListNode temp = node;
        for (int i = revSum.length - 2; i >= 0; i--) {
            temp.next = new ListNode(Integer.valueOf(String.valueOf(revSum[i])));
            temp = temp.next;
        }

        return node;
    }

    public static class ListNode {
        public ListNode next;
        int val;

        public ListNode(int x) {
            val = x;
        }
    }
}
