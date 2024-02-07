import java.util.*;

public class Main {
    static int n,d,k,c;
    static int[] sushi, dish, pick;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 접시 수
        d = sc.nextInt(); // 초밥 가지수
        k = sc.nextInt(); // 연속해서 먹는 접시 수
        c = sc.nextInt(); // 쿠폰번호

        sushi = new int[n+k-1];
        dish = new int[d+1];

        for (int i=0; i<n; i++){
            sushi[i] = sc.nextInt();
        }

        int max=0;
        int cnt=0;

        for (int i=0; i<k; i++){
            if(dish[sushi[i]] == 0) cnt++;
            dish[sushi[i]]++;
        }

        max = cnt;
        if (dish[c] == 0) max++;

        for (int i = 1; i < n; i++) {
            dish[sushi[i-1]]--;
            if (dish[sushi[i-1]] == 0) cnt--;

            if (dish[sushi[(i + k - 1) % n]] == 0) cnt++;
            dish[sushi[(i + k - 1) % n]]++;

            int currentMax = cnt;
            if (dish[c] == 0) currentMax++;
            max = Math.max(max, currentMax);
        }

        System.out.println(max);
    }
}