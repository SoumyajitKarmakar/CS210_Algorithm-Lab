//package Assignment5;

public class Q3 {

	public static int cutRodBottomUp(int[] p, int n) {
		int[] r = new int[n + 1];
		r[0] = 0;
		int q, j, i;
		for(i = 1; i <= n; i++) {
			q = Integer.MIN_VALUE;
			for(j = 1; j <= i; j++) {
				q = Math.max(q, p[j] + r[i - j]);
			}
			r[i] = q;
		}
		return r[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = new int[10];
		p[0] = 0;
		p[1] = 1;
		p[2] = 5;
		p[3] = 8;
		p[4] = 9;
		p[5] = 10;
		
		int n = 3;
		
		System.out.print(cutRodBottomUp(p, n));

	}

}
