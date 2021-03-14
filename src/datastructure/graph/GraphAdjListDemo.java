package datastructure.graph;

public class GraphAdjListDemo {
	static final int V = 5;
	static Node[] adjList = new Node[V];

	public static void main(String[] args) {
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(0, 3);
		addEdge(1, 3);
		addEdge(1, 4);
		addEdge(2, 3);
		addEdge(3, 4);
		printGraph();
		removeEdge(0, 2);
		printGraph();
	}

	static void addEdge(int source, int destination) {
		Node newNode = new Node();
		newNode.data = destination;
		// newNode.next = null;

		// adds new node in beginning and makes it head
		// time complexity is O(1)
		newNode.next = adjList[source];
		adjList[source] = newNode;

		// adds new node at the end and makes it head
		// time complexity is O(n)
		/*
		 * if (adjList[source] == null) { adjList[source] = newNode; } else { Node last
		 * = adjList[source]; while (last.next != null) { last = last.next; } last.next
		 * = newNode; }
		 */
	}

	static void removeEdge(int source, int destination) {
		if (null == adjList[source])
			return;
		if (adjList[source].data == destination)
			adjList[source] = adjList[source].next;
		else {
			Node current = adjList[source];
			while (current.next != null) {
				if (current.next.data == destination) {
					current.next = current.next.next;
					break;
				} else
					current = current.next;
			}
		}

	}

	static public void printGraph() {
		for (int i = 0; i < V; i++) {
			Node temp = adjList[i];
			System.out.print("adjList[" + i + "]->");
			while (temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.next;
			}
			System.out.println("null");
		}
	}
}

class Node {
	int data;
	Node next;
}
