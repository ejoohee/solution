import java.util.Scanner;

public class Main {
    static int max, min, n;
    static int[] num, operator;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n];
        //덧셈 뺄셈 곱셈 나눗셈
        operator = new int[4];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        for (int j = 0; j < 4; j++) {
            operator[j] = sc.nextInt();
        }
        dfs(1, num[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int cnt, int number) {
        if (cnt == n) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                if (i == 0) dfs(cnt + 1, number + num[cnt]);
                else if (i == 1) dfs(cnt + 1, number - num[cnt]);
                else if (i == 2) dfs(cnt + 1, number * num[cnt]);
                else if (i == 3) dfs(cnt + 1, number / num[cnt]);

                operator[i]++;
            }
        }
    }
}
