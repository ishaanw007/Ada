package BackTracking;
import java.util.Arrays;

class NQueenProblem
{
    // `N × N` Board
    public static final int N = 4;
 
    // Function to check if two queens threaten each other or not
    private static boolean isSafe(Integer[][] mat, int r, int c)
    {
        // return false if two queens share the same column
        for (int i = 0; i < r; i++)
        {
            if (mat[i][c] == 1) {
                return false;
            }
        }
 
        // return false if two queens share the same `\` diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
        {
            if (mat[i][j] == 1) {
                return false;
            }
        }
 
        // return false if two queens share the same `/` diagonal
        for (int i = r, j = c; i >= 0 && j < N; i--, j++)
        {
            if (mat[i][j] == 1) {
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
 
    private static Boolean nQueen(Integer[][] mat, int r)
    {
        // if `N` queens are placed successfully, print the solution
        if (r == N)
        {
            printSolution(mat);
            return true;
        }
 
        // place queen at every square in the current row `r`
        // and recur for each valid movement
        for (int i = 0; i < N; i++)
        {
            // if no two queens threaten each other
            if (isSafe(mat, r, i))
            {
                // place queen on the current square
                mat[r][i] = 1;
 
                // recur for the next row
//                if(nQueen(mat, r + 1)) {
//                	return true;
//                }
                nQueen(mat, r + 1);
 
                // backtrack and remove the queen from the current square
                mat[r][i] = 0;
            }
        }
		return false;
    }
 
    public static void main(String[] args)
    {
        // `mat[][]` keeps track of the position of queens in
        // the current configuration
        Integer[][] mat = new Integer[N][N];
 
        // initialize `mat[][]` by `-`
        for (int i = 0; i < N; i++) {
            Arrays.fill(mat[i], 0);
        }
 
        System.out.println("The All Possible Outputs are: ");
        nQueen(mat, 0);
    }
}