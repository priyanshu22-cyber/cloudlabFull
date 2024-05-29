package com.javaassing;
class ListNode{
	int val;
	ListNode next;
	ListNode(int x) {val=x;}
}

public class LinkedListMiddle {
	public static ListNode findMiddle(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast !=null && fast.next !=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	//helper function to create a linked list form an array of values 
	public static ListNode createLinkedList(int[] arr) {
		if(arr.length == 0) {
			return null;
		}
		ListNode head = new ListNode(arr[0]);
		ListNode current = head;
		
		for (int i=1; i<arr.length;i++) {
			current.next = new ListNode(arr[i]);
			current = current.next;
		}
		return head;
	}
	
	//helper function to print the linked list 
	public static void printLinkedList(ListNode head) {
		ListNode current = head;
		while (current !=null) {
			System.out.print(current.val + " -> ");
			current = current.next;
			
		}
		System.out.println("null");
	}
	public static void main(String[] args) {
		int[] values = {1, 2, 3, 4, 5};
		ListNode head = createLinkedList(values);
		
		System.out.print("Linked List: ");
		printLinkedList(head);
		
		ListNode middle = findMiddle(head);
		if(middle != null) {
			System.out.println("Middle element: " + middle.val);
		}else {
			System.out.println("the list is empty.");
		}
		
    }
 

}
