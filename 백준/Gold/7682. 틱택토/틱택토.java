import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] map;
    static int x_count, o_count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            map = new String[3][3];
            x_count = 0;
            o_count = 0;

            // 입력 받기
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = String.valueOf(input.charAt(i * 3 + j));
                    if (map[i][j].equals("X")) x_count++;
                    else if (map[i][j].equals("O")) o_count++;
                }
            }

            System.out.println(isValid() ? "valid" : "invalid");
        }
    }

    static boolean isValid() {
        // 1. 턴 규칙 검증 (X는 항상 O보다 1개 더 많거나 같아야 함)
        if (x_count < o_count || x_count > o_count + 1) return false;

        // 2. 승리 조건 확인
        boolean xWins = hasWon("X");
        boolean oWins = hasWon("O");

        // 두 사람이 동시에 승리할 수는 없음
        if (xWins && oWins) return false;

        // X가 이겼을 경우, X는 반드시 O보다 정확히 1개 더 많아야 함
        if (xWins && x_count != o_count + 1) return false;

        // O가 이겼을 경우, X와 O의 개수는 같아야 함
        if (oWins && x_count != o_count) return false;

        // 3. 빈칸이 남아있더라도 승리 조건이 없다면 무효
        if (!xWins && !oWins && x_count + o_count != 9) return false;

        //모든 조건 만족
        return true;
    }

    static boolean hasWon(String player) {
        for (int i = 0; i < 3; i++) {
            // 가로 빙고
            if (map[i][0].equals(player) && map[i][1].equals(player) && map[i][2].equals(player)) return true;
            // 세로 빙고
            if (map[0][i].equals(player) && map[1][i].equals(player) && map[2][i].equals(player)) return true;
        }
        // 대각선 빙고
        if (map[0][0].equals(player) && map[1][1].equals(player) && map[2][2].equals(player)) return true;
        if (map[0][2].equals(player) && map[1][1].equals(player) && map[2][0].equals(player)) return true;

        return false;
    }
}