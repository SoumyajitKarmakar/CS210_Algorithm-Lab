//package Assignment3;

import java.util.Scanner;

public class F3 {
	
	public static void join(int[][] C, int[][] P, int iB, int jB) {
		
		int i1, i2, j1, j2;
		for(i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
			for(j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
				P[i2][j2] = C[i1][j1];
			}
		}
	}
	
	public static void split(int[][] P, int[][] C, int iB, int jB){
		
		int i1, i2, j1, j2;
		for(i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
			for(j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
				C[i1][j1] = P[i2][j2];
			}
		}
	}
	
	public static int[][] add(int[][] A, int[][] B){
		
		int i, j, n = A.length;
		int[][] C = new int[n][n];
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}
	
	public static int[][] sub(int[][] A, int[][] B){
		
		int i, j, n = A.length;
		int[][] C = new int[n][n];
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				C[i][j] = A[i][j] - B[i][j];
			}
		}
		return C;
	}
	
	public static int[][] matMultStra(int[][] A, int[][] B){
		
		int n = A.length;
		int[][] R = new int[n][n];
	
		if (n == 1) {
			R[0][0] = A[0][0] * B[0][0];
		}
		else {
			int[][] A11 = new int[n/2][n/2];
			int[][] A12 = new int[n/2][n/2];
			int[][] A21 = new int[n/2][n/2];
			int[][] A22 = new int[n/2][n/2];
			int[][] B11 = new int[n/2][n/2];
			int[][] B12 = new int[n/2][n/2];
			int[][] B21 = new int[n/2][n/2];
			int[][] B22 = new int[n/2][n/2];
			
			split(A, A11, 0 , 0);
			split(A, A12, 0 , n/2);
			split(A, A21, n/2, 0);
			split(A, A22, n/2, n/2);
			
			split(B, B11, 0 , 0);
			split(B, B12, 0 , n/2);
			split(B, B21, n/2, 0);
			split(B, B22, n/2, n/2);
			
			int [][] M1 = matMultStra(add(A11, A22), add(B11, B22));
			int [][] M2 = matMultStra(add(A21, A22), B11);
			int [][] M3 = matMultStra(A11, sub(B12, B22));
			int [][] M4 = matMultStra(A22, sub(B21, B11));
			int [][] M5 = matMultStra(add(A11, A12), B22);
			int [][] M6 = matMultStra(sub(A21, A11), add(B11, B12));
			int [][] M7 = matMultStra(sub(A12, A22), add(B21, B22));
			
			int [][] C11 = add(sub(add(M1, M4), M5), M7);
			int [][] C12 = add(M3, M5);
			int [][] C21 = add(M2, M4);
			int [][] C22 = add(sub(add(M1, M3), M2), M6);
	
			join(C11, R, 0 , 0);
			join(C12, R, 0 , n/2);
			join(C21, R, n/2, 0);
			join(C22, R, n/2, n/2);
		}
	
	return R;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Strassen Multiplication\n");
		
		System.out.println("Enter order of matrices, N :");
		int N = scan.nextInt();
		
		System.out.println("Enter N*N elements for matrix 1\n");
		
		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = scan.nextInt();
			}
		}
		
		System.out.println("Enter N*N elements for matrix 2\n");
		
		int[][] B = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				B[i][j] = scan.nextInt();
			}
		}
		
		int[][] C = matMultStra(A, B);
		System.out.println("\nProduct of matrices A and B : ");
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(C[i][j] +" ");
			}
			System.out.println();
		}
		
		scan.close();
		
	}

}
