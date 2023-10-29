import java.util.Scanner;

public class Main {

    static int[] parent;

    public static int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int connect = sc.nextInt();
                if (connect == 1) {
                    union(i, j);
                }
            }
        }

        int start = findParent(sc.nextInt());
        boolean possible = true;
        for (int i = 1; i < M; i++) {
            if (start != findParent(sc.nextInt())) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");

        sc.close();
    }
}