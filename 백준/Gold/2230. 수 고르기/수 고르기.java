import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        int start = 0, end = 0;
        int result = Integer.MAX_VALUE;

        while (end < N && start < N) {
            int diff = num[end] - num[start];

            if (diff >= M) {
                result = Math.min(result, diff);
                start++;
            } else {
                end++;
            }
        }

        System.out.println(result);
        sc.close();
    }
}