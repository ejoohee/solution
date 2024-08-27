import java.util.Scanner;

public class Main {
    static int n;
    static int[][] size;

    public static void main(String[] args) {
        //몸무게 x, 키 y 몸무게 키 둘 다 더 커야지 덩치 크다고 할 수 있음
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //전체 사람 수
        size = new int[n][2];
        for (int i = 0; i < n; i++) {
            size[i][0] = sc.nextInt(); //몸무게
            size[i][1] = sc.nextInt(); //키
        }


        for (int i = 0; i < n; i++) {
            //i는 지금 나 k는 몇 등 될지
            int k = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (size[i][0] < size[j][0] && size[i][1] < size[j][1]) {
                    k++;
                }
            }
            System.out.print(k + " ");
        }
    }
}