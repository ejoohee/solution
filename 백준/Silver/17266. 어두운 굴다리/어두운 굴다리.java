import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 굴다리 길이
        int m = sc.nextInt(); // 가로등 개수
        int[] lamp = new int[m];

        for (int i = 0; i < m; i++) {
            lamp[i] = sc.nextInt();
        }

        // 처음과 끝의 거리
        int max = Math.max(lamp[0], n - lamp[m - 1]);

        // 가로등들 사이의 최대 거리
        for (int i = 1; i < m; i++) {
            int distance = lamp[i] - lamp[i - 1];
            max = Math.max(max, (distance + 1) / 2); // 올림 처리
        }

        System.out.println(max);
    }
}