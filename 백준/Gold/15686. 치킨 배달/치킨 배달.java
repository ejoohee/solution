import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n, m, min;
    static int[][] city;
    static boolean[][] isVisited;
    static List<int[]> chickenLocations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        min = Integer.MAX_VALUE;

        city = new int[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st[j]);
                if (city[i][j] == 2) chickenLocations.add(new int[]{i, j});
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int cnt, int start) {
        if (cnt == m) {
            min = Math.min(min, calDistance());
            return;
        }

        for (int i = start; i < chickenLocations.size(); i++) {
            int[] loc = chickenLocations.get(i);
            if (!isVisited[loc[0]][loc[1]]) {
                isVisited[loc[0]][loc[1]] = true;
                dfs(cnt + 1, i + 1);
                isVisited[loc[0]][loc[1]] = false;
            }
        }
    }

    static int calDistance() {
        int sumDistance = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (city[i][j] == 1) {
                    int minDistance = Integer.MAX_VALUE;

                    for(int[] loc : chickenLocations) {
                        if (isVisited[loc[0]][loc[1]]) {
                            int distance = Math.abs(i - loc[0]) + Math.abs(j - loc[1]);
                            minDistance = Math.min(minDistance, distance);
                        }
                    }
                    sumDistance += minDistance;
                }
            }
        }
        return sumDistance;
    }
}