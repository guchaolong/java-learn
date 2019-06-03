/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/4 1.0          guchaolong          Creation File
 */
package com.guchaolong.algorithm.LeetCode;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/4 0:16
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class No2 {
    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * time O(n）
     * space O(n)
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null){
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        if(sum == 1){
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        System.out.println(11%10);
        ListNode p11 = new ListNode(2), p12 = new ListNode(4), p13 = new ListNode(3);
        p11.next = p12;
        p12.next = p13;
        ListNode p21 = new ListNode(5), p22 = new ListNode(6), p23 = new ListNode(4);
        p21.next = p22;
        p22.next = p23;
        ListNode listNode = addTwoNumbers(p11, p21);
        while (listNode != null){
            System.out.println(listNode.val+"->");
            listNode = listNode.next;
        }
}}