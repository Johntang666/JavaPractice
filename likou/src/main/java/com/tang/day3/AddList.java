//package com.tang.day3;
//
//public class AddList {
//    class ListNode{
//        int data;
//        ListNode next;
//
//        public ListNode(int data) {
//            this.data=data;
//        }
//
//        public ListNode() {
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//    public ListNode addList(ListNode l1, ListNode l2){
//        ListNode p1=l1,p2=l2;
//        ListNode head=new ListNode();
//        ListNode currentNode=head;
//        int flag=0;
//        while(l1!=null||l2!=null){
//            int sum=l1.data+l2.data;
//            if(flag==1){
//                sum++;
//                flag=0;
//            }
//            if(sum>10){
//                sum=sum%10;
//                flag=1;
//            }
//            ListNode node=new ListNode(sum);
//            currentNode.next=node;
//            currentNode=node;
//            if(l1.next==null||l2.next==null){
//                if(flag==0){
//                    currentNode.next=l1.next==null ? l2.next:l1.next;
//                    break;;
//                }else {
//                    if(l1.next==null)
//                }
//            }
//        }
//
//    }
//}
