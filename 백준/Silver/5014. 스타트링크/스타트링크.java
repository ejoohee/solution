import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    //F 총 층, S 내 위치, G 스타트링크 위치
    static int F,S,G,U,D;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        visited = new boolean[F+1];

        int result = bfs();

        if(result==-1){
            System.out.println("use the stairs");
        }else
            System.out.println(result);
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S,0});
        visited[S]=true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int curFloor = cur[0];
            int curCnt = cur[1];

            if(curFloor==G){
                return curCnt;
            }

            if(curFloor+U<=F&&!visited[curFloor+U]){
                visited[curFloor+U] = true;
                q.add(new int[]{curFloor+U, curCnt+1});
            }
            
            if(curFloor-D>0&&!visited[curFloor-D]){
                visited[curFloor-D] = true;
                q.add(new int[]{curFloor-D,curCnt+1});
            }
        }
        return -1;
    }
}