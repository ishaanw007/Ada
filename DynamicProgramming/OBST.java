package DynamicProgramming;

import java.util.Scanner;

public class OBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the Size of Array: ");
		Integer n = input.nextInt();
		Integer[] keys = new Integer[n];
		Integer[] frequency = new Integer[n];
		for(Integer i = 0;i < n;i++) {
			System.out.print("Enter the Key: ");
			keys[i] = input.nextInt();
			System.out.print("Enter the Frequency of the Key: ");
			frequency[i] = input.nextInt();
		}
		System.out.println("The OBST with Minimum Costs: "+optimalBST(keys, frequency, n));
		
//		keys[] = {10, 12, 20}, freq[] = {34, 8, 50}
		
		
	}
	public static Integer optimalBST(Integer[] keys, Integer[] frequency, Integer n) {
		Integer[][] dp = new Integer[n][n];
		
//		Partial Sum Array
		Integer psa[] = new Integer[n];
		psa[0] = frequency[0];
		
		for(Integer i = 1;i < n ;i++) {
			psa[i] = psa[i-1] + frequency[i];
		}
		
		for(Integer g = 0;g < dp.length;g++) {
			for(int i = 0,j = g;j < n;i++,j++) {
				if(g == 0) {
					dp[i][j] = frequency[i];
				}else if(g == 1) {
					Integer f1 = frequency[i];
					Integer f2 = frequency[j];
					dp[i][j] = Math.min(f1 + 2 * f2, f1 * 2 + f2);
				}else {
					Integer min = Integer.MAX_VALUE;
					Integer fs = 0;
//					for(Integer x = i; x <= j;x++) {
//						 fs += frequency[x];
//					}
					fs = psa[j] - (i == 0? 0:psa[i-1]);
					
					for(Integer k = i;k <= j;k++) {
						Integer left = k== i? 0:dp[i][k-1];
						Integer right = k==j? 0: dp[k+1][j];
						
						
						if(left + right + fs < min) {
							min = left + right + fs;
						}
					}
					dp[i][j] = min;
				}
			}
		}
		return dp[0][n-1];
	}

}
