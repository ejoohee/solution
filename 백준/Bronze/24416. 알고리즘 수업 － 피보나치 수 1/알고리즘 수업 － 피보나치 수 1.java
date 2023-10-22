import java.util.Scanner;

public class Main {
    static int cntRecursive = 0;
    static int cntDp = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        fibo(n);
        fiboDp(n);

        System.out.println(cntRecursive + " " + cntDp);

        scanner.close();
    }

    public static int fibo(int n) {
        if (n == 1 || n == 2) {
            cntRecursive++;
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static int fiboDp(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            cntDp++;
        }

        return f[n];
    }
}