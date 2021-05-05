
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Greedy_Knapsack {
	public static void main(String[] args) 
	{
		System.out.println("");
	
		int n;
    	Scanner sc=new Scanner(System.in);
    	System.out.println("enter the no. of item =");
    	n=sc.nextInt();
		 Random random = new Random();
    	 int[] weight = new int[n]; //random
         int[] profit= new int[n];
         int W;
        
         System.out.println("capacity=" );
     	W=sc.nextInt();
        
         for (int i = 0; i < n; i++){
             int randomNumber = random.nextInt(100);
             weight[i] = randomNumber;
         }
         System.out.println("wght");
         System.out.println(Arrays.toString(weight));
         
         for (int i = 0; i < n; i++){
             int randomNumber = 100+random.nextInt(100);
             profit[i] = randomNumber;
         }
         System.out.println("benefit");
         System.out.println(Arrays.toString(profit));
         
		
	
    	
	int object = profit.length; 
	double p_w[]=new double[object];
	for(int i=0;i<object;i++)
		{
		p_w[i]=(double)profit[i]/(double)weight[i];  //profit per wght
		}
	
	
	for(int i=0;i<object-1;i++)
	{
		for(int j=i+1;j<object;j++)
		{
		if(p_w[i]<p_w[j])
		{
		double temp=p_w[j];
		p_w[j]=p_w[i];
		p_w[i]=temp;
	
		int temp1=profit[j];
		profit[j]=profit[i];
		profit[i]=temp1;
	
		int temp2=weight[j];
		weight[j]=weight[i];
		weight[i]=temp2;
		}
		}
	}
	int k=0;
	double sum=0;
	System.out.println();
	while(W>0)
	{
	if(weight[k]<W)
	{
	sum+=1*profit[k];
	W=W-weight[k];
	}
	else
	{
	double x4=W*profit[k];
	double x5=weight[k];
	double x6=x4/x5;
	double fraction= ((double)W / (double)weight[k]);
    System.out.println(fraction);
	sum=sum+x6;
	W=0;
	}
	k++;
	}
	System.out.println(sum);
	}
	}