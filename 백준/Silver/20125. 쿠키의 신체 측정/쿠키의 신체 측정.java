import java.util.Scanner;

public class Main {

    static int[] dx = {0,0,-1,1}; //좌우상하
    static int[] dy = {-1,1,0,0};
    static int n;
    static char[][] map;
    public static void main(String[] args) {
        //왼쪽 팔, 오른 쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리 길이
        Scanner sc = new Scanner(System.in);
        int leftArm, rightArm, waist, leftLeg, rightLeg;
        int x = 0 ; int y = 0 ;
        n = sc.nextInt();
        boolean headFind = false;
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '*'&&!headFind) {
                    //머리 찾았으면 심장위치 쳌
                    x = i+1; y = j; headFind = true;
                }
            }
        }

        leftArm = lengthMeasurement(x,y,0);
        rightArm = lengthMeasurement(x,y,1);
        waist = lengthMeasurement(x,y,3);
        leftLeg = lengthMeasurement(x+waist,y-1,3);
        rightLeg = lengthMeasurement(x+waist,y+1,3);

        System.out.println((x+1)+" "+(y+1));
        System.out.println(leftArm+" "+rightArm+" "+waist+" "+leftLeg+" "+rightLeg);
    }

    static int lengthMeasurement(int x, int y, int dir){
        //r,c는 위치 측정 시작 방향
        //길이 찾아보자
        //dir 좌 우 상 하
        int length = 0;
        while (true) {
            x += dx[dir];
            y += dy[dir];

            if (x < 0 || x >= n || y < 0 || y >= n) break;
            if (map[x][y] == '*') {
                length++;
            } else {
                break;
            }
        }
        return length;
    }
}