import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int open = 0;
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c=='('){
                open++;
            }else { //닫힌 괄호면
                open--;

                if(i>0) {
                    if (str.charAt(i - 1)=='(') { //레이저
                        ans += open;
                    }else ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
