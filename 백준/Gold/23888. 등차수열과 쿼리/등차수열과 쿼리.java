import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int d = sc.nextInt();
        int q = sc.nextInt();

        long[] sequence = new long[1000001];

        sequence[1] = a;
        for (int i = 2; i <= 1000000; i++) {
            sequence[i] = sequence[i - 1] + d;
        }

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (type == 1) {
                // 합 구하기
                long sum = calculateSum(sequence, l, r);
                System.out.println(sum);
            } else if (type == 2) {
                // 최대공약수 구하기
                long gcd = calculateGCD(sequence, l, r);
                System.out.println(gcd);
            }
        }
    }

    // 등차수열의 합 계산
    private static long calculateSum(long[] sequence, int l, int r) {
        long sum = 0;
        for (int i = l; i <= r; i++) {
            sum += sequence[i];
        }
        return sum;
    }

    // 최대공약수 계산
    private static long calculateGCD(long[] sequence, int l, int r) {
        long gcd = sequence[l];
        for (int i = l + 1; i <= r; i++) {
            gcd = calculateGCD(gcd, sequence[i]);
        }
        return gcd;
    }

    private static long calculateGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}