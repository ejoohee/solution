import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 지름길의 개수
        int D = sc.nextInt(); // 고속도로의 길이

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // 시작 위치 기준으로 정렬

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = sc.nextInt();
            if (end <= D) { // 고속도로의 길이를 초과하는 지름길은 무시
                pq.add(new int[]{start, end, distance});
            }
        }

        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        while (!pq.isEmpty()) {
            int[] shortcut = pq.poll();

            int shortcutDist = dp[shortcut[0]] + shortcut[2];
            if (shortcutDist < dp[shortcut[1]]) {
                dp[shortcut[1]] = shortcutDist; // 지름길의 종료 지점 최소 거리 갱신
                for (int i = shortcut[1] + 1; i <= D; i++) {
                    if (dp[i] > dp[i - 1] + 1) {
                        dp[i] = dp[i - 1] + 1; // 이전 거리 + 1과 비교하여 최소값을 dp에 저장
                    }
                }
            }
        }

        System.out.println(dp[D]);
    }
}