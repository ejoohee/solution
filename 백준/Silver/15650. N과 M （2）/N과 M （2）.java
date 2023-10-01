import java.util.Scanner;

public class Main {
    static int n, m;
    static int [] pick;
    static boolean [] isUsed;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        pick = new int [m];
        isUsed = new boolean[n+1];

        backtrackting(0,1);
    }

    private static void backtrackting(int dep, int num) {
        if(dep==m){
            StringBuilder sb = new StringBuilder();
            for(int p: pick){
                sb.append(p).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for(int i=num; i<=n; i++) {
            if (!isUsed[i]){
                pick[dep]=i;
                isUsed[i]=true;
                backtrackting(dep+1, i);
                isUsed[i]=false;
            }
        }
    }
}