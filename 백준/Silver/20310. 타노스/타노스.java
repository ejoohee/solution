import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        int cnt0=0;
        int cnt1=0;
        for (int i=0; i<str.length(); i++){
            if(str.charAt(i)=='0') {
                cnt0++;
            }else cnt1++;
        }

        for (int i=0; i<cnt0/2; i++){
            sb.append("0");
        }
        for (int i=0; i<cnt1/2; i++){
            sb.append("1");
        }
        System.out.println(sb);
    }
}