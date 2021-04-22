//package Assignment3;

public class Q3 {
	
	public static int countMer(int []a, int []b, int []c, int n1, int n2) {
		int i = 0, j = 0, k = 0, count = 0;
		while(i < n1 || j < n2) {
			if(j >= n2 || (i < n1 && b[i] <= c[j])) {
				a[k++] = b[i++];
				count = count + j;
			}
			else {
				a[k++] = c[j++];
			}
		}
		return count;
	}
	
	
	public static int countInv(int []a, int n) {
		//int n = a.length;
		if(n == 1) {
			return 0;
		}
		
		int in1 = 0;
		int in2 = 0;
		int in3 = 0;
		int []b = new int[n / 2];
		int []c = new int[n - n / 2];
		int i;
		for(i = 0; i < n / 2; i++) {
			b[i] = a[i];
		}
		for(i = n / 2; i < n; i++) {
			c[i - n / 2] = a[i];
		}
		
		in1 = countInv(b, n / 2);
		in2 = countInv(c, n - n / 2);
		in3 = countMer(a, b, c, n / 2, n - n / 2);
		
		return in1 + in2 + in3;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {1, 20, 6, 4, 5};
		
		
		//System.out.println(Arrays.toString(a));
		System.out.println(countInv(a, 5));
		//System.out.println(Arrays.toString(a));
	}

}
