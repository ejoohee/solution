import java.util.Scanner;

public class Main {
    static int h,w,n,m, max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        h=sc.nextInt();
        w=sc.nextInt();
        n=sc.nextInt(); //세로로 n칸 비워야함
        m=sc.nextInt(); //가로로 m칸 비워야함

        double answer = Math.ceil((double)h/(n+1))*Math.ceil((double) w/(m+1));

        System.out.println((int)answer);
    }
}