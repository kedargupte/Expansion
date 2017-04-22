package kedar.linkedList;

import java.util.Stack;

public class LinkedListNumberAddition {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.add(Node.<Integer>createNode(3, 5));
		list1.add(Node.<Integer>createNode(2, 4));
		list1.add(Node.<Integer>createNode(1, 2));
		list1.displayData();

		LinkedList list2 = new LinkedList();
		list2.add(Node.<Integer>createNode(3, 7));
		list2.add(Node.<Integer>createNode(2, 6));
		list2.add(Node.<Integer>createNode(1, 8));
		list2.displayData();
		
		LinkedListNumberAddition linkedListNumberAddition = new LinkedListNumberAddition();
		linkedListNumberAddition.addTwoNumbersInLinkedList(list1, list2).displayData();
	}
	
	LinkedList addTwoNumbersInLinkedList(LinkedList list1, LinkedList list2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		Node temp1 = list1.getRootNode();
		while(temp1 != null) {
			stack1.add((Integer)temp1.getData());
			temp1 = temp1.getNextNode();
		}
		Node temp2 = list2.getRootNode();
		while(temp2 != null) {
			stack2.add((Integer)temp2.getData());
			temp2 = temp2.getNextNode();
		}
		
		LinkedList result = new LinkedList();
		Integer count = 1, carry = 0;
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			Integer sum = stack1.pop() + stack2.pop() + carry;
			carry = sum / 10;
			sum = sum % 10;
			result.add(Node.createNode(count, sum));
			count++;
		}
		while(!stack1.isEmpty()) {
			Integer sum = stack1.pop() + carry;
			carry = sum / 10;
			sum = sum % 10;
			result.add(Node.createNode(count, sum));
			count++;
		}
		while(!stack2.isEmpty()) {
			Integer sum = stack2.pop() + carry;
			carry = sum / 10;
			sum = sum % 10;
			result.add(Node.createNode(count, sum));
			count++;
		}
		if(carry != 0) {
			result.add(Node.createNode(count, carry));
		}
		result.reverse();
		return result;
	}

}
