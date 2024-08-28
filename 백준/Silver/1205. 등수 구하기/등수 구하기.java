import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, score, p; //p는 리스트에 담을 수 있는 갯 수
        Integer[] scores;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        score = sc.nextInt();
        p = sc.nextInt();

        scores = new Integer[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        Arrays.sort(scores, Collections.reverseOrder());

        int rank=1;
        for (int i = 0; i < n; i++) {
            if(scores[i] > score) {
                rank++;
            } else if (scores[i] <= score) {
                break;
            }
        }

        // p가 0인 경우는 고려하지 않음 (문제에 없는 경우)
        if (n == p && score <= scores[n - 1]) {
            rank = -1; // 리스트가 꽉 찼고, score가 마지막 요소보다 낮거나 같은 경우
        }

        System.out.println(rank);
    }
}