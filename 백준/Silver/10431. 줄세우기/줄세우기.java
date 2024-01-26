import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //20명
        int p = sc.nextInt();

        for (int t=0; t<p; t++){
            int tc = sc.nextInt();
            int cnt = 0;

            int[] students = new int[20];
            for (int i=0; i<20; i++){
                students[i] = sc.nextInt();
            }

            for (int i=0; i<19; i++) {
                for (int j=i+1; j<20; j++){
                    if (students[i]>students[j])
                        cnt++;
                }
            }
            System.out.println(tc+" "+cnt);
        }
    }
}