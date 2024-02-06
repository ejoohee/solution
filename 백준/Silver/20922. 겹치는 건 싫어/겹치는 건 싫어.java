import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); // 갯수
        int k = Integer.parseInt(firstLine[1]); // 같은 원소 k개 이하
        int[] num = new int[n];
        int max = 0;
        int start = 0; // 시작 포인터

        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(numbers[i]);
        }

        HashMap<Integer, Integer> cntMap = new HashMap<>();

        for (int end = 0; end < n; end++) {
            // 해당 숫자, 카운팅
            cntMap.put(num[end], cntMap.getOrDefault(num[end], 0) + 1);
            while (cntMap.get(num[end]) > k) {
                cntMap.put(num[start], cntMap.get(num[start]) - 1);
                if (cntMap.get(num[start]) == 0) {
                    cntMap.remove(num[start]);
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        System.out.println(max);
    }
}