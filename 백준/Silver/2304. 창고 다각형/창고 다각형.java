import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int n, l, h, result, maxH;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Position> map = new ArrayList<>();
        maxH = 0;
        result = 0;
        
        for (int i = 0; i < n; i++) {
            l = sc.nextInt(); // 가로 위치
            h = sc.nextInt(); // 높이
            maxH = Math.max(maxH, h); // 최대 높이 갱신
            map.add(new Position(h, l));
        }
        
        Collections.sort(map);

        // 좌측에서 최대 높이 기둥까지 넓이 계산
        int r = 0; // 현재 높이
        int c = 0; // 현재 가로 위치
        for (Position po : map) {
            if (po.r > r) {
                result += r * (po.c - c); 
                r = po.r; // 현재 높이를 갱신
                c = po.c; // 현재 가로 위치 갱신
            }
            if (po.r == maxH) {
                break; 
            }
        }

        // 우측에서 최대 높이 기둥까지 넓이 계산
        r = 0;
        c = map.get(map.size() - 1).c; 
        for (int j = map.size() - 1; j >= 0; j--) {
            Position po = map.get(j);
            if (po.r > r) {
                result += r * (c - po.c); // 넓이 계산
                r = po.r; // 현재 높이 갱신
                c = po.c; // 현재 가로 위치 갱신
            }
            if (po.r == maxH) {
                break; 
            }
        }
        
        int leftMaxIdx = 0;
        int rightMaxIdx = 0;

        // 첫 번째 최대 높이 기둥의 인덱스 찾기
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).r == maxH) {
                leftMaxIdx = i;
                break;
            }
        }

        // 마지막 최대 높이 기둥의 인덱스 찾기
        for (int i = map.size() - 1; i >= 0; i--) {
            if (map.get(i).r == maxH) {
                rightMaxIdx = i;
                break;
            }
        }
        
        result += maxH * (map.get(rightMaxIdx).c - map.get(leftMaxIdx).c + 1);

        System.out.println(result);
    }
}

class Position implements Comparable<Position> {
    int r; // 세로 높이
    int c; // 가로 위치

    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.c, o.c); 
    }
}