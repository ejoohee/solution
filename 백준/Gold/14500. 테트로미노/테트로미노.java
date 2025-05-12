import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, max;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        //맵입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2개 기준 백트
        for (int i =0; i < n; i++){
            for (int j = 0; j < m - 1; j++){
                bfs2(i,j,j+1);
            }
        }

        //3개 기준 백트
        for (int i =0; i < n; i++){
            for (int j = 0; j < m - 2; j++){
                bfs3col(i,j,j+1, j+2);
            }
        }

        //3개 기준 백트
        for (int i =0; i < n-2; i++){
            for (int j = 0; j < m; j++){
                bfs3row(j,i,i+1, i+2);
            }
        }

        System.out.println(max);
    }

    //2개 기준, bfs
    static void bfs2(int row, int col1, int col2){
        int sum = map[row][col1]+map[row][col2];

        //확인 경우 밑에 2개 있는 경우 오위왼우 등등
        if(row+1 < n) {
            max = Math.max(max, sum+map[row+1][col1]+map[row+1][col2]);
        }

        if (row+1 < n && col1-1 >= 0){
            max = Math.max(max, sum+map[row+1][col1-1]+map[row+1][col1]);
        }

        if (row+1 < n && col2+1 < m){
            max = Math.max(max, sum+map[row+1][col2]+map[row+1][col2+1]);
        }

        if (row-1 >= 0 && row+1 < n){
            max = Math.max(max, sum+map[row-1][col1]+map[row+1][col2]);
            max = Math.max(max, sum+map[row-1][col2]+map[row+1][col1]);
        }
    }

    //가로
    static void bfs3col(int row, int col1, int col2, int col3){
        int sum = map[row][col1]+map[row][col2]+map[row][col3];

        //옆에 붙이기
        if(col3+1 < m){
            max = Math.max(max, sum+map[row][col3+1]);
        }
        //위 가능 3개
        if(row-1 >= 0) {
            int unit = Math.max(Math.max(map[row-1][col1], map[row-1][col2]), map[row-1][col3]);
            max = Math.max(max, sum+unit);
        }

        //아래 가능 3개
        if (row+1 < n){
            int unit = Math.max(Math.max(map[row+1][col1], map[row+1][col2]), map[row+1][col3]);
            max = Math.max(max, sum+unit);
        }
    }

    //세로
    static void bfs3row(int col, int row1, int row2, int row3){
        int sum = map[row1][col]+map[row2][col]+map[row3][col];

        //아래에 붙이기
        if(row3+1<n){
            max = Math.max(max, sum+map[row3+1][col]);
        }
        //왼 가능 3개
        if(col-1 >= 0) {
            int unit = Math.max(Math.max(map[row1][col-1], map[row2][col-1]), map[row3][col-1]);
            max = Math.max(max, sum+unit);
        }

        //우 가능 3개
        if (col+1 < m){
            int unit = Math.max(Math.max(map[row1][col+1], map[row2][col+1]), map[row3][col+1]);
            max = Math.max(max, sum+unit);
        }
    }
}
