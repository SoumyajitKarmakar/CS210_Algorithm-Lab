//package Assignment1;

public class Q7 {
	
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
		
		s1.reverse();
		s2.reverse();
		res.reverse();
		
		//System.out.println(s1);
		//System.out.println(s2);
		return res;
	}
	
	public static StringBuffer largeMult(StringBuffer s1, StringBuffer s2) {
		int i, l2;
		//int l1 = s1.length();
		l2 = s2.length();
		StringBuffer res = new StringBuffer("");
		//StringBuffer u;
		StringBuffer t;
		
		
		if(l2 == 1) {
			
			//System.out.println("&" + (int)(s2.charAt(0) - '0'));
			//System.out.println(res);
			for(i = 0; i < (int)(s2.charAt(0) - '0'); i++) {
				//System.out.println("s1\t" + s1);
				//System.out.println("resI\t" + res);
				//System.out.println("sum\t" + largeSum(s1, res));
				res = largeSum(s1, res);
				//System.out.println("resF\t" + res);
				//System.out.println("uR\t" + u.reverse());
				//System.out.println("-----------------------------------------------");
			}
			return res;
		}
		
		for(i = 0; i < l2; i++) {
			StringBuffer y = new StringBuffer("");
			//System.out.println((int)(s2.charAt(i) - '0'));
			//StringBuffer u = new StringBuffer("");
			t = largeMult(s1, y.append((int)(s2.charAt(i) - '0')));
			res = largeSum((res.append(0)), t); 
		}
		
		return res;
	}
	
	public static StringBuffer largeDeciMult(StringBuffer s1, StringBuffer s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int d1 = s1.indexOf(".");
		int d2 = s2.indexOf(".");
		
		s1.deleteCharAt(s1.indexOf("."));
		s2.deleteCharAt(s2.indexOf("."));
		
		StringBuffer res = largeMult(s1, s2);
		
		res.insert(res.length() - ((l1 - d1 - 1) + (l2 - d2 - 1)), '.');
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer s1 = new StringBuffer("1.2");  
		StringBuffer s2 = new StringBuffer("10.2");  
	    System.out.println(largeDeciMult(s1, s2));

	}

}
