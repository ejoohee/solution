import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();

                pq.add(num);
                if (pq.size() > n) pq.poll();

            }
        }
        System.out.println(pq.poll());
    }
}