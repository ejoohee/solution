import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int count, weaknessCount;
    static char[][] map;
    static boolean[][] visited, colorVisited;
    static char[][] colorWeakness;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());
        map = new char[n][n];
        visited = new boolean[n][n];
        colorWeakness = new char[n][n];
        colorVisited = new boolean[n][n];
        for (int r=0; r<n; r++){
            String str = br.readLine();
            for (int c =0; c<n; c++){
                char alphabet = str.charAt(c);

                map[r][c] = alphabet;
                if (alphabet == 'G'){
                    colorWeakness[r][c] = 'R';
                }else colorWeakness[r][c] = alphabet;
            }
        }


        for (int r=0; r<n; r++){
            for (int c=0; c<n; c++){
                if (!visited[r][c]) {
                    bfs(map, visited, r, c);
                    count++;
                }

                if (!colorVisited[r][c]){
                    bfs(colorWeakness, colorVisited, r, c);
                    weaknessCount++;
                }
            }
        }

        System.out.println(count+" "+weaknessCount);
    }

    static void bfs(char[][] colorMap, boolean[][] isVisited, int startR, int startC){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC}); //시작 위치
        isVisited[startR][startC] = true;

        while (!q.isEmpty()){
            int[] location = q.poll();
            int r = location[0];
            int c = location[1];
            char color = colorMap[r][c];

            for (int i=0; i<4; i++){
                int newR = r + dr[i];
                int newC = c + dc[i];

                if (newR<0 || newC<0 || newR>=n || newC>=n || isVisited[newR][newC]) continue;
                //색깔 다르면 이동 불가
                if (colorMap[newR][newC] != color) continue;

                //여기 왔으면 이동 가능
                q.add(new int[]{newR, newC});
                isVisited[newR][newC] = true;
            }
        }
    }
}
