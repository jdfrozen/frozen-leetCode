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
    }

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode pre=head;
        ListNode temp = head;
        set.add(temp.val);
        while (temp.next!=null){
            temp=temp.next;
            if(set.contains(temp)) {
                //存在就删除
                pre.next = temp;
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
