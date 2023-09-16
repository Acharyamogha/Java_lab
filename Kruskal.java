import java.util.Scanner;

public class Kruskal {
    static int[][] c; 
    static int[] parent;
    static int n; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of nodes: ");
        n = scanner.nextInt();
        
        c = new int[n + 1][n + 1];
        parent = new int[n + 1];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                c[i][j] = scanner.nextInt();
                if(i==j)
                c[i][j]=99;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            parent[i] = 0;
        }

        krus();
        
        scanner.close();
    }



    static void krus() {
        int a = 0, b = 0, u = 0, v = 0;
        int i, j, ne = 1, min, mincost = 0;
        System.out.println("Edges are ");
        while (ne < n) {
            for (i = 1, min = 99; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (c[i][j] < min) {
                        min = c[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }
            }
            u = find(u);
            v = find(v);
            if (u != v) {
                union(u, v);
                ne++;
                System.out.println("edge(" + a + "," + b + ")=" + min);
                mincost += min;
            }
            c[a][b] = c[b][a] = 99;
        }
        System.out.println("minimum cost: " + mincost);
    }

    static int find(int i) {
        while (parent[i] > 0) {
            i = parent[i];
        }
        return i;
    }

    static void union(int i, int j) {
        parent[j] = i;
    }
}
