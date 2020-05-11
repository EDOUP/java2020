package com.edoup.thread.practise.jianzhi;

import java.util.ArrayList;
import java.util.Collections;
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


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = null;
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.printListFromTailToHead(listNode));
        System.out.println(solution3.printListFromTailToHead2(listNode));
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
