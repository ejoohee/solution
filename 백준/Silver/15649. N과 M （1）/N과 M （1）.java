import java.util.Scanner;

public class Main {

	static int n, m;
	static int[] select;
	static boolean[] isUsed;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		select=new int[m];
		isUsed = new boolean[n];
		dice(0);
	}

	private static void dice(int dep) {
		if (dep == m) {
			for (int a : select) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				select[dep] = i + 1;
				dice(dep + 1);
				isUsed[i] = false;
			}
		}
	}
}