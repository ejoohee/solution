import java.util.Scanner;

public class Main {

    static int maxArea, n, maxNum;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map= new int[n][n];
        isVisited = new boolean[n][n];

        maxArea=0;
        maxNum = Integer.MIN_VALUE;

        for(int r =0; r<n; r++){
            for(int c =0; c<n; c++){
                map[r][c] = sc.nextInt();
                maxNum = Math.max(maxNum, map[r][c]);
            }
        }
        findSafeZone();

        System.out.println(maxArea);
    }

    static void findSafeZone(){
        for(int h=0; h<=maxNum; h++){
            int cnt =0;
            clearVisited();
            for(int r =0; r<n; r++){
                for(int c=0; c<n; c++){
                    if(map[r][c]>h && !isVisited[r][c]){
                        //가능
                        dfs(r,c,h);
                        cnt++;
                    }
                }
            }
            maxArea = Math.max(cnt, maxArea);
        }
    }

    private static void dfs(int r, int c, int h) {
        isVisited[r][c]=true;
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr<0 || nc<0 || nr>=n|| nc>=n) continue;
            if(map[nr][nc]>h&&!isVisited[nr][nc]){
                dfs(nr,nc,h);
            }
        }
    }

    private static void clearVisited() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                isVisited[r][c] = false;
            }
        }
    }
}