//package Assignment1;

import java.util.Scanner;

public class F2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AVL tree height : ");
		int a = Integer.parseInt(sc.nextLine());
		int min = (int)Math.ceil(Math.log(a + 1) / Math.log(2));
		int max = (int)Math.floor(1.44 * (Math.log(a + 2) / Math.log(2)) - 0.328);
		System.out.println("Min height is : " + min);
		System.out.println("Max height is : " + max);
		sc.close();
	}

}
