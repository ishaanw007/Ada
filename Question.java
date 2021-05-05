
import java.util.Random;
import java.util.Scanner;
public class 	Question {
   public static void main(String[] args) {
	  
	   int low =0;
	   int high=999;
      Random rd = new Random(); // creating Random object
      int[] arr = new int[100];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = rd.nextInt(high-low)+low; // storing random integers in an array
         System.out.println(arr[i]); // printing each array element
      }
      System.out.println("enter a number from a list");
      Scanner sc=new Scanner (System.in);
      int key=sc.nextInt();
      
      int min =0;
	  int max=99;

	  boolean found=true;
	  int count=0;
	  while(found) {
	  count++;
	  Random rdx = new Random();
	  int result = rdx.nextInt(max-min) + min;
	  
     System.out.println(result);
	  
	  if (arr[result]==key) {

		 found=false; 
		  
	  }
	  else {
		found=true;
		 
	  }
	  }
	  System.out.println("Found " + key + " in " + count + " times" );
	   

   }
   }
