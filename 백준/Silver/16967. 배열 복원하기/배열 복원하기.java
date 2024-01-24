import java.util.Scanner;

public class Main {
    static int h,w,x,y;
    static int[][] a, b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w =  sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        a = new int[h][w];
        b = new int[h+x][w+y];

        for (int i=0; i<h+x; i++){
            for (int j=0; j<w+y; j++){
                b[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<h; i++){
            for (int j=0; j<w; j++){
                a[i][j] = b[i][j];
            }
        }

        for (int i=x; i<h; i++){
            for (int j=y; j<w; j++){
                a[i][j]-=a[i-x][j-y];
            }
        }

        for (int i=0; i<h; i++){
            for (int j=0; j<w; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}