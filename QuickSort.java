
import java.util.Random;
public class QuickSort {
	static int b =0;
	
    int partition(int arr[],int lb ,int ub)
    {
    	int beg=lb;
    	int end = ub;
    	int key=arr[beg];
    	while(beg<end)
    	{
    	while(arr[beg]<=key && beg<ub)
    	{
    		beg++;
    	}
    	while(arr[end]>key   && end>lb)
    	{
    		end--;
    	}
    	if(beg<end)
    	{ 
    		int n =arr[end];
    		arr[end]=arr[beg];
    		arr[beg]=n;
 
    	}
    	
    	}
    	int n =arr[lb];
    	arr[lb]=arr[end];
    	arr[end]=n;
    	return end;
  
    }
	void Sort(int arr[], int lb, int ub) {

		if(lb<ub)
		{
			
			int a = partition(arr,lb,ub);
			Sort(arr,lb,a-1);
			Sort(arr,a+1,ub);
	
		}
     	b++;
	}
	
	
	
	
	static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " -> ");
        System.out.println();
    }
	public static void main(String args[])
	{
		QuickSort qs = new QuickSort();
		Random random = new Random();

        int[] randomNumbers = new int[100];
        int[] ascendingOrderNumbers = new int[100];
        int[] descendingOrderNumbers = new int[100];
        int[] SameNumbers = new int[100];
        // Random Numbers
        for (int i = 0; i < 100; i++){
            int randomNumber = random.nextInt(1000);
            randomNumbers[i] = randomNumber;
        }

        // Ascending Order Numbers
        for (int i = 0; i < 100; i++){
            ascendingOrderNumbers[i] = i;
        }
        for (int i = 0; i < 100; i++){
            descendingOrderNumbers[i] = 100-i;
        }

       
        for (int i = 0; i < 100; i++){
         //   for same no.
            SameNumbers[i] = 7;
        }

        // Time Calculation for Random Numbers
        long startRandom = System.nanoTime();
        qs.Sort(randomNumbers,0,randomNumbers.length-1);
        System.out.println(" Recursive Calls  --> " +b);
	    b=0;
        long endRandom = System.nanoTime();
        long timeRandom = endRandom - startRandom;


        //Time Calculation for Ascending Numbers
        long startAscending = System.nanoTime();
        qs.Sort(ascendingOrderNumbers,0,ascendingOrderNumbers.length-1);
        System.out.println(" Recursive Calls  --> " +b);
	    b=0;
        long endAscending = System.nanoTime();
        long timeAscending = endAscending - startAscending;


        //Time Calculation for Descending Numbers
        long startDescending = System.nanoTime();
        qs.Sort(descendingOrderNumbers,0,descendingOrderNumbers.length-1);
        System.out.println(" Recursive Calls  --> " +b);
	    b=0;
        long endDescending = System.nanoTime();
        long timeDescending = endDescending - startDescending;
        
        long startSame = System.nanoTime();
        qs.Sort(SameNumbers,0,SameNumbers.length-1);
        System.out.println(" Recursive Calls  --> " +b);
	    b=0;
        long endSame = System.nanoTime();
        long timeSame = endSame - startSame;

        printArray(randomNumbers);
        printArray(ascendingOrderNumbers);
       printArray(descendingOrderNumbers);
        printArray(SameNumbers);
        System.out.println("Time for merge Sort for Random Numbers : " +timeRandom);
        
        System.out.println("Time for merge Sort for Ascending Numbers : " +timeAscending);
 
        System.out.println("Time for merge Sort for Descending Numbers : " +timeDescending);

        System.out.println("Time for merge Sort for Same Numbers : " +timeSame);

	}

}