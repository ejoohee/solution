import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); // 갯수
        int k = Integer.parseInt(firstLine[1]); // 같은 원소 k개 이하
        int[] num = new int[n];
        int max = 0;
        int[] cnt = new int[100001]; // 각 숫자가 몇 번 나왔는지 카운팅하는 배열
        int start = 0; // 시작 포인터

        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(numbers[i]);
        }

        for (int end = 0; end < n; end++) {
            cnt[num[end]]++;

            while (cnt[num[end]] > k) {
                cnt[num[start]]--;
                start++;
            }
            max = Math.max(max, end - start + 1);
        }

        System.out.println(max);
    }
}