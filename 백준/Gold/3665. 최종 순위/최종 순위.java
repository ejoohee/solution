import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> list;
    static int[] indegree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

       for(int tc=1; tc<=T; tc++){
            n = sc.nextInt();
            list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            indegree = new int[n+1];
            int[] array = new int[n+1];
            for (int i = 1; i <= n; i++) {
                array[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                for (int j = i+1; j <= n; j++) {
                    list.get(array[i]).add(array[j]);
                    indegree[array[j]]++;
                }
            }

            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (list.get(a).contains(b)) {
                    list.get(a).remove((Integer)b);
                    list.get(b).add(a);
                    indegree[b]--;
                    indegree[a]++;
                } else {
                    list.get(b).remove((Integer)a);
                    list.get(a).add(b);
                    indegree[a]--;
                    indegree[b]++;
                }
            }

            LinkedList<Integer> result = new LinkedList<>();
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            boolean isCertain = true;
            boolean isAmbiguous = false;

            for (int i = 0; i < n; i++) {
                if (q.isEmpty()) {
                    isCertain = false;
                    break;
                } else if (q.size() > 1) {
                    isAmbiguous = true;
                    break;
                }

                int curr = q.poll();
                result.add(curr);

                for (int next : list.get(curr)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            if (!isCertain) {
                System.out.println("IMPOSSIBLE");
            } else if (isAmbiguous) {
                System.out.println("?");
            } else {
                for (int r : result) {
                    System.out.print(r + " ");
                }
                System.out.println();
            }
        }
    }
}