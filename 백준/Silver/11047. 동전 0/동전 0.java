import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int k = sc.nextInt();
        int[] coinValues = new int[n];

        for (int i = 0; i < n; i++) {
            coinValues[i] = sc.nextInt(); 
        }

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (coinValues[i] <= k) {
                count += k / coinValues[i]; 
                k %= coinValues[i]; 
            }
        }

        System.out.println(count); 
        sc.close();
    }
}