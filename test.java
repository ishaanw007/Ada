
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class test {
	public static void main(String[] args) throws IOException {
		Random random = new Random();
		int[] arr = new int[99];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(1000);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int choosedNumber = 0;
		System.out.println();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean isChoosedRight = true;
		while (isChoosedRight) {
			try {
				System.out.print("enter a number: ");
				choosedNumber = Integer.parseInt(br.readLine());
				
				for (int element : arr) {
					if (element == choosedNumber) {
						isChoosedRight = false;
						break;
					} else {
						isChoosedRight = true;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception'
				System.out.println("Please choose approprotate no");
				isChoosedRight = true;
			}
		}

		int count = 0;
		boolean isFound = true;
		while (isFound) {
			count++;
			int randomIndex = random.nextInt(99);
			System.out.println("Index "+ randomIndex);
			if (choosedNumber == arr[randomIndex]) {
				isFound = false;
			}else {
				isFound = true;
			}
		}
		
		System.out.println("Found " + choosedNumber + " at " + count + " interval" );

	}
}