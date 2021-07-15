package assignment;

public class ContiguousCombinationSum {

	public static int findContiguousCombinationSum(String input) {
		int length = input.length();
		int sum[] = new int[length];
		sum[0] = input.charAt(0) - '0';
		int result = sum[0];
		for (int index = 1; index < length; index++) {
			int number = input.charAt(index) - '0';
			sum[index] = (index + 1) * number + 10 * sum[index - 1];
			result = result+ sum[index];
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(findContiguousCombinationSum("321"));
		System.out.println(findContiguousCombinationSum("12"));
		
	}
}