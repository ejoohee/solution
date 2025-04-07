import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] seg = {
            {1,1,1,1,1,1,0}, // 0
            {0,0,1,1,0,0,0}, // 1
            {1,0,1,0,1,1,1}, // 2
            {1,0,1,1,0,1,1}, // 3
            {0,1,1,1,0,0,1}, // 4
            {1,1,0,1,0,1,1}, // 5
            {1,1,0,1,1,1,1}, // 6
            {1,0,1,1,0,0,0}, // 7
            {1,1,1,1,1,1,1}, // 8
            {1,1,1,1,0,1,1}  // 9
    };

    static int[] toDigitArray(int num, int k) {
        int[] arr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            arr[i] = num % 10;
            num /= 10;
        }
        return arr;
    }

    static int getChangeCount(int[] from, int[] to) {
        int count = 0;
        for (int i = 0; i < from.length; i++) {
            for (int j = 0; j < 7; j++) {
                if (seg[from[i]][j] != seg[to[i]][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 총 층 수
        int K = Integer.parseInt(st.nextToken()); // 자리 수
        int P = Integer.parseInt(st.nextToken()); // 최대 LED 변경 수
        int X = Integer.parseInt(st.nextToken()); // 현재 층

        int[] cur = toDigitArray(X, K);
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (i == X) continue;

            int[] target = toDigitArray(i, K);
            int diff = getChangeCount(cur, target);

            if (diff <= P) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
