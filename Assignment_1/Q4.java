//package Assignment1;

public class Q4 {
	public static StringBuffer largeSum(StringBuffer s1, StringBuffer s2) {
		int i, a, c = 0;
		StringBuffer res = new StringBuffer();
		
		s1.reverse();
		s2.reverse();
		
		int l1 = s1.length();
		int l2 = s2.length();
		
		int l = l2;
		if(l1 < l2)
			l = l1;
		
		for (i = 0; i < l; i++)  
	    {   
	        a = ((int)(s1.charAt(i) - '0') +  (int)(s2.charAt(i) - '0') + c);  
	        res.append((char)(a % 10 + '0'));
	        c = a / 10;  
	    }
		
		if(l1 < l2) {
			for(i = l; i < l2; i++) {
				a = ((int)(s2.charAt(i) - '0') + c);  
	        	res.append((char)(a % 10 + '0'));  
	        	c = a / 10;
			}
		}
		else {
			for(i = l; i < l1; i++) {
				a = ((int)(s1.charAt(i) - '0') + c);  
	        	res.append((char)(a % 10 + '0'));  
	        	c = a / 10;
			}
		}
		
		if (c > 0) {
	        res.append((char)(c + '0'));  
		}
		
		res.reverse();
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer s1 = new StringBuffer("21");  
		StringBuffer s2 = new StringBuffer("100");  
	    System.out.println(largeSum(s1, s2));

	}
}
