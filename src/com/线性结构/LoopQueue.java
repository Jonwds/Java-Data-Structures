package com.线性结构;

public class LoopQueue<E> implements Queue<E> {
    private int front,tail;
    private int size;
    private  E[] data;
    public LoopQueue(int capacity){
        data=(E[])new Object[capacity];
        front=tail=0;
        size=0;
    }
    public LoopQueue(){
       this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public int getSize(){
        return size;
    }
    @Override
    public boolean isEmpty(){
        return  front==tail;
    }
    @Override
    public void enqueue(E e){
        if((tail+1)%data.length==front)
            resize(2*data.length);
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }
    @Override
    public E dequeue(){
        if(front==tail)
            throw  new IllegalArgumentException("Queue is empty!");
        E e = data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if(size==getCapacity()/4 && (getCapacity()/2)!=0 )
            resize(getCapacity()/2);
        return e;

    }
    @Override
    public E getFront(){
        if(front==tail)
            throw  new IllegalArgumentException("Queue is empty!");
        return  data[front];
    }

    private void resize(int capacity){
        E[] newdata = (E[])new Object[capacity];
        for(int i=0;i<size;i++){
            newdata[i]=data[(i+front)%data.length];
        }
        data=newdata;
        front=0;
        tail=size;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue : front[");
        for(int i=front;i!=tail; i = (i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length!=tail)
                res.append(',');
        }
        res.append("]tail");
        return  res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
