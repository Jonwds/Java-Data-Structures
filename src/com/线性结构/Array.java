package com.线性结构;

public class Array<E> {
    private E[] data;
    private  int size;
    //构造函数，传入数组容量capacity
    public Array(int capacity){
        data=(E[])new Object[capacity];
        size=0;
    }
    //无参构造函数，默认数组容量capacity=10
    public Array(){
        this(10);
    }
    //getCapacity获取数组的容量
    public int getCapacity(){
        return data.length;
    }
    //getSize获取数组的元素个数
    public int getSize(){
        return size;
    }
    //isEmpty返回数组是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //add 在index索引的位置插入一个新元素e,时间复杂度O(n)
    public void add(int index,E e){
        if(size==data.length)
            resize(2*data.length);
        if(index<0 || index > size)
            throw  new IllegalArgumentException("Index is illegal.");
        for(int i=size;i>index;i--){
            data[i]=data[i-1];
        }
        data[index]=e;
        size++;
    }
    //addLast 向所有元素后添加一个新元素e,时间复杂度O(1)
    public void addLast(E e){
        add(size,e);
    }
    //addFirst 在所有元素前添加一个新元素e,时间复杂度O(n)
    public void addFirst(E e){
        add(0,e);
    }
    //get  获取index索引位置的元素,时间复杂度O(1)
    public E get(int index){
        if(index<0 || index>=size)
            throw  new IllegalArgumentException("Index illegal");
        return data[index];
    }
    //getLast 获取最后一个元素
    public E getLast(){
        return get(size-1);
    }
    public E getFirst(){
        return  get(0);
    }
    //set 修改index索引位置的元素为e,时间复杂度O(1)
    public void set(int index,E e){
        if(index<0 || index>=size)
            throw  new IllegalArgumentException("Index illegal");
        data[index]=e;
    }
    //contains 查找数组中是否有元素e,时间复杂度O(n)
    public boolean contains(E e){
        for(int i=0;i<size;i++)
            if(data[i].equals(e))
                return true;

        return false;
    }
    //find  查找数组中元素e所在的索引，如果不存在，则返回-1. 时间复杂度O(n)
    public int find(E e){
        for(int i=0;i<size;i++)
            if(data[i].equals(e))
                return i;
        return -1;
    }
    //remove 从数组中删除index位置的元素，返回删除的元素,时间复杂度O(n)
    public E remove(int index){
        if(index<0 || index>=size)
            throw  new IllegalArgumentException("Index illegal");
        E ret = data[index];
        for(int i=index;i<size-1;i++){
            data[i]=data[i+1];
        }
        size--;
        data[size]=null;
        if(size==data.length/4)
            resize(data.length/2);
        return ret;
    }
    //removeFirst 从数组中删除第一个元素，返回删除的元素,时间复杂度O(n)
    public E removeFirst(){
        return remove(0);
    }
    //removeLast 从数组中删除最后一个元素，返回删除的元素,时间复杂度O(1)
    public E removeLast(){
        return remove(size-1);
    }
    //removeElement 从数组中删除元素e,时间复杂度O(n)
    public void removeElement(E e){
        int index=find(e);
        if(index!=-1)
            remove(index);
    }
    //resize  将数组容量改变成newCapacity的大小,时间复杂度O(n)
    private void resize(int newCapacity){
        E[] arr = (E[])new Object[newCapacity];
        for(int i=0;i<size;i++){
            arr[i]=data[i];
        }
        data=arr;
    }
    //重写toString方法
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array : size=%d , Capacity=%d \n",size,data.length));
        res.append('[');
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1)
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for(int i=0;i<10;i++)
            arr.addLast(i);
        System.out.println(arr);
        arr.removeElement(4);
        System.out.println(arr);
        for (int i = 0; i < 4; i++) {
            arr.removeFirst();
        }
        System.out.println(arr);
    }
}
