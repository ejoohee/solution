import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //방향없는 그래프 주어짐. 연결 요소 개수
    static int n, m, cnt;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> node;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        node = new ArrayList<>();
        visited = new boolean[n+1];

        for (int i=0; i<=n; i++){
            node.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            node.get(u).add(v);
            node.get(v).add(u);
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int cur) {
        visited[cur] =true;

        for (int next : node.get(cur)){
            if(!visited[next]) dfs(next);
        }
    }
}