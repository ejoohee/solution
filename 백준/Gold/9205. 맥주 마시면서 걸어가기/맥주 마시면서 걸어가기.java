import java.util.Scanner;

public class Main {
    static int tc, n;
    static String feeling;
    static final int MAX_DISTANCE = 1000;
    static Point[] store;
    static Point sangen, festival;
    static boolean[] visited;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            // 맥주 파는 편의점의 갯수
            n = sc.nextInt();
            feeling = "sad";
            sangen = new Point(sc.nextInt(), sc.nextInt());
            store = new Point[n];
            for (int i = 0; i < n; i++) {
                store[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            festival = new Point(sc.nextInt(), sc.nextInt());
            visited = new boolean[n + 2]; // 집, 편의점, 페스티벌

            // 집부터 출발하여 편의점을 들르며 이동
            solution(sangen.x, sangen.y);

            System.out.println(feeling);
        }
    }

    static void solution(int x, int y) {
        if (feeling.equals("happy")) return;

        if (calculate(new int[]{x, y}, new int[]{festival.x, festival.y}) <= MAX_DISTANCE) {
            feeling = "happy";
            return;
        }

        for (int i = 0; i < store.length; i++) {
            if (visited[i]) continue;

            if (calculate(new int[]{x, y}, new int[]{store[i].x, store[i].y}) > MAX_DISTANCE)
                continue;

            visited[i] = true;
            solution(store[i].x, store[i].y);
        }
    }

    static int calculate(int[] from, int[] to) {
        return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
    }
}