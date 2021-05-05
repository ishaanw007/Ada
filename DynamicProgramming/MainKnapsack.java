package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ObjectKnapsack> list = new ArrayList<>();
		Integer capacity = 8;
		//Profit Weight
		list.add(new ObjectKnapsack(2,3));
		list.add(new ObjectKnapsack(3,4));
		list.add(new ObjectKnapsack(1,6));
		list.add(new ObjectKnapsack(4,5));
		Collections.sort(list, new ComparatorKnapsack());
		System.out.println(list);
		Integer maxProfit = knapSack(list,capacity);
		System.out.println("The Max Profit is: "+maxProfit);
	}
	public static Integer knapSack(List<ObjectKnapsack> list, Integer capacity) {
		Integer[][] dynamicProgramming = new Integer[list.size()+1][capacity+1];
		int i,w;
        for (i = 0; i <= list.size(); i++) 
        {
            for (w = 0; w <= capacity; w++) 
            {
                if (i == 0 || w == 0)
                	dynamicProgramming[i][w] = 0;
                else if (list.get(i-1).getWeight() <= w)
                	dynamicProgramming[i][w] = Math.max(list.get(i-1).getProfit()
                         + dynamicProgramming[i - 1][w - list.get(i-1).getWeight()],
                         dynamicProgramming[i - 1][w] );
                else
                	dynamicProgramming[i][w] = dynamicProgramming[i - 1][w];
            }
        }
        int result = dynamicProgramming[list.size()][capacity]; 
//        System.out.println(result); 
        System.out.println("Profit --> Weight");
        w = capacity; 
        for (i = list.size(); i > 0 && result > 0; i--) { 
  
            if (result == dynamicProgramming[i - 1][w]) 
                continue; 
            else { 
  
                System.out.println(list.get(i-1).getProfit()+" --> "+list.get(i-1).getWeight() + " Selected"); 
                result = result - list.get(i-1).getProfit(); 
                w = w - list.get(i-1).getWeight(); 
            } 
        }
//        System.out.println();
        return dynamicProgramming[list.size()][capacity];
	}

}
