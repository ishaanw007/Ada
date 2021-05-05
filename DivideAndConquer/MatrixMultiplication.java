package DivideAndConquer;

import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Integer N = input.nextInt();
		Integer[][] A = new Integer[N][N]; 
		Integer[][] B = new Integer[N][N]; 
		Integer[][] C = new Integer[N][N]; 
		System.out.println("Enter the Elements of Matrix 1");
		for(Integer i = 0 ;i < A.length;i++) {
			for(Integer j = 0;j < B.length;j++) {
				A[i][j] = input.nextInt();		
			}
		}
		System.out.println("Enter the Elements of Matrix 2");
		for(Integer i = 0 ;i < A.length;i++) {
			for(Integer j = 0;j < B.length;j++) {
				B[i][j] = input.nextInt();		
			}
		}
		basicMultiplication(A, B, C);
		printMatrix(C);
	}
	public static void basicMultiplication(Integer[][] A, Integer[][] B, Integer[][] C) {
		Integer size = A.length;
		for(Integer i = 0 ;i < A.length;i++) {
			for(Integer j = 0;j < B.length;j++) {
				C[i][j] = 0;
				for(Integer k= 0;k < C.length;k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}
	public static void printMatrix(Integer[][] matrix) {
		System.out.println("The Matrix is : ");
		for(Integer i = 0;i < matrix.length;i++) {
			for(Integer j = 0;j < matrix.length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
