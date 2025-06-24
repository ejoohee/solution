import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] ladder;
    static int n, m, h; //n개 세로선 c, m개의 가로선 (사다리), h 높이 실질적인 r
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new boolean[h + 2][n + 2];

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ladder[r][c] = true;
        }

        //사다리가 유효해지도록 0~3개 가로선을 추가하는 모든 경우 시도
        for (int i=0; i<=3; i++){
            if (combi(0,i,1,1)){ // depth, target, 시작 r, 시작 c
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

    //가로선 조합 가능한지 선택
    static boolean combi(int depth, int target, int startR, int startC){

        if (depth == target) return isValid();

        for (int r=startR; r<=h; r++){
            for (int c =1; c<n; c++){
                //사다리 둘 수 있는지 체크
                if (canPlace(r,c)){
                    ladder[r][c] = true;
                    if (combi(depth+1, target, r, c)) return true;
                    ladder[r][c] = false;
                }
            }
        }
        return false;
    }

    //현재 사다리 상태가 i -> i 도착 가능한지
    static boolean isValid(){
        for (int i =1; i<=n; i++){
            int pos = i; //시작
            for (int r =1; r<=h; r++){
                if (ladder[r][pos]){
                    pos++;
                }else if (ladder[r][pos-1])
                    pos--;
            }
            if (pos != i) return false;
        }
        return true;
    }

    static boolean canPlace(int r, int c){
        return !ladder[r][c] && !ladder[r][c-1] && !ladder[r][c+1];
    }
}