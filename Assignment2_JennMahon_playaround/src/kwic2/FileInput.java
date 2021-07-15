package kwic2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInput implements Input {

	@Override
	public void readInput(LineStorage lineStorage) {
		try (BufferedReader bR = new BufferedReader(new FileReader("./input/inputtext"))) {
			String line = bR.readLine().replaceAll("[:;,?!.()]", "");
			while (line != null) {
				lineStorage.addLine(line);
				line = bR.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
