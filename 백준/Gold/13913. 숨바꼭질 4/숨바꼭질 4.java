import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100001;
    static int[] visited = new int[MAX];  // 걸린 시간 저장 (0: 미방문)
    static int[] parent = new int[MAX];   // 이전 위치 저장 (경로 추적용)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 수빈이 위치
        int k = Integer.parseInt(st.nextToken());  // 동생 위치

        bfs(n, k);

        // 출력 1: 최소 시간
        System.out.println(visited[k] - 1);

        // 출력 2: 경로 역추적
        Stack<Integer> stack = new Stack<>();
        for (int i = k; i != n; i = parent[i]) {
            stack.push(i);
        }
        stack.push(n);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1; // 시간 0초 → 1부터 시작

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == end) return;

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next >= 0 && next < MAX && visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    parent[next] = now;
                    q.offer(next);
                }
            }
        }
    }
}
