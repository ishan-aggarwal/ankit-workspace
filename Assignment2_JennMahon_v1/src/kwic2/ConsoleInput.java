package kwic2;

import java.util.Scanner;

public class ConsoleInput implements Input {

	@SuppressWarnings("resource")
	public void readInput(LineStorage lineStorage) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter lines: (Enter a blank line to stop) ");
		while (true) {
			String line = in.nextLine().replaceAll("[:;,?!.()]", "");
			if (line.trim().compareTo("") != 0) {
				lineStorage.addLine(line);
			} else {
				System.out.print("Do you want to stop? y/n: ");
				line = in.nextLine();
				if (line.toLowerCase().compareTo("y") == 0) {
					break;
				} else {
					System.out.println("Please enter lines: (Enter a blank line to stop)");
				}

			}
		}
	}
}
