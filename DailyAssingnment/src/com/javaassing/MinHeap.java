package com.javaassing;
import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	private List<Integer> heap;
	
	public MinHeap() {
		heap = new ArrayList<>();
	}
	
	//method to get the index of the parent of a node 
	private int parent(int index) {
		return (index - 1) / 2;
	}
	
	//method to get the index of the left child of a node
	private int leftChild(int index) {
		return 2 * index + 1;
	}
	
	//method to get the index of the right child of a node 
	private int rightChild(int index) {
		return 2 * index + 2;
	}
	
	//method to insert a new element into the heap
	public void insert(int element) {
		heap.add(element);
		heapifyUp(heap.size() -1);
	}
	
	//method to maintain the heap property after insertion
	private void heapifyUp(int index) {
		while (index > 0 && heap.get(parent(index)) > heap.get(index)) {
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	public int deleteMin() {
		if (heap.isEmpty()) {
			throw new IllegalStateException("heap is empty");
		}
		
		int minElement = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		heapifyDown(0);
		
		return minElement;
	}
	
	public void heapifyDown(int index) {
		int left = leftChild(index);
		int right = rightChild(index);
		int smallest = index;
		
		if(left < heap.size() && heap.get(left) < heap.get(smallest)) {
			smallest = left;
		}
		if(right < heap.size() && heap.get(right) < heap.get(smallest)) {
			smallest = right;
		}
		
		if (smallest != index) {
			swap(index, smallest);
			heapifyDown(smallest);
		}
	}
	
	public int getMin() {
		if(heap.isEmpty()) {
			throw new IllegalStateException("heap is empty");
		}
		return heap.get(0);
	}
	
	public void swap(int index1, int index2) {
		int temp = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}
	
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.insert(3);
		minHeap.insert(1);
		minHeap.insert(6);
		minHeap.insert(5);
		minHeap.insert(2);
		minHeap.insert(4);
		
		System.out.println("minimum element: " + minHeap.getMin());
		System.out.println("removed minimum element: " + minHeap.deleteMin());
		
		System.out.println("new minimum element: " + minHeap.getMin());
	}

}
