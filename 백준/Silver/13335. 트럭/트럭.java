import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, w, l, time, curWeight; //트럭, 다리길이, 하중
    static Queue<Integer> bridge;
    static Queue<Integer> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q = new LinkedList<>();
        n = sc.nextInt();
        w = sc.nextInt();
        l = sc.nextInt();
        for (int i=0; i<n; i++){
            q.add(sc.nextInt());
        }

        bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0); // 초기 다리 상태를 빈 상태로 만듦
        }

        while (!q.isEmpty()||curWeight>0){
            time++;

            // 다리에서 트럭을 한 칸 전진시키고, 다리에서 나간 트럭 무게 빼기
            curWeight -= bridge.poll();

            if (!q.isEmpty()) {
                //올라갈 수 있으면
                if (curWeight + q.peek() <= l) {
                    int truck = q.poll();
                    bridge.add(truck);
                    curWeight += truck;
                } else {
                    //올라갈 수 없으면 시간만 추가
                    bridge.add(0);
                }
            }else {
                    bridge.add(0);
                }
            }
        System.out.println(time);
    }
}