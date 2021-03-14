package datastructure.graph;

public class GraphAdjMatrixDemo {
	final static int V = 9;

	public static void main(String[] args) {
		int[][] adjMatrix = new int[V][V];
		addEdge(adjMatrix, 8, 1);
		addEdge(adjMatrix, 5, 8);
		addEdge(adjMatrix, 7, 3);
		addEdge(adjMatrix, 8, 6);
		printMatrix(adjMatrix);

		System.out.println(hasEdge(adjMatrix, 3, 4));
	}

	static void addEdge(int[][] arr, int source, int destination) {
		arr[source][destination] = 1;
	}

	static boolean hasEdge(int[][] arr, int source, int destination) {
		if (arr[source][destination] == 1)
			return true;
		return false;
	}

	static void removeEdge(int[][] arr, int source, int destination) {
		if (source < arr.length && destination < arr[0].length)
			arr[source][destination] = 0;
	}

	static void printMatrix(int[][] arr) {
		System.out.print(" | ");
		for (int col = 1; col < V; col++) {
			System.out.print(col + " ");
		}
		System.out.println("\n-------------");
		for (int i = 1; i < V; i++) {
			System.out.print(i + "| ");
			for (int j = 1; j < V; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
