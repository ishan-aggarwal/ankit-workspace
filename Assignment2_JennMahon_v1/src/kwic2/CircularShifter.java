package kwic2;
public interface CircularShifter {

	public int linesSize();

	public String shiftedLineAtIndex(int shiftedLineIndex);

	public void shiftALine(LineStorage lineStorage, String stopWords);

}
