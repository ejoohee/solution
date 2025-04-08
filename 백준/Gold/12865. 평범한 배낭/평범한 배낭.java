import java.util.*;

public class Main {
    static int n, k;
    static int[][] items;
    static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        items = new int[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = sc.nextInt(); // weight
            items[i][1] = sc.nextInt(); // value
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int idx, int weight) {
        if (idx == n) return 0;

        String key = idx + "," + weight;
        if (memo.containsKey(key)) return memo.get(key);

        int result = dfs(idx + 1, weight); // 안 고름

        if (weight + items[idx][0] <= k) {
            result = Math.max(result,
                    items[idx][1] + dfs(idx + 1, weight + items[idx][0])); // 고름
        }

        memo.put(key, result);
        return result;
    }
}
