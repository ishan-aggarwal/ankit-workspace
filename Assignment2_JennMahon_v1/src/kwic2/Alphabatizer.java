package kwic2;

public interface Alphabatizer {

	public void sortByAlpha(CircularShifter aShifter);

	public int sortedLinesSize();

	public String getSortedLineAt(int sortedLineIndex);
}
