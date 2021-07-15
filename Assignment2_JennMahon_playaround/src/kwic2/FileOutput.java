package kwic2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileOutput implements Output {

	@Override
	public void output(Alphabatizer aSorter) {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("./kwic_output.txt"), true));
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
