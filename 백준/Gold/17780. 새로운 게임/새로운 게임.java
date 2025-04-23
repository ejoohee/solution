import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k, turnCount;
    static int max = 1;
    static int[][] map;
    static List<Integer>[][] board;
    static Horse[] horses;
    static int[] dr = {0,0,0,-1,1}; //1 우 2 좌 3 상 4 하
    static int[] dc = {0,1,-1,0,0};
    //0은 흰색 1은 빨강 2는 파랑
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //체스판 크기
        k = Integer.parseInt(st.nextToken()); //말의 갯수

        horses = new Horse[k + 1];

        map = new int[n][n];
        board = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //말 정보 저장
        for (int i=1; i<=k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken()) -1;
            int direction = Integer.parseInt(st.nextToken());
            horses[i] = new Horse(r,c,direction);
            board[r][c].add(i); //보드에 말 위치 저장
        }
        //게임 시작
        game();

        System.out.println(turnCount>=1000?-1: turnCount);
    }

    //게임 종료 조건 -> 말이 4개 이상 쌓이면 종료
    //다음 이동하려는 칸이 흰색이면 이동 , 이미 말이 있으면 그 위에 올려놓음
    //이동하려는 말 위에 누가 같이 있으면 같이 이동
    //빨간색이면 이동 후 순서 바꾸고 원래 있는 리스트에 올림
    //파랑이면 a번 말의 이동방향을 반대로 하고 한칸이동
    //방향 반대로 하고 한칸이동하려는게 파랑이면 이동 안하고 방향만 바뀸
    //체스판 벗어나는 경우에는 파랑과 같은 경우
    //0은 흰색, 1은 빨간색, 2는 파란색
    static int game(){
        //게임이 절대로 안끝나거나 1000보다 크면 -1
        //턴 한 번은 1 ~ k까지 이동 시키는 것.
        turnCount = 1;

        while (turnCount<1000) {

            for (int current = 1; current <= k; current++) {
                // 현재 말이 맨 아래에 있는 말인지 확인
                Horse currentHorse = horses[current];
                int r = currentHorse.r;
                int c = currentHorse.c;

                // 현재 말이 맨 아래에 있지 않으면 스킵
                if (board[r][c].get(0) != current) {
                    continue;
                }

                int direction = currentHorse.direction;

                //다음 칸 무슨 색인지 봐보기
                int nextR = r + dr[direction];
                int nextC = c + dc[direction];

                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= n || map[nextR][nextC] == 2) {
                    blue(current, r, c, direction);
                } else if (map[nextR][nextC] == 0) {
                    move(r, c, nextR, nextC, 0, current);
                } else if (map[nextR][nextC] == 1) {
                    move(r, c, nextR, nextC, 1, current);
                }

                //max 가 4 넘어가나? - 각 말 이동 후 즉시 확인
                if (max >= 4) {
                    return turnCount;
                }
            }
            turnCount++;

            // 턴 종료 후 한번 더 체크 
            if (max >= 4) {
                return turnCount;
            }
        }
        return turnCount;
    }

    //파랑 or 범위 넘어갔을 때
    static void blue(int number, int r, int c, int direction){

        Horse currentHorse = horses[number];

        // 방향을 반대로 바꾸기
        if (direction == 1) direction = 2;
        else if (direction == 2) direction = 1;
        else if (direction == 3) direction = 4;
        else direction = 3;

        //방향 바꿔줌
        currentHorse.direction = direction;

        //현재 위치에서 방향 바꾼대로 움직여야함 근데 파랑이면 안움직임
        int nextR = r+dr[direction];
        int nextC = c+dc[direction];

        // 범위 밖이거나 파랑이면 이동 안 함
        if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= n || map[nextR][nextC] == 2) {
            return;
        }

        // 흰색 or 빨강
        if (map[nextR][nextC] == 0) {
            move(r, c, nextR, nextC, 0, number);
        } else if (map[nextR][nextC] == 1) {
            move(r, c, nextR, nextC, 1, number);
        }
    }

    static void move(int r, int c, int targetR, int targetC, int color, int horseNum) {
        List<Integer> currentStack = board[r][c];
        int startIndex = currentStack.indexOf(horseNum);  // 말 번호로 시작 인덱스 찾기

        List<Integer> moving = new ArrayList<>(currentStack.subList(startIndex, currentStack.size()));
        currentStack.subList(startIndex, currentStack.size()).clear();

        if (color == 1) {
            Collections.reverse(moving);
        }

        for (int num : moving) {
            horses[num].r = targetR;
            horses[num].c = targetC;
            board[targetR][targetC].add(num);
        }

        max = Math.max(max, board[targetR][targetC].size());
    }

    static class Horse{
        int r,c;
        int direction;
        public Horse(int r, int c, int direction) {
            this.r = r;
            this.c = c;
            this.direction = direction;
        }
    }
}