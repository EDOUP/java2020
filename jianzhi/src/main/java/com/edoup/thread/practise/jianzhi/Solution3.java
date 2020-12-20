package com.edoup.thread.practise.jianzhi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * </p>
 *
 * @author edoup
 * @date 2020/5/10 22:37
 */
public class Solution3 {


    /**
     * 利用Collections
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

    public int[] reversePrint4(ListNode head) {
        List<Integer> a = new ArrayList<>();
        while (head != null) {
            a.add(head.val);
            head = head.next;
        }
        int size = a.size();
        int[] ints = new int[size];

        for (Integer integer : a) {
            ints[--size] = integer;
        }
        return ints;
    }

    /**
     * 使用stack
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 递归
     * @param listNode
     * @return
     */
    ArrayList<Integer> list3 = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        if (listNode.next != null){
            printListFromTailToHead3(listNode.next);
        }
        list3.add(listNode.val);
        return list3;
    }

    public static void main(String[] args) {
        while (true) {

            ListNode listNode = new ListNode(1);
            listNode.next = new ListNode(1);
            listNode.next.next = new ListNode(2);
            listNode.next.next.next = new ListNode(1);
            listNode.next.next.next.next = null;
            System.out.println(new Solution3().isPalindrome(listNode));
        }
     /*   System.out.println(solution3.printListFromTailToHead(listNode));
        System.out.println(solution3.printListFromTailToHead2(listNode));
        System.out.println(solution3.printListFromTailToHead3(listNode));*/
    }

    public boolean isPalindrome(ListNode head) {
        ListNode a = head;
        ListNode b = trans(head);

        while (a != null) {
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }
        return true;
    }


    ListNode trans(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode n = curr.next;
            curr.next = pre;
            pre = curr;
            curr = n;
        }
        return pre;
    }


}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
