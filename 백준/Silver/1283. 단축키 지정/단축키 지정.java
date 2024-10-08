import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //n개 옵션
    //왼쪽에서부터 오른쪽 순서로 단어의 첫 글자가 이미 단축키로 지정되었는지 쳌
    // 만약 지정 안되 있다면 알파벳 단축키로 지정
    //첫 글자가 이미 지정이 되어있다면 왼쪽에서부터 알파벳 보면서 단축키로 지정
    //어떤 것도 지정할 수 없으면 그냥 놔둠 대소문자 구분 x
    //첫 번째 옵션부터 n번째 옵션까지 적용
    static int n;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Character> keyList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();  // 남아있는 개행문자 처리

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            String s = sc.nextLine();
            String[] words = s.split(" ");


            for (int j = 0; j < words.length; j++) {
                char ch = Character.toUpperCase(words[j].charAt(0));
                if (!keyList.contains(ch)) {
                    keyList.add(ch);
                    //result에 추가
                    wordReturn(words, j, 0);
                    //첫문단으로 builder 되었나 체크
                    flag = true;
                    break;
                }
            }

            // 첫 글자로 설정 실패 시, 다른 글자 단축키 설정 시도
            if (!flag) {
                for (int j = 0; j < words.length; j++) {
                    for (int k = 0; k < words[j].length(); k++) {
                        char ch = Character.toUpperCase(words[j].charAt(k));
                        //키 리스트에 없다면 추가 소문자로
                        if (!keyList.contains(ch)) {
                            keyList.add(ch);
                            //result에 추가
                            wordReturn(words, j, k);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
            }
            if (!flag) {
                sb.append(s).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void wordReturn(String[] words, int k, int position) {
        //k번째 words에 position 위치가 단축키
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (i == k && j == position) {
                    sb.append("[" + words[i].charAt(j) + "]");
                } else {
                    sb.append(words[i].charAt(j));
                }
            }
            sb.append(" ");
        }
        sb.append("\n");
    }
}