package com.线性结构;
public interface Queue<E> {
 int getSize();
 boolean isEmpty();
 void enqueue(E e);
 E dequeue();
 E getFront();
}
