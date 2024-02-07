import java.util.Scanner;

public class Main {
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int totalA=0;

        for (int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a') totalA++;
        }

        if (totalA ==0 || totalA==s.length()){
            System.out.println(0);
            return;
        }

        s= s+s;

        int minB = Integer.MAX_VALUE;
        int cntB = 0;
        for (int i=0; i<totalA; i++){
            if(s.charAt(i)=='b') cntB++;
        }
        minB = Math.min(minB, cntB);

        for (int i=totalA; i<s.length()/2+totalA; i++){
            if (s.charAt(i)=='b'){
                cntB++;
            }
            if (s.charAt(i-totalA)=='b'){
                cntB--;
            }
            minB = Math.min(minB,cntB);
        }
        System.out.println(minB);
    }
}