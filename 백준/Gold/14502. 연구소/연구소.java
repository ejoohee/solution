import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, max;
    static int[][] map;
    static int[][] pick = new int[3][2];
    static List<int[]> blank = new ArrayList<>();
    static List<int[]> virus = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0은 빈 칸, 1은 벽, 2는 바이러스 있는 곳
        // 바이러스는 상하좌우 퍼져 나갈 수 있음
        // 새로 벽 3개를 세워야함 -> 0 인 위치에
        // 조합으로 0인 위치중에 3개 골라가면서 백트
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) blank.add(new int[]{i, j});
                if (map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        dfs(0, 0); // 조합 시작
        System.out.println(max); // 최대 안전지대 출력
    }

    static void dfs(int start, int dep){
        if (dep == 3){
            //3개 다뽑음
            int[][] copied = new int[n][m];
            for (int i = 0; i < n; i++) {
                System.arraycopy(map[i], 0, copied[i], 0, m);
            }


            for (int i = 0; i < 3; i++) {
                int r = pick[i][0];
                int c = pick[i][1];
                copied[r][c] = 1; // 벽 세우기
            }

            bfs(copied); // 바이러스 퍼뜨리기
            return;
        }

        for (int i=start; i<blank.size(); i++){
            pick[dep] = blank.get(i);
            dfs(i+1, dep+1);
        }
    }

    //벽을 세운 뒤
    //2부터 시작해서 상하좌우로 0이면 다 퍼지기 1이면 못움직여
    //끝난 뒤 0인 갯수 카운팅
    static void bfs(int[][] update) {
        Queue<int[]> q = new LinkedList<>();
        for (int[] v : virus) {
            q.add(new int[]{v[0], v[1]});
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = current[0] + dr[d];
                int nc = current[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m || update[nr][nc] != 0) continue;

                update[nr][nc] = 2;
                q.add(new int[]{nr, nc});
            }
        }

        countSafe(update);
    }

    static void countSafe(int[][] map) {
        int safe = 0;
        for (int[] row : map) {
            for (int cell : row) {
                if (cell == 0) safe++;
            }
        }
        max = Math.max(max, safe);
    }
}
