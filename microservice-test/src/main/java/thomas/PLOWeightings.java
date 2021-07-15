package thomas;

import java.util.Scanner;

public class PLOWeightings {
	public static final String[] ProgLearningOutcomes = { "Business knowledge", "Problem solving", "Business communication",
			"Teamwork", "Responsible business practice", "Global and cultural competence", "Leadership development", };

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the teaching period: ");
		String teachPeriod = input.nextLine();

		System.out.print("Enter the course code: ");
		String courseCode = input.nextLine();

		System.out.print("How many assessment items are there? ");
		int items = input.nextInt();
		System.out.println();
		String[] arrayAssessmentTask = new String[items];
		int[] arrayAssessmentWeight = new int[items];

		for (int i = 1; i <= items; i++) {
			input.nextLine();
			System.out.print("What is assessment task " + "#" + (i) + " called? ");
			String assessmentTask = input.nextLine();
			arrayAssessmentTask[i - 1] = assessmentTask;
			System.out.print("Enter the weighting of " + arrayAssessmentTask[i - 1] + ": ");
			arrayAssessmentWeight[i - 1] = input.nextInt();
			System.out.println();
		}


		int[] ploWeights = new int[ProgLearningOutcomes.length];
		int[][] userInput = new int[ProgLearningOutcomes.length][items];
		for(int i = 1; i<= ProgLearningOutcomes.length; i++) {
			int sum = 0;
			for(int j = 0; j< items;j++) {

				System.out.print("How many times is PLO " + i+" mapped to "+ arrayAssessmentTask[j] +"? ");
				userInput[i-1][j]= input.nextInt();

				sum = sum + (userInput[i-1][j]*arrayAssessmentWeight[j]);
			}
			ploWeights[i-1] = sum;
			System.out.println();
		}

		System.out.println(teachPeriod +" - "  + courseCode +" PLO Weightings");
		System.out.println("--------------------------------");

		int totalPloSum = 0;
		for(int i = 1; i <= ProgLearningOutcomes.length; i++) {
			totalPloSum += ploWeights[i-1];
		}

		System.out.format("%-40s %s\n", "PLO", "Weighting (%)");
		System.out.println("----------------------------------------------------------------");
		for (int i = 1; i <= ProgLearningOutcomes.length; i++) {
			String s1 = "PLO " + i + ": " + ProgLearningOutcomes[i - 1];
			double weight = ((ploWeights[i - 1] * 100.0) / totalPloSum);

			if (weight == 0.0) {
				System.out.format("%-40s %7s\n", s1, (int) ploWeights[i - 1]);
			} else {
				System.out.format("%-40s %10s\n", s1, Math.round(weight * 100.0) / 100.0);
			}
		}
	}
}