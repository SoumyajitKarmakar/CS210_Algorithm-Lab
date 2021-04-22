//package Assignment5;

public class Q1 {

	public static int cutRod(int []p, int n) {
		if(n == 0) {
			return 0;
		}
		int q = Integer.MIN_VALUE;
		int i;
		for(i = 1; i <= n; i++) {
			q = Math.max(q, p[i] + cutRod(p, n - i));
		}
		return q;
	}
	
	public static void main(String[] args) {
		int[] p = new int[10];
		p[0] = 0;
		p[1] = 1;
		p[2] = 5;
		p[3] = 8;
		p[4] = 9;
		p[5] = 10;
		
		int n = 4;
		
		System.out.print(cutRod(p, n));
	}
}
