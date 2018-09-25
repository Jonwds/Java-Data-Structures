package com.线性结构;
//使用带有头、尾指针的链表来实现队列
public class LinkedListQueue<E> implements Queue<E> {
    private class Node{
        public E e;
        public Node next;
        public  Node(E e,Node next){
            this.e=e;this.next=next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }
    private Node head,tail;
    private int size;
    public  LinkedListQueue(){
        head=tail=null;
        size=0;
    }
    public int getSize(){
        return  size;
    }
    public boolean isEmpty(){
        return  size==0;
    }
    public void enqueue(E e){
        if(tail==null){
            tail = new Node(e);
            head=tail;
        }
        else{
            Node node = new Node(e);
            tail.next=node;
            tail=node;
        }
        size++;
    }
    public E dequeue(){
        if(isEmpty())
            throw new IllegalArgumentException("Empty");
        Node del =head;
        head=head.next;
        del.next=null;
        if(head==null)
            tail=null;
        size--;
        return del.e;
    }
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Empty");
        return head.e;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front");
        Node cur=head;
        while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
