package kwic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NoStopWordShift implements CircularShifter {
	LineStorage lineStorage;
	ArrayList<String> shiftedLines;

	public NoStopWordShift() {
		shiftedLines = new ArrayList<String>();
	}

	@Override
	public int linesSize() {
		return shiftedLines.size();
	}

	@Override
	public String shiftedLineAtIndex(int shiftedLineIndex) {
		return shiftedLines.get(shiftedLineIndex);
	}

	@Override
	public void shiftALine(LineStorage lineStorage, String stopWords) {
		this.lineStorage = lineStorage;

		for (int lineIndex = 0; lineIndex < lineStorage.numberOfLines(); lineIndex++) {
			String line = lineStorage.getLineAtIndex(lineIndex);
			shiftedLines.addAll(shiftWords(line));
		}
	}

	private ArrayList<String> shiftWords(String line) {
		ArrayList<String> rotatedLines = new ArrayList<String>();
		String[] words = line.split("\\s+");
		List<String> wordsList = Arrays.asList(words);

		for (int wordsListIndex = 0; wordsListIndex < wordsList.size(); wordsListIndex++) {
			Collections.rotate(wordsList, -1);
			rotatedLines.add(convertToString(wordsList));
		}
		return rotatedLines;
	}

	private String convertToString(List<String> wordsList) {
		String rotatedString = String.join(" ", wordsList);
		return rotatedString;
	}
}
