import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] alphabet = new int[26];
    static int answer, leng;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String basic = br.readLine().trim();
        leng = basic.length();
        countBasic(basic);

        for (int i = 0; i < n - 1; i++) {
            String word = br.readLine().trim();
            checkSimilar(word);
        }

        System.out.println(answer);
    }

    //1. 정확하게 일치 or 2. 오차 범위 1까지는 괜찮음
    static void checkSimilar(String word) {
        if (Math.abs(leng - word.length()) > 1) return;

        int[] compare = new int[26];
        for (int i = 0; i < word.length(); i++) {
            compare[word.charAt(i) - 'A']++;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(compare[i] - alphabet[i]);
        }

        // 교체 1번이면 diff == 2
        // 추가/삭제 1번이면 diff == 1
        if (diff <= 2) answer++;
    }

    static void countBasic(String word){
        for (int i=0; i<word.length(); i++){
            alphabet[word.charAt(i)-'A']++;
        }
    }
}
