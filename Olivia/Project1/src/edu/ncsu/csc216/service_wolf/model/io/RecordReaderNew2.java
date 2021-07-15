package edu.ncsu.csc216.service_wolf.model.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RecordReaderNew2 {

	public static void main(String[] args) throws IOException {
		String input = "D:\\ide-code-workspace\\Olivia\\Project1\\ts-test-files\\parse.txt";
		File file = new File(input);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		int counter = 0;
		Map<String, String> record = null;
		StringBuilder request = null;
		while ((line = br.readLine()) != null) {
			MapEventConverter convertToMapEvent = new MapEventConverter(line, counter, record, request).invoke();
			counter = convertToMapEvent.getCounter();
			record = convertToMapEvent.getRecord();
			request = convertToMapEvent.getRequest();
		}
	}


}