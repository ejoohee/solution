import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> result;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        result = new ArrayList<>();

        for (int i = 2; i < 8; i++) {
            if(i==4||i==6) continue;
            isAllOk(i,n-1);
        }

        for (int num: result){
            System.out.println(num);
        }
    }

    //소수인지 아닌지 저장해주기

    private static void isAllOk(int num, int remaining ) {
        if (remaining == 0) {
            result.add(num);
            return;
        }

        for (int i=0; i<10; i++){
            int newNum = num*10+i;
            if (isPrimeNum(newNum))
                isAllOk(newNum, remaining-1);
        }
    }

    static boolean isPrimeNum(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}