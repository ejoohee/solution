import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (!q.isEmpty())
                    System.out.println(q.poll());
                else
                    System.out.println(0);
                continue;
            }
            q.add(num);
        }
    }
}
