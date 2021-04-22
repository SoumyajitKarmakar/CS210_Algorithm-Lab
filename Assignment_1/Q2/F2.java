//package Assignment1;

import java.util.Arrays;

public class F2 {

	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public static int insert(Node n, int a) {
		
		if(a > n.data) {
			if(n.right != null) {
				return insert(n.right, a);
			}
			else {
				Node p = new Node(a);
				n.right = p;
			}
			
		}
		else {
			if(n.left != null) {
				return insert(n.left, a);
			}
			else {
				Node p = new Node(a);
				n.left = p;
			}
			
		}
		return 0;
	}
	
	public static void printTreeIN(Node root){
		if(root != null){
			printTreeIN(root.left);
			System.out.print(" " + root.data);
			printTreeIN(root.right);
		}
	}
	public static void printTreePO(Node root){
		if(root != null){
			printTreePO(root.left);
			printTreePO(root.right);
			System.out.print(" " + root.data);
		}
	}
	public static void printTreePR(Node root){
		if(root != null){
			System.out.print(" " + root.data);
			printTreePR(root.left);
			printTreePR(root.right);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,4,6,8,2,3,9,7};
		
		Arrays.sort(a); 
		
		Node root = new Node(a[0]);
		
		int i;
		for(i = 1; i < 8; i++) {
			insert(root, a[i]);
		}
		
		System.out.print("Inorder : ");
		printTreeIN(root);
		System.out.print("\n");
		System.out.print("Preorder : ");
		printTreePR(root);
		System.out.print("\n");
		System.out.print("Postorder : ");
		printTreePO(root);
		
	}

}
