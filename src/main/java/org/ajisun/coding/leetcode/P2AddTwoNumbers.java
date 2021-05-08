package org.ajisun.coding.leetcode;


//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学


import java.util.LinkedList;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/4/12
 * @author: ajisun
 * @Email: sunj.guang@foxmail.com
 */
public class P2AddTwoNumbers {

    public static class ListNode implements java.io.Serializable{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }


    public static class SingleLinkedList{
        private int size;
        private ListNode head;
//        private ListNode tail;

        public SingleLinkedList(){
            size = 0;
            head = null;
        }

        public void addData(int data){
            if (size==0){
                head = new ListNode(data);
                head.next = null;
                size++;
            }else {
                ListNode node = head;
                while (node.next!=null){
                    node = node.next;
                }
                node.next = new ListNode(data);
                size++;
            }
        }

        public int getSize() {
            return this.size;
        }

        public int getData(int index){
            if (index+1>size){
                return 0;
            }

            ListNode node = head;
            for (int i=0;i<index;i++){
                node = node.next;
            }

            return node.data;
        }



        @Override
        public String toString() {
            return "SingleLinkedList{" +
                    "size=" + size +
                    ", head=" + head +
                    '}';
        }
    }


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addData(1);
        linkedList.addData(2);
        linkedList.addData(3);
        System.out.println(linkedList.getData(2));
    }


    private int addNum(ListNode n1,ListNode n2){
        ListNode newOne = new ListNode(0);
        return 0;
    }




}
