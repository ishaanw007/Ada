package DivideAndConquer;

import java.util.Scanner;

public class MatrixMultiplication1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Integer N = input.nextInt();
		Integer[][] A = new Integer[N][N]; 
		Integer[][] B = new Integer[N][N]; 
//		Integer[][] C = new Integer[N][N]; 
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
		Integer[][] C = multiplication(A, B);
		printMatrix(C);
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
	public static Integer[][] multiplication(Integer[][] A, Integer[][] B) {
		Integer[][] C = new Integer[A.length][A.length];
		if(A.length == 1) {
//			C[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
//			C[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
//			C[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
//			C[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1]; 
			C[0][0] = A[0][0] * B[0][0];
		}else {
			Integer[][] a = new Integer[A.length/2][A.length/2];
			Integer[][] b = new Integer[A.length/2][A.length/2];
			Integer[][] c = new Integer[A.length/2][A.length/2];
			Integer[][] d = new Integer[A.length/2][A.length/2];
			
			Integer[][] e = new Integer[A.length/2][A.length/2];
			Integer[][] f = new Integer[A.length/2][A.length/2];
			Integer[][] g = new Integer[A.length/2][A.length/2];
			Integer[][] h = new Integer[A.length/2][A.length/2];
			
			// dividing matrix A into 4 parts
            divideArray(A, a, 0, 0);
            divideArray(A, b, 0, A.length / 2);
            divideArray(A, c, A.length / 2, 0);
            divideArray(A, d, A.length / 2, A.length / 2);

            // dividing matrix B into 4 parts
            divideArray(B, e, 0, 0);
            divideArray(B, f, 0, A.length / 2);
            divideArray(B, g, A.length / 2, 0);
            divideArray(B, h, A.length / 2, A.length / 2);
			
            Integer[][] C00 = addMatrices( multiplication(a,e), multiplication(b,g) );
            Integer[][] C01 = addMatrices( multiplication(a,f), multiplication(b,h) );
            Integer[][] C10 = addMatrices( multiplication(c,e), multiplication(d,g) );
            Integer[][] C11 = addMatrices( multiplication(c,f), multiplication(d,h) );
         // adding all subarray back into one
            copySubArray(C00, C, 0, 0);
            copySubArray(C01, C, 0, A.length / 2);
            copySubArray(C10, C, A.length / 2, 0);
            copySubArray(C11, C, A.length / 2, A.length / 2);
		}
		return C;
	}
	// divides array
    public static void divideArray(Integer[][] P, Integer[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
        
        printMatrix(C);
    }

    // copies
    public static void copySubArray(Integer[][] C, Integer[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }
    // Adding 2 matrices
    public static Integer[][] addMatrices(Integer[][] a, Integer[][] b) {
        int n = a.length;
        Integer[][] res = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
        return res;
    }

    // Subtracting 2 matrices
    public static int[][] subMatrices(int[][] a, int[][] b) {
        int n = a.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = a[i][j] - b[i][j];
            }
        }
        return res;
    }
}
