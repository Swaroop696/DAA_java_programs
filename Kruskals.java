import java.util.Scanner;
public class Kruskals {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter the number of vertices");
		n = sc.nextInt();
		int cA[][] = new int[n][n];
		System.out.println("Enter the cost adjacency matrix.Enter 9999 for infinity");
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				cA[i][j] = sc.nextInt();
		int edges[] = new int[100];
		int source[] = new int[100];
		int destination[] = new int[100];
		int k = 0;
		for (int i = 0; i < n; i++)// Creating an edges array which contain the
									// edges and corresponding source and
									// destination arrays for each edge from the
									// cost adjacency matrix
			for (int j = 0; j < n; j++) {
				if ((cA[i][j] != 0) && (cA[i][j] != 9999)) {
					edges[k] = cA[i][j];
					source[k] = i;
					destination[k] = j;
					cA[j][i] = 0;
					k++;
				}
			}
		for (int i = 0; i < k - 1; i++)// Sorting the edges array in increasing
										// order and swapping the corresponding
										// source and destination(Bubble Sort)
			for (int j = 0; j < k - i - 1; j++) {
				if (edges[j] > edges[j + 1]) {
					swap(edges, j);
					swap(source, j);
					swap(destination, j);
				}
			}
		int parent[] = new int[n];
		int minimumCost = 0;
		System.out.println("The edges in the MCST are:");
		for (int i = 0; i < n; i++)
			parent[i] = -1;
		for (int j = 0; j < k; j++) {
			int a = find(parent, source[j]);// Applying union find algorithm to
											// detect cycle in the graph
			int b = find(parent, destination[j]);
			if (a != b) {
				minimumCost += edges[j];
				union(parent, a, b);
				System.out.println((source[j]+1) + " -> " + (destination[j]+1) + " = " + edges[j]);
			}
		}
		System.out.println("Minimum Cost of the Spanning Tree = " + minimumCost);
		sc.close();
	}

	public static void swap(int array[], int index) {
		int temp = array[index];
		array[index] = array[index + 1];
		array[index + 1] = temp;
	}

	public static int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	public static void union(int parent[], int a, int b) {
		parent[a] = b;
	}
}
