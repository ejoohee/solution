import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    //시간, 방향
    static Map<Integer, Character> directionChanges = new HashMap<>();
    //우, 하, 좌, 상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];

        int appleCnt = sc.nextInt();
        for (int i = 0; i < appleCnt; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r - 1][c - 1] = 1;
        }

        int directionCnt = sc.nextInt();
        for (int i = 0; i < directionCnt; i++) {
            int time = sc.nextInt();
            char direction = sc.next().charAt(0);
            directionChanges.put(time, direction);
        }

        System.out.println(simulate());
    }

    private static int simulate() {
        int time = 0;
        //시작 방향은 우측
        int direction = 0;
        LinkedList<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        map[0][0] = 2;

        while (true) {
            time++;

            int[] head = snake.peekLast();
            int nr = head[0] + dr[direction];
            int nc = head[1] + dc[direction];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] == 2) {
                break;
            }

            if (map[nr][nc] == 1) {
                map[nr][nc] = 2;
                snake.addLast(new int[]{nr, nc});
            } else {
                map[nr][nc] = 2;
                snake.addLast(new int[]{nr, nc});
                int[] tail = snake.poll();
                map[tail[0]][tail[1]] = 0;
            }

            if (directionChanges.containsKey(time)) {
                if (directionChanges.get(time) == 'L') {
                    //왼쪽 90도
                    direction = (direction + 3) % 4;
                } else {
                    direction = (direction + 1) % 4;
                }
            }
        }
        return time;
    }
}