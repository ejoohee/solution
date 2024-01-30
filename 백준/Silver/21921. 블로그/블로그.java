import java.util.Scanner;

public class Main {
    static int n, x, sum, max, cnt;
    static int[] visitors;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        visitors = new int[n+1];
        for (int i=1; i<=n; i++){
            visitors[i] = visitors[i-1]+sc.nextInt();
        }

        for (int i=x; i<=n; i++){
            sum = visitors[i]-visitors[i-x];
            if (sum>max){
                max = sum;
                cnt = 1;
            } else if (sum == max) {
                cnt++;
            }
        }

        if (max == 0){
            System.out.println("SAD");
        }else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}