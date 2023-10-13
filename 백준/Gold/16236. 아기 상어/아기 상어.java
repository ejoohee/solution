import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 0, 1};
    static final int[] dy = {0, -1, 1, 0};
    static int N;
    static int[][] map;
    static Shark shark;

    static class Shark {
        int x, y, size = 2, eat = 0;

        Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Fish {
        int x, y, dist;

        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }

        int result = 0;
        while (true) {
            Fish fish = findFish();
            if (fish == null) break;

            shark.eat++;
            if (shark.eat == shark.size) {
                shark.size++;
                shark.eat = 0;
            }

            map[fish.x][fish.y] = 0;
            shark.x = fish.x;
            shark.y = fish.y;
            result += fish.dist;
        }

        System.out.println(result);
        scanner.close();
    }

    public static Fish findFish() {
        Queue<Fish> queue = new LinkedList<>();
        queue.add(new Fish(shark.x, shark.y, 0));
        boolean[][] visited = new boolean[N][N];
        visited[shark.x][shark.y] = true;

        List<Fish> fishes = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Fish cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] > shark.size)
                    continue;

                visited[nx][ny] = true;
                queue.add(new Fish(nx, ny, cur.dist + 1));

                if (map[nx][ny] != 0 && map[nx][ny] < shark.size) {
                    if (cur.dist + 1 <= minDist) {
                        if (cur.dist + 1 < minDist) {
                            fishes.clear();
                            minDist = cur.dist + 1;
                        }
                        fishes.add(new Fish(nx, ny, cur.dist + 1));
                    }
                }
            }
        }

        if (fishes.isEmpty()) return null;
        fishes.sort((f1, f2) -> f1.x == f2.x ? Integer.compare(f1.y, f2.y) : Integer.compare(f1.x, f2.x));
        return fishes.get(0);
    }
}