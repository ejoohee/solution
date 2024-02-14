import java.util.Scanner;

public class Main {
    static String s,t;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        t = sc.next();

        System.out.println(isChange(t) ? 1 : 0);
    }

    static boolean isChange(String cur){
        if (cur.equals(s)) return true;

        if (cur.length()<=s.length()) return false;

        if (cur.charAt(cur.length()-1)=='A'){
            flag = isChange(cur.substring(0,cur.length()-1));
        }

        if (!flag&&cur.charAt(0)=='B'){
            StringBuilder sb = new StringBuilder(cur);
            sb.deleteCharAt(0);
            sb.reverse();
            flag = isChange(sb.toString());
        }
        return flag;
    }
}