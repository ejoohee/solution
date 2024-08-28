import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //윷놀이 y, 같은 그림 f, 원카드 o 각각 2 3 4명
        //인원 부족하면 게임 시작 못함
        //신청한 횟 수 n, 플레이할 게임의 종류일때 임스랑 게임할 횟수
        //한 번 한사람이랑 게임 안함
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 게임 신청 한 사람 수
        String y = sc.next(); // 플레이할 게임 종류
        int playPeople = 0;
        if (y.equals("Y")){
            playPeople = 2;
        } else if (y.equals("F")) {
            playPeople = 3;
        } else if (y.equals("O")) {
            playPeople = 4;
        }

        int cnt = 1; //현재 게임 몇 명 모였는지 본인 포함
        int playCnt = 0; // 게임 횟수
        HashSet<String> names = new HashSet<>();
        for (int i=0; i<n; i++) {
            String name = sc.next();
            if(names.contains(name)) {
                continue;
            }else  {
                names.add(name);
                cnt++;
                if (cnt == playPeople) {
                    playCnt++;
                    cnt = 1;
                }
            }
        }
        System.out.println(playCnt);
    }
}