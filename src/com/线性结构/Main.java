package com.线性结构;

import java.util.Random;

public class Main {
	//测试使用q 运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
	private  static  double testQueue(Queue<Integer> q,int opCount){
		long startTime = System.nanoTime(); //单位是纳秒

		Random random = new Random();
		for(int i=0;i<opCount;i++)
			q.enqueue(random.nextInt(Integer.MAX_VALUE));
		for(int i=0;i<opCount;i++)
			q.dequeue();

		long endTime = System.nanoTime();

		return (endTime-startTime)/1000000000.0; //纳秒和秒差了10的9次方
	}
    public static void main(String[] args) {
		ArrayQueue<Integer> arrayQueue= new ArrayQueue<>();
		int opCount=100000;
		double time1 =testQueue(arrayQueue,opCount);
		System.out.println("ArrayQueue : "+time1+" s");

		LoopQueue<Integer> loopqueue= new LoopQueue<>();
		double time2 =testQueue(loopqueue,opCount);
		System.out.println("LoopQueue : "+time2+" s");

		LinkedListQueue<Integer> queue= new LinkedListQueue<>();
		double time3 =testQueue(queue,opCount);
		System.out.println("LinkedListQueue : "+time3+" s");
		//ArrayQueue : 5.161108916 s
		//LoopQueue : 0.021659576 s
		//LinkedListQueue : 0.018378429 s
		//因为ArrayQueue，每次出队后面的元素都要向前挪动，时间复杂度O(n)
		//而LoopQueue，入队、出队都很简单，时间复杂度O(1)
		//LinkedListQueue,入队、出队操作简单，时间复杂度也是O(1)
    }
}
