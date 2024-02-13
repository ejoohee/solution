import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, k, time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 수빈이 위치
        k = sc.nextInt(); // 동생 위치
        time = 100000;

        if (n >= k) {
            System.out.println(n - k);
        } else {
            bfs(n);
            System.out.println(time);
        }
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == k) {
                time = Math.min(time, cur[1]);
            }

            // 순간이동
            if (cur[0] * 2 <= 100000 && !visited[cur[0] * 2]) {
                q.offer(new int[]{cur[0] * 2, cur[1]});
                visited[cur[0] * 2] = true;
            }

            // 한 칸 뒤로 이동
            if (cur[0] - 1 >= 0 && !visited[cur[0] - 1]) {
                q.offer(new int[]{cur[0] - 1, cur[1] + 1});
                visited[cur[0] - 1] = true;
            }

            // 한 칸 앞으로 이동
            if (cur[0] + 1 <= 100000 && !visited[cur[0] + 1]) {
                q.offer(new int[]{cur[0] + 1, cur[1] + 1});
                visited[cur[0] + 1] = true;
            }
        }
    }
}