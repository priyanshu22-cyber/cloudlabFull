package com.javaassing;
import java.util.Stack;


public class StackSorted {
	public static void sortStack(Stack<Integer>stack) {
		Stack<Integer>tempStack = new Stack<>();
		
		while (!stack.isEmpty()) {
			//pop the top element from the original stack
			int current = stack.pop();
			
			//while the temporary stack is not empty and the top of the temp stack is greater than the current element
			while(!tempStack.isEmpty() && tempStack.peek()> current) {
				//pop from temp stack and push it back to the original stack 
				stack.push(tempStack.pop());
			}
			
			//push the current element onto the temporary stack 
			tempStack.push(current);
		}
		
		//transfer the elements back to the original stack 
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
		
		
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(34);
		stack.push(3);
		stack.push(31);
		stack.push(98);
		stack.push(92);
		stack.push(23);
		
		System.out.println("original stack:" + stack);
		sortStack(stack);
		System.out.println("sorted stack:" + stack);
		
	}

}
