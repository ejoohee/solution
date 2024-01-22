import java.util.Scanner;

public class Main {
    //로봇청소기가 있는 좌표, 방향
    //d가 0이면 북 1이면 동 2는 남 3은 서쪽
    //0이면 청소되지않는 빈 칸, 1인 경우 벽
    static int n, m, d, r, c, clear;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        //로봇청소기 위치
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(r, c, d);

        System.out.println(clear);

    }

    private static void dfs(int r, int c, int d) {
        //청소해
        if (map[r][c] == 0) {
            //청소
            map[r][c] = 2;
            clear++;
        }

        int nr, nc;

        for (int i = 0; i < 4; i++) {
            //4방향 확인 업데이트
            d = (d + 3) % 4;

            nr = r + dr[d];
            nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            //벽이면 못감
            if (map[nr][nc] == 0) {
                dfs(nr, nc, d);
                return;
            }
        }

        //주변 칸 4 칸 중 청소할 수 있는 칸이 없으면 후진
        nr = r + dr[(d + 2) % 4];
        nc = c + dc[(d + 2) % 4];


        if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 1) return;
        //후진 가능하면
        dfs(nr, nc, d);
    }
}