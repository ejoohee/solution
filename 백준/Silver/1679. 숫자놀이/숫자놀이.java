import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, k;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        k = sc.nextInt();
        visited = new boolean[1001];
        Queue<int[]> q = new ArrayDeque<>();

        for (int num : nums) {
            q.add(new int[]{num, 1});
            visited[num] = true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            //cur[0]은 숫자, cur[1]은 몊번 째인지
            int x = cur[0];
            int cnt = cur[1];

            if (cnt == k) {
                continue;
            }

            for (int num : nums) {
                int next = x + num;
                if (next <= 1000 && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
            }
        }

        for (int i = 1; i <= 1000; i++) {
            if (!visited[i]) {
                System.out.print((i % 2 != 0) ? "jjaksoon" : "holsoon");
                System.out.println(" win at " + i);
                break;
            }
        }
    }
}