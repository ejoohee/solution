import java.util.Scanner;

public class Main {
    static int[][] forest;
    static int[][] dp;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        forest = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                forest[i][j] = scanner.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        System.out.println(result);
    }

    public static int dfs(int x, int y) {
        if (dp[x][y] == 0) {
            dp[x][y] = 1;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (forest[x][y] < forest[nx][ny]) {
                        dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
                    }
                }
            }
        }

        return dp[x][y];
    }
}