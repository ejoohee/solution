import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int v, max, maxNode;
    static boolean[] visited;
    static ArrayList<ArrayList<int[]>> tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tree = new ArrayList<>();
        v = sc.nextInt();
        visited = new boolean[v + 1];
        max = Integer.MIN_VALUE;

        for (int i = 0; i <= v; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            int node1 = sc.nextInt();
            int node2 = 0;
            while (true) {
                node2 = sc.nextInt();
                if (node2 == -1) break;
                int distance = sc.nextInt();
                tree.get(node1).add(new int[]{node2, distance});
            }
        }

        dfs(1,0);

        visited = new boolean[v+1];
        dfs(maxNode,0);

        System.out.println(max);
    }

    static void dfs(int node, int distance) {
        visited[node] = true;

        if (distance > max) {
            max = distance;
            maxNode = node;
        }

        for (int[] i : tree.get(node)) {

            if (!visited[i[0]]) {
                dfs(i[0], distance+i[1]);
            }
        }
    }
}