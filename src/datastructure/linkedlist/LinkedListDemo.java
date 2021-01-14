package datastructure.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
		// memory is allocated in stack
		Node head; // 5024 points to 1024
		Node middle; // 5028 points to 2024
		Node last; // 5032 points to 3024

		// memory is allocated in heap
		head = new Node(); // 1024
		middle = new Node(); // 2024
		last = new Node(); // 3024

		head.data = 10;
		head.next = middle; // 1024 refers to 2024
		middle.data = 20;
		middle.next = last; // 2024 refers to 3024
		last.data = 30;
		last.next = null;
		
		
		
		LinkedList l = new LinkedList();
		l.addFirst(10);
		l.addFirst(20);
		l.addFirst(30);
		l.addlast(60);
		l.print();
		
		System.out.println(l.search(20));
		System.out.println(l.search(40));
		System.out.println(l.search(60));
	}

}

class LinkedList {
	Node head;

	// time complexity O(1)
	public void addFirst(int val) {
		Node newNode = createNew(val);
		newNode.next = head;
		head = newNode;
	}
	// time complexity O(1) : first node to be deleted - best case
	// time complexity O(n) : last node to be deleted - worst case
	public boolean search(int key) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == key)
				return true;

			temp = temp.next;
		}

		return false;
	}
	//time complexity O(n)
	public void addlast(int val) {
		Node newNode = createNew(val);
		if (null == head)
			head = newNode;
		else {
			Node lastNode = head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
		}

	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private Node createNew(int val) {
		Node newNode = new Node();
		newNode.data = val;
		newNode.next = null;
		return newNode;
	}

	// time complexity O(1) : first node to be deleted - best case
	// time complexity O(n) : last node to be deleted - worst case
	public void delete(int key) {
		if (head.data == key) {
			head = head.next;
		} else {
			Node temp = head;
			while (temp.next != null) {
				if (temp.next.data == key) {
					temp.next = temp.next.next;
					break;
				} else {
					temp = temp.next;
				}
			}
		}

	}
}

class Node {
	int data;
	Node next;
}