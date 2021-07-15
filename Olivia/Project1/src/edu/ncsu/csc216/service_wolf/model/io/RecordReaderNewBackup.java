package edu.ncsu.csc216.service_wolf.model.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RecordReaderNewBackup {

	public static void main(String[] args) throws IOException {
		String input = "D:\\ide-code-workspace\\Olivia\\Project1\\ts-test-files\\parse.txt";
		File file = new File(input);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		RecordHolder recordHolder = new RecordHolder();
		while ((line = br.readLine()) != null) {
				convertToMapEventAndCreateTransaction(line, recordHolder);
			}
	}

	private static void convertToMapEventAndCreateTransaction(String line, RecordHolder recordHolder) {
		if(recordHolder.getCounter() == 0) {
			if(!line.startsWith("#SENDER")) {
				throw new IllegalArgumentException("Invalid File.");
			}
			recordHolder.incrementCounter();
		} else if(recordHolder.getCounter() == 1) {
			if(!line.startsWith("#FILEOPENDATE")) {
				throw new IllegalArgumentException("Invalid File.");
			}
			recordHolder.incrementCounter();

		} else {
			if (!line.isEmpty()) {
				if (line.startsWith("#Record")) {
					recordHolder.createNewMapEvent();
					recordHolder.createNewRequest();
					recordHolder.appendRequest(line);
				} else {
					recordHolder.appendRequest(line);
					if (line.startsWith("{")) {
						recordHolder.getMapEvent().put("payload", line);
						System.out.println("Record: "+recordHolder.getMapEvent());
						System.out.println("Request: "+recordHolder.getRequest().toString());
					} else if (line.contains(":")) {
						String[] splitInputs = line.split(":");
						recordHolder.getMapEvent().put(splitInputs[0].trim(), splitInputs[1].trim());
					} else {
						String[] splitInputs = line.split(" ");
						if (splitInputs.length == 3) {
							recordHolder.getMapEvent().put("method", splitInputs[0].trim());
							recordHolder.getMapEvent().put("uri", splitInputs[1].trim());
							recordHolder.getMapEvent().put("protocol", splitInputs[2].trim());
						}
					}
				}
			}
		}
	}
}