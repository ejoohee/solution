import java.util.*;

public class Main {
    static int[][] map;
    static int n, m, max;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        //상어 위치 저장

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    int dist = distance(i, j);
                    max = Math.max(max, dist);
                }
            }
        }

        System.out.println(max);
    }

    static int distance(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.offer(new int[]{r, c, 0});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int cr = cur[0];
            int cc = cur[1];
            int cd = cur[2];

            for (int d = 0; d < 8; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc]) {
                    if (map[nr][nc] == 1) {
                        return cd + 1;
                    }
                    q.offer(new int[]{nr, nc, cd + 1});
                    visited[nr][nc] = true;
                }
            }
        }

        return 0;
    }
}