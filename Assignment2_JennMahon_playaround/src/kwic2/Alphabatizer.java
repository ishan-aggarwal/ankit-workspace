package kwic2;

public interface Alphabatizer {
	 void sortByAlpha(CircularShifter aShifter);
	 int sortedLinesSize();
	 String getSortedLineAt(int sortedLineIndex);
}
