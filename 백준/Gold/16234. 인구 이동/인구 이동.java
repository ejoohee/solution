import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] population;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        population = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        boolean hasMoved;

        do {
            hasMoved = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        // 연합국 찾기
                        List<int[]> union = new ArrayList<>();
                        int totalPopulation = findUnion(i, j, union);

                        // 연합국이 2개 이상이면 인구 이동 실행
                        if (union.size() >= 2) {
                            int newPopulation = totalPopulation / union.size();
                            for (int[] pos : union) {
                                population[pos[0]][pos[1]] = newPopulation;
                            }
                            hasMoved = true;
                        }
                    }
                }
            }

            // 인구 이동이 있었으면 날짜 증가
            if (hasMoved) {
                days++;
            }
        } while (hasMoved);

        System.out.println(days);
    }

    // BFS로 연합국 찾기
    static int findUnion(int x, int y, List<int[]> union) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        union.add(new int[]{x, y});

        int totalPopulation = population[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                // 범위 확인 및 방문 여부 확인
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }

                // 인구 차이 확인
                int diff = Math.abs(population[current[0]][current[1]] - population[nx][ny]);

                // 인구 차이가 L 이상 R 이하인 경우만 국경선 열기
                if (L <= diff && diff <= R) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    totalPopulation += population[nx][ny];
                }
            }
        }

        return totalPopulation;
    }
}