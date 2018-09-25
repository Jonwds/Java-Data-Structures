package com.leetcode;



public class Test203 {
        public ListNode removeElements(ListNode head, int val) {
            while(head!=null && head.val==val ){ //head=head.next;
                ListNode del =head;
                head=head.next;
                del.next=null;
            }
            if(head==null)
                return null;
            ListNode prev = head;
            while(prev.next!=null){
                if(prev.next.val==val){  //prev.next=prev.next.next;
                    ListNode del = prev.next;
                    prev.next=del.next;
                    del.next=null;
                }
                else
                    prev=prev.next;
            }
            return head;
        }

        public ListNode removeElements2(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next=head;
            ListNode prev = dummyHead;
            while(prev.next!=null){
                if(prev.next.val==val)
                    prev.next=prev.next.next;
                else
                    prev=prev.next;
            }
            return dummyHead.next;
        }
        public ListNode removeElements3(ListNode head, int val) {
            if(head==null)
                return head;
            ListNode res= removeElements(head.next,val);
            if(head.val==val)
                return res;
            else {
                head.next=res;
                return head;
            }
        }

        public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,5,6};
        ListNode node= new ListNode(arr);
        System.out.println(node);
        ListNode res = (new Test203()).removeElements(node,6);
        System.out.println(res);

    }
}
