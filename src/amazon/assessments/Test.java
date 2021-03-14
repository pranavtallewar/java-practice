package amazon.assessments;

import java.util.ArrayList;
import java.util.List;

public class Test {

	static Node[] adjList;

	public static void main(String[] args) {

		List<String> edges = new ArrayList<>();
		edges.add("8 1");
		edges.add("5 8");
		edges.add("7 3");
		edges.add("8 6");
		connectedSum(8, edges);
		System.out.println(hasEdge(5, 6));

	}

	static void addEdge(int source, int destination) {
		Node newNode = new Node();
		newNode.data = destination;

		if(adjList[source] == null) {
			adjList[source] = newNode;
		} else {
			Node last = adjList[source];
			while(last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
	}

	static boolean hasEdge(int src, int dest) {
		Node tmp = adjList[src];
		while (tmp != null) {
			if (tmp.data == dest)
				return true;

			tmp = tmp.next;
		}

		return false;
	}

	public static int connectedSum(int n, List<String> edges) {
		n++;
		adjList = new Node[n];

		edges.forEach(e -> {
			String[] arr = e.split(" ");
			int source = Integer.parseInt(arr[0]);
			int destination = Integer.parseInt(arr[1]);
			addEdge(source, destination);
		});
		

		return 0;
	}

}

class Node {
	int data;
	Node next;
}
