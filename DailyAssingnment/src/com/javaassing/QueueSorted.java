package com.javaassing;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class QueueSorted {
	public static void sortQueue(Queue<Integer>queue) {
		Stack<Integer> stack = new Stack<>();
		//loop unitl the queue is fully sorted
		
		for (int i = 0; i < queue.size(); i++) {
			//identify the smallest element in the queue 
			int minIndex = -1;
			int minValue = Integer.MAX_VALUE;
			int queueSize = queue.size();
			
			//traverse the queue to find the minimum element 
			for (int j = 0; j < queueSize; j++) {
				int current = queue.poll();
				if (current < minValue && j < queueSize - i) {
					minValue = current;
					minIndex= j;
				}
				queue.add(current);
			}
			
			//move elements to the stack until reaching the minimum element 
			for(int j = 0; j < queueSize; j++) {
				int current = queue.poll();
				if(j != minIndex) {
					stack.push(current);
				}
			}
			//push the minimum element back to the queue
			queue.add(minValue);
			
			//restore elements from the stack to the queue
			while (!stack.isEmpty()) {
				queue.add(stack.pop());
			}
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer>queue = new LinkedList<>();
		queue.add(3);
		queue.add(1);
		queue.add(4);
		queue.add(1);
		queue.add(5);
		queue.add(9);
		queue.add(2);
		queue.add(6);
		queue.add(5);
		queue.add(3);
		queue.add(5);
		
		System.out.println("Original queue:" + queue);
		sortQueue(queue);
		System.out.println("Sorted queue:" + queue);
	}

}




