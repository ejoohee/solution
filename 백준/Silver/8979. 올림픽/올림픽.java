import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //국가의 수
        int k = sc.nextInt(); //등수 알고 싶은 국가
        int[][] medal = new int[n][4];
        for (int i = 0; i < n; i++) {
            medal[i][0] = sc.nextInt(); //국가번호
            medal[i][1] = sc.nextInt(); //금
            medal[i][2] = sc.nextInt(); //은
            medal[i][3] = sc.nextInt(); //동
        }

        Arrays.sort(medal, (a, b) -> {
            if (b[1] != a[1]) {
                return b[1] - a[1]; //내림차순
            } else if (b[2] != a[2]) {
                return b[2] - a[2];
            } else {
                return b[3] - a[3];
            }
        });

        int[] rank = new int[n+1];
        int curRank = 1;

        for (int i = 0; i < n; i++) {
            if (i > 0 && medal[i][1] == medal[i - 1][1] &&
                    medal[i][2] == medal[i - 1][2] && medal[i][3] == medal[i - 1][3]) {
                rank[medal[i][0]] = rank[medal[i - 1][0]]; //동점자 처리
            } else {
                rank[medal[i][0]] = curRank;
            }
            curRank++;
        }
        System.out.println(rank[k]);
    }
}