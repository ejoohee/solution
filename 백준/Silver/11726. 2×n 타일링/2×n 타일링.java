import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] dp;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1];

        Arrays.fill(dp, -1);

        if (n == 1) {
            System.out.println(1);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;

        dfs(n);

        System.out.println(dp[n]%10007);
    }

    static int dfs(int x){
        if (x<=2) return dp[x];

        //이미 계산된 값이면 바로 반환
        if(dp[x]!=-1) return dp[x];

        dp[x] = dfs(x-1)+dfs(x-2) % 10007;

        return dp[x];
    }
}