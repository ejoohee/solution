import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while (true){
            String str = sc.next();
            if (str.equals("end")) {
                break;
            }
            if (isValid(str)) {
                System.out.printf("<" + str + "> " + "is acceptable.%n");
            } else System.out.printf("<" + str + "> " + "is not acceptable.%n");
        }
    }

    static boolean isValid(String str) {
        boolean valid = false;
        int vowelCount = 0; // 연속된 모음의 수
        int consonantCount = 0; // 연속된 자음의 수
        // a,e,i,o,u 하나 반드시 포함해야함
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //모음인지 확인
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                valid = true;
                vowelCount++;
                consonantCount = 0;
            } else {
                vowelCount = 0;
                consonantCount++;
            }
            //같은 글자 연속적으로 두 번 오면 x, ee랑 oo만 허용
            if (i > 0 && ch == str.charAt(i - 1)&&ch != 'e'&&ch != 'o') {
                valid = false;
                break;
            }
            //모임이 3개 or 자음 3개 연속 오면 안됨
            if (vowelCount >= 3 || consonantCount >= 3) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}