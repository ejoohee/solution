import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                minLength = Math.min(minLength, end - start);
                sum -= num[start++];
            } else if (end == N) {
                break;
            } else {
                sum += num[end++];
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            minLength = 0;
        }

        System.out.println(minLength);

        sc.close();
    }
}