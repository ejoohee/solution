import java.util.Scanner;

public class Main {
    static int n;
    static int[] people, sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        people = new int[n + 1];
        sequence = new int[n];
        for (int i = 1; i <= n; i++) {
            people[i] = sc.nextInt();
        }
        turn();
        for (int i : sequence){
            System.out.print(i+" ");
        }
    }

    //내 위치 찾아가기
    static void turn() {
        for (int i=1; i<=n; i++){
            int cnt = people[i];
            int position=0;
            while (cnt>0){
                if(i>sequence[position]&&sequence[position]==0){
                    cnt--;
                }
                position++;
            }
            if(sequence[position]!=0) {
                while (sequence[position]!=0) {
                    position++;
                }
                sequence[position] = i;
            }else {
                sequence[position] = i;
            }
        }
    }
}