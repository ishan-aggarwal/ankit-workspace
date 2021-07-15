package edu.ncsu.csc216.service_wolf.model.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordReaderNew {

	public static void main(String[] args) throws IOException {
		String input = "D:\\ide-code-workspace\\Olivia\\Project1\\ts-test-files\\parse.txt";
		File file = new File(input);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		int counter = 0;
		Map<String, String> record = null;
		StringBuilder request = null;
		while ((st = br.readLine()) != null) {
			if(counter == 0) {
				counter++;
				if(!st.startsWith("#SENDER")) {
					throw new IllegalArgumentException("Invalid File.");
				}
			} else if(counter == 1) {
				counter++;
				if(!st.startsWith("#FILEOPENDATE")) {
					throw new IllegalArgumentException("Invalid File.");
				}
			} else {
				if (!st.isEmpty()) {
					if (st.startsWith("#Record")) {
						record = new HashMap<>();
						request = new StringBuilder();
						request.append(st).append("\n");;
						//records.add(record);
					} else {
						request.append(st).append("\n");;
						if (st.startsWith("{")) {
							record.put("payload", st);
							System.out.println("Record: "+record);
							System.out.println("Request: "+request.toString());
							//at this point we will have one complete record
							//and the call to begin can be done here.
						} else if (st.contains(":")) {
							String[] splitInputs = st.split(":");
							record.put(splitInputs[0].trim(), splitInputs[1].trim());
						} else {
							String[] splitInputs = st.split(" ");
							if (splitInputs.length == 3) {
								record.put("method", splitInputs[0].trim());
								record.put("uri", splitInputs[1].trim());
								record.put("protocol", splitInputs[2].trim());
							}
						}
					}
				}
			}
		}
	}
}