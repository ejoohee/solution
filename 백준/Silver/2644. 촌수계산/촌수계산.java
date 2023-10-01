import java.util.*;

public class Main {
    static int n, m;
    static boolean[] visited;
    static List<List<Integer>> grap;
    static int[] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int a = sc.nextInt();
        int b = sc.nextInt();

        m = sc.nextInt();

        grap = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            grap.add(new ArrayList<>());
        }

        for(int  i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            grap.get(x).add(y);
            grap.get(y).add(x);
        }

        visited = new boolean[n+1];
        distance = new int[n+1];
        for (int i = 0; i <= n; i++) {
            distance[i] = -1; 
        }
        bfs(a);
        System.out.println(distance[b]);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        distance[start]=0;

        while (!q.isEmpty()){
            int cur = q.poll();
            for(int n : grap.get(cur)){
                if(!visited[n]){
                    q.add(n);
                    visited[n] = true;
                    distance[n]= distance[cur]+1;
                }
            }
        }
    }
}