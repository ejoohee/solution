import java.util.Scanner;

public class Main {

    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[101][101];
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        for (int x = 0; x < 101; x++) {
            for (int y = 0; y < 101; y++) {
                if (map[x][y] == 1) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}