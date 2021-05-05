package DynamicProgramming;

public class ObjectKnapsack {
	private Integer profit;
	private Integer weight;
	public ObjectKnapsack(Integer profit, Integer weight) {
		super();
		this.weight = weight;
		this.profit = profit;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getProfit() {
		return profit;
	}
	public void setProfit(Integer profit) {
		this.profit = profit;
	}
	@Override
	public String toString() {
		return "ObjectKnapsack [profit=" + profit + ", weight=" + weight + "]";
	}
}
