import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int r, c, years;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        years = 0;
        while (true) {
            int cnt = cntIce();
            if(cnt == 0){
                System.out.println(0);
                break;
            } else if (cnt>=2) {
                System.out.println(years);
                break;
            }
            update();
            years++;
        }
    }

    static void update() {
        int[][] tempMap = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(nr<0||nc<0||nr>=r||nc>=c) continue;

                    if (map[nr][nc] == 0) cnt++;
                }

                tempMap[i][j] = Math.max(0, map[i][j]-cnt);

            }
        }
        map = tempMap;
    }

    static int cntIce() {
        int cnt = 0;
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j]>0 && !visited[i][j]){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x,y});
        visited[x][y]=true;

        while (!q.isEmpty()){
            int[] cur = q.poll();

            //만약에 갈 수 없으면
            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];
                //못가는 경우
                if(nr<0||nc<0||nr>=r||nc>=c||map[nr][nc]==0) continue;
                //방문했으면 못감
                if(!visited[nr][nc]) {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}