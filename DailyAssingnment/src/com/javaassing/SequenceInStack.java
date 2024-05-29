package com.javaassing;

import java.util.Stack;

public class SequenceInStack {
	public static boolean isSequencePresent(Stack<Integer>stack, int[] sequence) {
		if (sequence.length == 0) {
			return true; //an empty sequence is trivially present
		}
		
		int seqIndex = 0; //index for the sequence array
		
		Stack<Integer>tempStack = new Stack<>(); //temporary stack to preserve the original stack
		
		//pop element from the original stack and push them into the temporary stack
		while(!stack.isEmpty()) {
			int element = stack.pop();
			tempStack.push(element);
			
			//check if the current element matches the current sequence element 
			if(element == sequence[seqIndex]) {
				seqIndex++;
				//if the entire sequence has been matched
				if (seqIndex == sequence.length) {
					break;
				}
			}else {
				//reset sequence index if a mismatch is found 
				seqIndex = 0;
			}
		}
		
		//restore the original stack 
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
		
		//check if the sequence was fully matched
		return seqIndex == sequence.length;
		
	}
	
	public static void main(String[] args) {
		Stack<Integer>stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		int[] sequence = {3, 4, 5};
		
		boolean result = isSequencePresent(stack, sequence);
		System.out.println("is the sequence present?" + result);
	}

}
