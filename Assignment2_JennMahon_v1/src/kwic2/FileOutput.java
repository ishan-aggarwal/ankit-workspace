package kwic2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileOutput implements Output {
	
	public void outputToFile(Alphabatizer aSorter) {
		try {
			PrintWriter pw = new PrintWriter("./kwic_output.txt");
			for (int sortedLineIndex = 0; sortedLineIndex < aSorter.sortedLinesSize(); sortedLineIndex++) {
				String line = aSorter.getSortedLineAt(sortedLineIndex);
				pw.write(line + "\n");
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
