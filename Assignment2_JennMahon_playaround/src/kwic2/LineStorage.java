package kwic2;

import java.util.ArrayList;

public class LineStorage {
	private ArrayList<String> lines;

	public LineStorage() {
		lines = new ArrayList<String>();
	}

	public void addLine(String line) {
		lines.add(line);
	}

	public String getLineAtIndex(int lineIndex) {
		return lines.get(lineIndex);
	}

	public int numberOfLines() {
		return lines.size();
	}

}
