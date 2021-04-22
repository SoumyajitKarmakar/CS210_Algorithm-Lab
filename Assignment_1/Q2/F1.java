//package Assignment1;

import java.util.Arrays;

public class F1 {
	
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
	
	public static Node BSTminHeight(int [] arrA, int start, int end){
		if(start>end){
			return null;
		}
		int mid = (start + end)/2;
		Node root = new Node(arrA[mid]);
		root.left = BSTminHeight(arrA, start, mid-1);
		root.right =BSTminHeight(arrA, mid+1, end);
		return root;
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
		
		Node root = BSTminHeight(a, 0, a.length-1);
		
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
