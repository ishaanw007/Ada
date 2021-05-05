package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Greedy.Graph;

public class NQueen {
	static Integer N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Value of N: ");
		try {
			N = Integer.parseInt(input.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Graph graph = new Graph(N,0);
		Integer[][] board = graph.getAdjancencyMatrix();
		nQueen(board, 0);
		System.out.print("The Final Output Looks Like: ");
		for(Integer i = 0;i < graph.getVertices();i++) {
			for(Integer j = 0;j < graph.getVertices();j++) {
//				System.out.print(board[i][j]+"\t");
				if(board[i][j] == 1) {
					System.out.print((j+1)+" ");
				}
			}
//			System.out.println();
		}
	}
	public static Boolean nQueen(Integer[][] board, Integer row) {
		if(row == N) {
			return true;
		}
		for(Integer i = 0;i < N;i++) {
			if(isSafe(board, row, i)) {
				board[row][i] = 1;
				//The Below Steps are Backtracking Steps
				nQueen(board, row + 1);
				board[row][i] = 0;
			}
		}
		return false;
	}
	public static Boolean isSafe(Integer[][] board, Integer row, Integer col)
    {
     // return false if two queens share the same column
        for (int i = 0; i < row; i++)
        {
            if (board[i][col] == 1) {
                return false;
            }
        }
 
        // return false if two queens share the same `\` diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 1) {
                return false;
            }
        }
 
        // return false if two queens share the same `/` diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++)
        {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
	private static void printSolution(Integer[][] mat)
    {
        for (int i = 0; i < N; i++) {
        	for(Integer j = 0;j < N;j++) {
        		if(mat[i][j] == 1) {
            		System.out.print((j+1)+ " ");
            	}
        	}
        }
        System.out.println();
    }

}
