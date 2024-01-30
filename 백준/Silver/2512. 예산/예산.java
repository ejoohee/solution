import java.util.Scanner;

public class Main {
    static int n, m, r, l, max;
    static int[] cities;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //도시 수
        cities = new int[n]; //도시 예산 요청 금액
        for (int i = 0; i < n; i++) {
            cities[i] = sc.nextInt();
            r = Math.max(r, cities[i]);
        }

        m = sc.nextInt(); //도시 총 예산
        //max부터 줄여나감
        while (l <= r) {
            int sum = 0;
            int mid = (l + r) / 2;
            for (int city : cities) {
                sum += Math.min(city, mid);
            }
            //예산 초과하는 경우, 상한액 줄이기
            if (sum > m) {
                r = mid - 1;
            } else {
                max = mid;
                l = mid + 1;
            }
        }
        System.out.println(max);
    }
}