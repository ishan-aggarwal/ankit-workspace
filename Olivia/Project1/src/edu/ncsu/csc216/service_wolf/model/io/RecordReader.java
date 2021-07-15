package edu.ncsu.csc216.service_wolf.model.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordReader {

	public static void main(String[] args) throws IOException {
		String input = "D:\\ide-code-workspace\\Olivia\\Project1\\ts-test-files\\parse.txt";
		File file = new File(input);
		BufferedReader br = new BufferedReader(new FileReader(file));

		StringBuilder sb = new StringBuilder();
		String st;
		while ((st = br.readLine()) != null) {
			sb.append(st).append("\n");
		}

		String inputStr = sb.toString();

		List<Map<String, String>> records = new ArrayList<>();

		boolean isValid = true;

		String[] inputs = inputStr.split("\n");
		if (!inputs[0].startsWith("#SENDER")) {
			isValid = false;
		}

		if (!inputs[1].startsWith("#FILEOPENDATE")) {
			isValid = false;
		}

		if (!isValid) {
			return;
		}
		
		int size = inputs.length;
		Map<String, String> record = null;

		for (int i = 2; i < size - 1; i++) {
			String str = inputs[i];
			if (!str.isEmpty()) {
				if (str.startsWith("#Record")) {
					record = new HashMap<>();
					records.add(record);
				} else {
					if (str.startsWith("{")) {
						record.put("payload", str);
					} else if (str.contains(":")) {
						String[] splitInputs = str.split(":");
						record.put(splitInputs[0].trim(), splitInputs[1].trim());
					} else {
						String[] splitInputs = str.split(" ");
						if (splitInputs.length == 3) {
							record.put("method", splitInputs[0].trim());
							record.put("uri", splitInputs[1].trim());
							record.put("protocol", splitInputs[2].trim());
						}
					}
				}
			}
		}

		System.out.println("------------------------");
		System.out.println(records.size());
		for (Map<String, String> rec : records) {
			System.out.println(rec.toString());
		}
	}
}