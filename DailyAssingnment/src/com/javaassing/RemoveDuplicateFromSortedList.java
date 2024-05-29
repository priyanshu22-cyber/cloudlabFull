package com.javaassing;
class ListNode{
	int val;
	ListNode next;
	ListNode(int x) {val = x;}
}

public class RemoveDuplicateFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		// initialize the current node as the head of the list 
		ListNode current = head;
		
		//traverse the list until the end 
		while (current !=null && current.next !=null) {
			// if the current node and the next node have the same value 
			if (current.val == current.next.val) {
				//skip the next node by pointing the current node to the next of next node
				current.next = current.next.next;
			}else {
				current = current.next;
			}
		}
		
		//return the head of the modified list
		return head;
	}
	
	// helper method to print the list (optional, for testing purposes)
	public static void printList(ListNode head) {
		ListNode current = head;
		while (current !=null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		//create a sorted Linked List with duplicates
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		
		System.out.println("original list:");
		printList(head);
		
		RemoveDuplicateFromSortedList solution = new RemoveDuplicateFromSortedList();
		ListNode newHead = solution.deleteDuplicates(head);
		
		System.out.println("list after removing duplicate:");
		printList(newHead);
	}

}
