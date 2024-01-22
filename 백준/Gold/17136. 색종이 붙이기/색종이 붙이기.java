import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static final int N = 10;
    static int[][] board = new int[N][N];
    static int[] paperCount = {0, 5, 5, 5, 5, 5};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        solve(0, 0, 0);

        if (answer == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(answer);
    }

    static void solve(int x, int y, int count) {
        if (x == N) {
            answer = Math.min(answer, count);
            return;
        }

        if (y == N) {
            solve(x + 1, 0, count);
            return;
        }

        if (board[x][y] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (paperCount[size] > 0 && canAttach(x, y, size)) {
                    attachPaper(x, y, size, 0);
                    paperCount[size]--;
                    solve(x, y + 1, count + 1);
                    detachPaper(x, y, size, 0);
                    paperCount[size]++;
                }
            }
        } else {
            solve(x, y + 1, count);
        }
    }

    static boolean canAttach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i >= N || j >= N || board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    static void attachPaper(int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = value;
            }
        }
    }

    static void detachPaper(int x, int y, int size, int value) {
        attachPaper(x, y, size, 1);
    }
}