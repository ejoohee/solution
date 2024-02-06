import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] dp = new int[10001];
        
        // 숫자 1만 사용하는 경우
        for (int i = 0; i <= 10000; i++) {
            dp[i] = 1;
        }

        // 숫자 2를 추가해서 사용하는 경우
        for (int i = 2; i <= 10000; i++) {
            dp[i] += dp[i - 2];
        }

        // 숫자 3을 추가해서 사용하는 경우
        for (int i = 3; i <= 10000; i++) {
            dp[i] += dp[i - 3];
        }

        for (int t = 0; t < tc; t++) {
            int num = sc.nextInt();
            System.out.println(dp[num]);
        }
    }
}