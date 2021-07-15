package kwic2;

public interface CircularShifter {
	 int linesSize();
	 String shiftedLineAtIndex(int shiftedLineIndex);
	 void shiftALine(LineStorage lineStorage, String stopWords);
}
