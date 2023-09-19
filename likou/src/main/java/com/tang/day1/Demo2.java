package com.tang.day1;

import java.util.Arrays;

public class Demo2 {
    static class LNode{
        int data;
        LNode next;

        public LNode(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "LNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    public static void main(String[] args) {
        LNode head = new LNode(3);
        LNode node1 = new LNode(2);
        LNode node2 = new LNode(12);
        LNode node3 = new LNode(11);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        // 打印链表元素
        Arrays.stream(new LNode[]{head}).forEach(System.out::println);
        reverse(head);
        Arrays.stream(new LNode[]{head}).forEach(System.out::println);
    }

    /**
     * 反转链表：题目没有头结点
     * head->3->2->12->11->null变成head->11->12->2->3->null
     * @param head
     */
    public static LNode reverse(LNode head){
        if(head==null||head.next==null){
            return head;
        }
        LNode preNode = head;
        LNode currentNode=head.next;
        head.next=null;
        while (currentNode!=null){
            LNode save=currentNode.next;
            currentNode.next=preNode;
            preNode=currentNode;
            currentNode=save;
        }
        return head;
    }
}
