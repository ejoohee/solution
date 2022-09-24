import java.util.Scanner;

public class Main {
	
	//중복순열

	static int n, m;
	static int[] select;
	static StringBuilder sb;
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		n = sc.nextInt();
		m = sc.nextInt();

		select = new int[m];
		
		dice(0);
		System.out.println(sb);
	}
	
	static void dice(int dep) {
		if(dep==m) {
			for(int a: select) {
				sb.append(a+" ");
			}sb.append("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
			select[dep]=i+1;
			dice(dep+1);
		}
	}
}