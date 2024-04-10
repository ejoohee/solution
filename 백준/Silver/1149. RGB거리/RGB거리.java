import java.util.Scanner;

public class Main {
    static int n;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1][3];

        // i가 빨강이면 i-1번째 집이 초록이거나 파랑인 경우 최소 + 빨강 값
        for (int i=1; i<=n; i++){
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();

            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+r;
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+g;
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+b;
        }
        int min = Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]);
        System.out.println(min);
    }
}