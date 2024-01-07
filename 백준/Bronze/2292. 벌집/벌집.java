import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int room = sc.nextInt();
		int num = 1;
		int count = 1;

		for (int i = 1; true; i++) {
			num += 6 * i;
			if (room > num) {
				count++;
			}
            if(room==1) {
				System.out.println("1");
				break;
			}
			if (room <= num) {
				System.out.println(++count);
				break;
			}
		}

	}
}