package DynamicProgramming;

import java.util.Comparator;

public class ComparatorKnapsack implements Comparator<ObjectKnapsack>{

	@Override
	public int compare(ObjectKnapsack o1, ObjectKnapsack o2) {
		// TODO Auto-generated method stub
		return o1.getWeight().compareTo(o2.getWeight());
	}
	

}
