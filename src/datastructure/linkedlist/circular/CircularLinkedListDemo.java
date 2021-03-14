package datastructure.linkedlist.circular;

public class CircularLinkedListDemo {

	public static void main(String[] args) {
		// memory allocated in stack
		Node head; // 5024 point to 1000
		Node middle; // 5026 point to 2000
		Node last; // 5028 point to 3000

		// memory allocated in heap
		head = new Node(); // 1000
		middle = new Node(); // 2000
		last = new Node(); // 3000

		head.data = 10;
		middle.data = 20;
		last.data = 30;

		head.next = middle; // 2000
		middle.next = last; // 3000
		last.next = head; // 1000
		CircularLinkedList cll = new CircularLinkedList();
		cll.addFirst(20);
		cll.addFirst(10);
		cll.addLast(30);
		cll.addFirst(40);
		cll.addLast(50);
		cll.print();
		System.out.println("\n" + cll.search(30));
		System.out.println(cll.search(60));
		cll.addLast(60);
		cll.print();
		System.out.println("\n"+cll.search(60));
		cll.delete(50);
		System.out.println("After deleted:");
		cll.print();
		/*
		 * Node temp = head; do { System.out.println(temp.data); temp = temp.next; }
		 * while (temp != head);
		 */

	}

}

class Node {
	int data;
	Node next;
}

class CircularLinkedList {
	Node head;

	public void print() {
		if (null == head)
			return;

		Node temp = head;
		do {
			System.out.print(" " + temp.data);
			temp = temp.next;
		} while (temp != head);

	}

	// time complexity - O(n)
	public void addFirst(int data) {
		Node newNode = createNew(data);
		if (null == head) {
			newNode.next = newNode;
			head = newNode;
		} else {
			Node last = head;
			while (last.next != head) {
				last = last.next;
			}
			last.next = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	// time complexity - O(n)
	public void addLast(int data) {
		Node newNode = createNew(data);
		if (null == head) {
			newNode.next = newNode;
			head = newNode;
		} else {
			Node last = head;
			while (last.next != head) {
				last = last.next;
			}
			last.next = newNode;
			newNode.next = head;
		}

	}

	// time complexity O(1) : first node to be deleted - best case
	// time complexity O(n) : last node to be deleted - worst case
	public boolean search(int key) {
		if (null == head)
			return false;

		Node temp = head;
		do {
			if (temp.data == key) {
				return true;
			}
			temp = temp.next;

		} while (temp != head);

		return false;
	}

	// time complexity O(1) : first node to be deleted - best case
	// time complexity O(n) : last node to be deleted - worst case
	public void delete(int key) {
		if(null == head)
			return;
		
		if (head.data == key && head.next == head) {
			head = null;
		} else if (head.data == key) {
			Node last = head;
			while (last.next != head) {
				last = last.next;
			}
			last.next = head.next;
			head = head.next;

		} else {
			Node current = head;
			while(current.next != head) {
				if(current.next.data == key) {
					current.next = current.next.next;
					break;
				}
				current = current.next;
			}
			
		}
		
	}

	private Node createNew(int data) {
		Node newNode = new Node();
		newNode.data = data;
		return newNode;
	}

}
