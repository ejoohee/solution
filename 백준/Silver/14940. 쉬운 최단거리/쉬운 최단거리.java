import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m, r, c; //r c는 위치
    static int[][] map;
    static int[][] result;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //0은 갈 수 없는 땅, 1은 갈 수 있는 땅
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    result[i][j] = 0;
                } else if (map[i][j] == 2) {
                    r = i;
                    c = j;
                }
            }
        }
        bfs();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==r && j==c){
                    sb.append(0).append(" ");
                }else if (map[i][j]!=0&&result[i][j] == 0) {
                    sb.append("-1").append(" ");
                } else {
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 0 || result[nr][nc] != 0) continue;

                result[nr][nc] = now[2] + 1;
                q.add(new int[]{nr, nc, now[2] + 1});
            }
        }
    }
}