import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 

        long[] distances = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distances[i] = sc.nextLong(); 
        }

        long[] prices = new long[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextLong(); 
        }

        long totalCost = 0;
        long minPrice = prices[0];

        for (int i = 0; i < n - 1; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            totalCost += minPrice * distances[i];
        }

        System.out.println(totalCost);
        sc.close(); 
    }
}