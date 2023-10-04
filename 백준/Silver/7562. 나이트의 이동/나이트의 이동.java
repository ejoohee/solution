import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] pos = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static int nowX, nowY;
    static int desX, desY;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int t = 0; t < test; t++) {
            n = sc.nextInt();
            graph = new int[n][n];
            visited = new boolean[n][n];

            nowX = sc.nextInt();
            nowY = sc.nextInt();
            desX = sc.nextInt();
            desY = sc.nextInt();

            visited[nowX][nowY] = true;
            bfs(nowX, nowY);
            System.out.println(graph[desX][desY]);

        }
    }
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<pos.length; i++) {
                int nX = nowX + pos[i][0];
                int nY = nowY + pos[i][1];

                if(nX < 0 || nX >= n || nY < 0 || nY >= n || visited[nX][nY] || graph[nX][nY] != 0) {
                    continue;
                }

                visited[nX][nY] = true;
                graph[nX][nY] = graph[nowX][nowY] + 1;
                queue.add(new int[] {nX, nY});
            }
        }
    }
}