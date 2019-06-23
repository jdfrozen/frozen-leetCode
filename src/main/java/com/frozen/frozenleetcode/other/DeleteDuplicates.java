package com.frozen.frozenleetcode.other;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Frozen
 * @create: 2019-06-23 18:49
 * @description: Remove Duplicates from Sorted List
 **/
public class DeleteDuplicates {
    public static void main(String[] args) {
        DeleteDuplicates duplicates = new DeleteDuplicates();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        duplicates.deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode pre=head;
        ListNode temp = head;
        set.add(temp.val);
        while (temp.next!=null){
            temp=temp.next;
            if(set.contains(temp.val)) {
                //存在就删除
                pre.next = temp.next;
            }else {
                set.add(temp.val);
                pre = pre.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
