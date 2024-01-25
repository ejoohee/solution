import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    //후입선출
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++){
            q.add(i);
        }

        while (q.size()>1){
            //버림
            q.poll();
            int tep = q.poll();
            q.add(tep);
        }

        System.out.println(q.poll());
    }
}