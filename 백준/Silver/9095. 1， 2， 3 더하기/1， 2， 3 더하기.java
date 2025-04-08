import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] dp = new int[Math.max(4, n + 1)];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
