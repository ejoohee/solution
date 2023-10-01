import java.util.Scanner;

public class Main {
    static int n;
    static int[][] ability;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ability = new int[n][n];
        visited = new boolean[n];
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                ability[r][c]=sc.nextInt();
            }
        }
        
        dfs(0,0);
        System.out.println(minDiff);
    }

    private static void dfs(int num, int dep) {
        if(dep == n/2){
            calculate();
            return;
        }

        for(int i = num; i < n; i++){
            visited[i]=true;
            dfs(i+1,dep+1);
            visited[i]=false;
        }
    }

    private static void calculate() {
        int startSum = 0;
        int linkSum = 0;

        for(int r = 0; r < n-1; r++){
            for(int c = r+1; c < n; c++) {
                if (visited[r] && visited[c]) {
                    startSum += ability[r][c] + ability[c][r];
                } else if (!visited[r] && !visited[c]) {
                    linkSum += ability[r][c] + ability[c][r];
                }
            }
        }
        minDiff=Math.min(minDiff,Math.abs(startSum-linkSum));
    }
}