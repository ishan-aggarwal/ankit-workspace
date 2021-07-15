package assignment;
public class ComputeMinimumSteps {

	private static int minimumHopsToReachEnd(int[] inputSteps, int length) {
		int jumps[] = new int[length];
		// Initial condition, end can not be reached
		if (length == 0 || inputSteps[0] == 0)
			return Integer.MAX_VALUE;
		jumps[0] = 0;
		for (int i = 1; i < length; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= j + inputSteps[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		return jumps[length - 1];
	}
	public static void main(String[] args) {
		int inputSteps[] = { 1, 3, 5, 3, 8, 2, 6, 7, 6, 8, 9 };
		System.out.println(minimumHopsToReachEnd(inputSteps, inputSteps.length));
	}
}