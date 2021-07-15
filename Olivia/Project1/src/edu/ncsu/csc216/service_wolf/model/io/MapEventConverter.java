package edu.ncsu.csc216.service_wolf.model.io;

import java.util.HashMap;
import java.util.Map;

public class MapEventConverter {
		private String line;
		private int counter;
		private Map<String, String> record;
		private StringBuilder request;

		public MapEventConverter(String st, int counter, Map<String, String> record, StringBuilder request) {
			this.line = st;
			this.counter = counter;
			this.record = record;
			this.request = request;
		}

		public int getCounter() {
			return counter;
		}

		public Map<String, String> getRecord() {
			return record;
		}

		public StringBuilder getRequest() {
			return request;
		}

		public MapEventConverter invoke() {
			if(counter == 0) {
				counter++;
				if(!line.startsWith("#SENDER")) {
					throw new IllegalArgumentException("Invalid File.");
				}
			} else if(counter == 1) {
				counter++;
				if(!line.startsWith("#FILEOPENDATE")) {
					throw new IllegalArgumentException("Invalid File.");
				}
			} else {
				if (!line.isEmpty()) {
					if (line.startsWith("#Record")) {
						record = new HashMap<>();
						request = new StringBuilder();
						request.append(line).append("\n");;
						//records.add(record);
					} else {
						request.append(line).append("\n");;
						if (line.startsWith("{")) {
							record.put("payload", line);
							System.out.println("Record: "+record);
							System.out.println("Request: "+request.toString());
							//at this point we will have one complete record
							//and the call to begin can be done here.
						} else if (line.contains(":")) {
							String[] splitInputs = line.split(":");
							record.put(splitInputs[0].trim(), splitInputs[1].trim());
						} else {
							String[] splitInputs = line.split(" ");
							if (splitInputs.length == 3) {
								record.put("method", splitInputs[0].trim());
								record.put("uri", splitInputs[1].trim());
								record.put("protocol", splitInputs[2].trim());
							}
						}
					}
				}
			}
			return this;
		}
	}