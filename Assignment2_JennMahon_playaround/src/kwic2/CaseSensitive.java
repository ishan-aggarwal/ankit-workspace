package kwic2;

import java.util.ArrayList;
import java.util.Collections;

public class CaseSensitive implements Alphabatizer {
	ArrayList<String> sortedLines;

	public CaseSensitive() {
		sortedLines = new ArrayList<String>();
	}

	@Override
	public void sortByAlpha(CircularShifter aShifter) {
		for (int shiftedLineIndex = 0; shiftedLineIndex < aShifter.linesSize(); shiftedLineIndex++)
			sortedLines.add(aShifter.shiftedLineAtIndex(shiftedLineIndex));

		Collections.sort(sortedLines);

	}

	@Override
	public int sortedLinesSize() {
		return sortedLines.size();
	}

	@Override
	public String getSortedLineAt(int sortedLineIndex) {
		return sortedLines.get(sortedLineIndex);
	}
}
