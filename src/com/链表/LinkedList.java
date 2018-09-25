package com.链表;
public class LinkedList<E> {
    private class Node{
    public E e;
    public  Node next;//next是指向Node的引用

    public Node(E e,Node next){
        this.e=e;
        this.next=next;
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
    private Node dummyhead;
    private int size;
    public LinkedList(){
        dummyhead=new Node();
        size=0;
    }
    //getSize 获取链表中的元素个数
    public int getSize(){
        return size;
    }
    //isEmpty返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //add在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(E e,int index){
        if(index<0 || index>size)
            throw new IllegalArgumentException("Add failed");
            Node prev = dummyhead;
            for(int i=0;i<index;i++){
                prev=prev.next;
            }
            Node cur = new Node(e);
            cur.next=prev.next;
            prev.next=cur;
            size++;

        }
    //addFirst在链表头添加新的元素e
    public void addFirst(E e){
        add(e,0);
    }
     //addLast在链表末尾添加新的元素e
     public void addLast(E e){
        add(e,size);
    }
    //find 找到元素e所在的index
    public int find(E e){
        int index=0;
        Node cur =dummyhead.next;
        while (cur!=null){
            if(cur.e.equals(e))
                return index;
            else{
                cur=cur.next;
                index++;
            }
        }
        return -1;
    }

    // get获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index){
        if(index<0 || index>size)
            throw new IllegalArgumentException("Add failed");
        Node cur = dummyhead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }
    // getFirst获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }
    // getLast获得链表的最后一个元素
    public E getLast(){
        return get(size-1);
    }
    // set 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(E e,int index){
        if(index<0 || index>size)
            throw new IllegalArgumentException("Set failed");
        Node cur = dummyhead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }
    //contains 查找链表中是否有元素e
    public boolean contains(E e){
        Node cur=dummyhead.next;
        while(cur!=null){
            if(cur.e.equals(e))
                return true;
            cur=cur.next;
        }
        return false;
    }
    //重写toString方法
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(" LinkedList : ");
        Node temp = dummyhead.next;
        while(temp!=null){
            res.append(temp+"->");
            temp=temp.next;
        }
        res.append("NULL");
        return res.toString();
    }
    // remove从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index){
        if(index<0 || index >=size)
            throw new IllegalArgumentException("Remove failed");
        Node prev = dummyhead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node del = prev.next;
        prev.next=del.next;
        del.next=null;
        size--;
        return del.e;
    }
    // removeFirst从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }
    // removeLast从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }
    // removeElement从链表中删除元素e
    public void removeElement(E e){
        if(!contains(e))
            throw new IllegalArgumentException("e don't exist.");
        remove(find(e));
    }



    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<5;i++){
            list.addFirst(i);
            System.out.println(list);
        }
        list.add(666,2);
        System.out.println(list);
        list.removeElement(0);
        System.out.println(list);
        list.removeLast();
        System.out.println(list);

    }
    }


