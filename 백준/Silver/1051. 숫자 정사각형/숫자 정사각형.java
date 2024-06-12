import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int maxSize = 1;
        for (int i = Math.min(n, m); i > 0; i--) {
            for (int r = 0; r <= n - i; r++) {
                for (int c = 0; c <= m - i; c++) {
                    if (map[r][c] == map[r + i - 1][c] &&
                            map[r][c] == map[r][c + i - 1] &&
                            map[r][c] == map[r + i - 1][c + i - 1]) {
                        maxSize = i;
                        break;
                    }
                }
                if (maxSize == i) break;
            }
            if (maxSize == i) break;
        }
        System.out.println(maxSize*maxSize);
    }
}