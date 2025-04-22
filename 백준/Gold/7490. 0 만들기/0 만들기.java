import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<String> results = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            results.clear();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            dfs(1, "1");
            Collections.sort(results);
            for (String res : results) {
                System.out.println(res);
            }
            if (t != tc - 1) {
                System.out.println();
            }
        }

    }

    //백트래킹으로 연산자 조합 만들기
    static void dfs(int current, String expr){
        if(current == n){
            if(evaluate(expr)==0){
                results.add(expr);
            }
            return;
        }

        int next = current+1;
        dfs(next, expr+" "+next);
        dfs(next, expr+"+"+next);
        dfs(next, expr+"-"+next);
    }

    //수식 계산
    static int evaluate(String expr){
        expr = expr.replaceAll(" ", "");

        int sum = 0;
        int num = 0;
        char sign ='+'; //앞에 있는 연산자, 첫 숫자 앞에는 '+'

        for (int i=0; i<expr.length();){
            //숫자 시작 인덱스
            int j = i;

            //숫자 갯수 찾기 isDigit -> 숫자면 true 글자 수 찾는거임
            while (j<expr.length() && Character.isDigit(expr.charAt(j))){
                j++;
            }
            num = Integer.parseInt(expr.substring(i,j));

            if(sign =='+'){
                sum+=num;
            } else if (sign == '-') {
                sum-=num;
            }
            //다음 연산자 미리 저장
            if(j < expr.length()){
                sign = expr.charAt(j);
            }

            i = j+1;
        }
        return sum;
    }
}
