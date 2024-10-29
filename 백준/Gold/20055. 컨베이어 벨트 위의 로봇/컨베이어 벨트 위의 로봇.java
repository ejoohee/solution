import java.util.Scanner;

public class Main {

    static int n, k;
    static int[] arr;
    static boolean[] robot;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[2 * n];
        robot = new boolean[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(simulation());
    }

    private static int simulation() {
        int cnt = 0;

        while (isOk()) {
            cnt++;

            // 1. 벨트 회전
            rotateBelt();

            // 2. 로봇 이동
            moveRobots();

            // 3. 로봇 올리기
            loadRobot();

        }
        return cnt;
    }

    private static void rotateBelt() {
        int lastDurability = arr[2 * n - 1];
        boolean lastRobot = robot[2 * n - 1];

        for (int i = 2 * n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
            robot[i] = robot[i - 1];
        }
        arr[0] = lastDurability;
        robot[0] = lastRobot;

        // 내리는 위치의 로봇 제거
        robot[n - 1] = false;
    }

    private static void moveRobots() {
        for (int i = n - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && arr[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                arr[i + 1]--;
            }
        }
        robot[n - 1] = false;
    }

    private static void loadRobot() {
        if (arr[0] > 0) {
            robot[0] = true;
            arr[0]--;
        }
    }

    private static boolean isOk() {
        int cnt = 0;
        for (int durability : arr) {
            if (durability == 0) cnt++;
        }
        return cnt < k;
    }
}
