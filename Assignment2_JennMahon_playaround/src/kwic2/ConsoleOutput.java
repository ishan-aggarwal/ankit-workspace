package kwic2;

public class ConsoleOutput implements Output {

	@Override
	public void output(Alphabatizer aSorter) {
		for (int sortedLineIndex = 0; sortedLineIndex < aSorter.sortedLinesSize(); sortedLineIndex++) {
			String line = aSorter.getSortedLineAt(sortedLineIndex);
			System.out.println(line + "\n");
		}
	}

}
