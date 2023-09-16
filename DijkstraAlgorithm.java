import java.util.*;
public class DijkstraAlgorithm {
    private static final int INF = 999999;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();
        System.out.print("Enter the source node: ");
        int src = scanner.nextInt();
        int[][] c = new int[n + 1][n + 1];
        System.out.println("Enter the weighted graph (" + n + " x " + n + "):");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                c[i][j] = scanner.nextInt();
                if (i != j && c[i][j] == 0) {
                    // Assuming a value of 0 represents no direct edge.
                    c[i][j] = INF;
                }
            }
        }

        int[] dist = new int[n + 1];
        boolean[] v = new boolean[n + 1];
        sp(src, n, c, dist, v);        // Print the shortest distances from the source to all nodes.
        System.out.println("Shortest distances from node " + src + " to all other nodes:");
        for (int i = 1; i <= n; i++) {
		if(i==src)
		continue;{
            System.out.println("Node " + i + ": " + dist[i]);
        }}
    }
    private static void sp(int src, int n, int[][] c, int[] dist, boolean[] v) {
        for (int i = 1; i <= n; i++) {
            v[i] = false;
            dist[i] = INF;
        }
        dist[src] = 0;
        int num = 2;
        while (num <= n) {
            int u = choose(n, dist, v);
            v[u] = true;
            num++;
            for (int w = 1; w <= n; w++) {
                if (dist[u] + c[u][w] < dist[w] && !v[w]) {
                    dist[w] = dist[u] + c[u][w];
                }
            }
        }
    }
    private static int choose(int n, int[] dist, boolean[] v) {
        int min = INF;
        int j = 1;
        for (int w = 1; w <= n; w++) {
            if (dist[w] < min && !v[w]) {
                min = dist[w];
                j = w;
            }
        }
        return j;
    }
}

