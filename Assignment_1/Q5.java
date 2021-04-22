//package Assignment1;

public class Q5 {
	public static StringBuffer largeDeciSum(StringBuffer s1, StringBuffer s2) {
		
		int i, j = 1;
		int l1 = s1.length();
		int l2 = s2.length();
		int d1 = s1.indexOf(".");
		int d2 = s2.indexOf(".");
		if(l1 - d1 < l2 - d2) {
			for(i = 0; i < l2 - d2 - (l1 - d1); i++) {
				s1.append(0);
				j = 2;
			}
		}
		else {
			for(i = 0; i < l1 - d1 - (l2 - d2); i++) {
				s2.append(0);
				j = 1;
			}
		}
		
		s1.deleteCharAt(s1.indexOf("."));
		s2.deleteCharAt(s2.indexOf("."));
		
		int a, c = 0;
		StringBuffer res = new StringBuffer();
		
		s1.reverse();
		s2.reverse();
		
		l1 = s1.length();
		l2 = s2.length();
		
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
		
		if(j == 2) {
			res.insert(res.length() - (l2 - d2), '.');
			//System.out.println(res.length() - (l2 - d2));
		}
		else {
			res.insert(res.length() - (l1 - d1), '.');
			//System.out.println(res.length() - (l1 - d1));
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer s1 = new StringBuffer("1.21");
		StringBuffer s2 = new StringBuffer("11.2");
		
		System.out.println(largeDeciSum(s1, s2));	
	}

}
