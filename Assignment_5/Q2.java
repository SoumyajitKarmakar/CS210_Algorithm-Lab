//package Assignment5;

public class Q2 {

	public static int cutRodTopDownAUX(int[] p, int n, int[] r) {
		int q, i;
		if(r[n] > 0) {
			return r[n];
		}
		if(n == 0) {
			q = 0;
		}
		else {
			q = Integer.MIN_VALUE;
			for(i = 1; i <= n; i++) {
				q = Math.max(q, p[i] + cutRodTopDownAUX(p, n - i, r));
			}
		}
		r[n] = q;
		return q;
	}
	
	
	public static int cutRodTopDown(int[] p, int n) {
		int[] r = new int[n + 1];
		int i;
		for(i = 0; i <= n; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		return cutRodTopDownAUX(p, n, r);
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
		
		int n = 4;
		
		System.out.print(cutRodTopDown(p, n));
	}

}
