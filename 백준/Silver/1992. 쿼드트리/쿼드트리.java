import java.util.Scanner;

public class Main {

	static int [][]map;
	static int one;
	static int zero;
	static StringBuilder sb = new StringBuilder();
	
	static int cnt(int n, int r, int c){
		int cntOne=0;
		
		for(int row=r; row<r+n; row++) {
			for(int col=c; col<c+n; col++) {
				if(map[row][col]==1) {
					cntOne++;
				}
			}
		}
		return cntOne;
	}
	
	static void quadTree(int n, int r, int c) {
		
		//종료조건
		if(n==1) {
			if(map[r][c]==0) {
				sb.append("0");
			}else {
				sb.append("1");
				}
			return;
		}
		int cntOne = cnt(n,r,c);
		
		if(cntOne==n*n) {
			sb.append("1");
		}else if(cntOne==0) {
			sb.append("0");
		}else {
			sb.append("(");
			quadTree(n/2, r, c); //왼 위
			quadTree(n/2, r, c+n/2); // 왼 아래
			quadTree(n/2, r+n/2, c); //오 위
			quadTree(n/2, r+n/2, c+n/2); //오 아래
			sb.append(")");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		map=new int [n][n];
		
		for(int r=0; r<n; r++) {
			String arr=sc.next();
			for(int c=0; c<n; c++) {
				map[r][c]=arr.charAt(c)-48;
			}
		}
		
		quadTree(n,0,0);
		System.out.println(sb);
	}
}