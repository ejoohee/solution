import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //동전이 나타내는 가치는 다른데 합이 k원이 되도록 하는 경우의 수
    //동전 갯 수에는 제한이 없음 -> 그럼 계속 세 개 중에서 고르면 되잖아..?
    //순열이 아닌 조합으로 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] coins = new Integer[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine().trim());
        }

        int[] dp = new int[k + 1]; //i원을 만드는 방법의 수
        dp[0] = 1; //0원을 만드는 방법은 아무 것도 안쓰는 경우

        for (int i = 0; i < n; i++) { //모든 동전에 대해
            for (int j = coins[i]; j <= k; j++) { // 해당 동전으로 만들 수 있는 금액들
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
