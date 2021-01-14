package datastructure.linkedlist.doubly;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		// memory allocated in stack
		Node head; // 5024 points to 1000
		Node middle; // 5028 points to 2000
		Node last; // 5032 points to 3000

		// memory will be allocated in heap
		head = new Node(); // 1000
		middle = new Node(); // 2000
		last = new Node(); // 3000

		head.prev = null;
		head.data = 10;
		head.next = middle; // 2000
		middle.prev = head; // 1000
		middle.data = 20;
		middle.next = last; // 3000
		last.prev = middle; // 2000
		last.data = 30;
		last.next = null;

		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addFirst(10);
		dll.addFirst(20);
		dll.addLast(100);
		dll.addFirst(30);
		dll.addFirst(40);
		dll.addLast(60);
		dll.print();
		System.out.println();
		System.out.println(dll.search(20));
		System.out.println(dll.search(30));
		dll.delete(30);
		System.out.println("After deleted:");
		dll.print();
		dll.delete(120);
	}

}

class Node {
	Node prev;
	int data;
	Node next;

	@Override
	public String toString() {
		return "Node [prev=" + prev + ", data=" + data + ", next=" + next + "]";
	}

}

class DoublyLinkedList {
	Node head;

	// timeComplexity O(1) - best/worst case
	public void addFirst(int val) {
		Node newNode = createNew(val);
		if (null == head) {
			newNode.next = null;
			newNode.prev = null;
			head = newNode;
		} else {
			newNode.prev = null;
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	// time complexity O(1) : first node to be deleted - best case
	// time complexity O(n) : last node to be deleted - worst case
	public void addLast(int val) {
		Node newNode = createNew(val);
		if (null == head) {
			newNode.next = null;
			newNode.prev = null;
			head = newNode;
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
			newNode.prev = last;
			newNode.next = null;
		}
	}

	// time complexity O(1) : first node to be deleted - best case
	// time complexity O(n) : last node to be deleted - worst case
	public boolean search(int key) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == key) {
				return true;
			}
			temp = temp.next;
		}

		return false;
	}
	// time complexity O(1) : first node to be deleted - best case
	// time complexity O(n) : last node to be deleted - worst case
	public void delete(int key) {
		if (null == head)
			return;

		Node temp = head;
		while (temp != null && temp.data != key)
			temp = temp.next;

		if (null == temp)
			System.out.println("\n" + key + " not found to delete");
		else if (temp == head) {
			head.next.prev = null;
			head = head.next;
		} else if (temp.next == null) {
			temp.prev.next = null;
		} else {
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
		}
		
		
		/*
		 * if (head.data == key) { head.next.prev = null; head = head.next; } else {
		 * temp = head; while (temp.next != null) { if (temp.data == key) {
		 * temp.prev.next = temp.next; temp.next.prev = temp.prev;
		 * System.out.println(key + " deleted"); break; } else { temp = temp.next; } } }
		 */
	}

	public Node createNew(int val) {
		Node newNode = new Node();
		newNode.data = val;
		return newNode;
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(" " + temp.data);
			temp = temp.next;
		}
	}

}