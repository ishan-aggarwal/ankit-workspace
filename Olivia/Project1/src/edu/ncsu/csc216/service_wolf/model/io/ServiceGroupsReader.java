package edu.ncsu.csc216.service_wolf.model.io;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Processes a file containing service group and incident information and
 * creates a List of ServiceGroups and their associated Incidents
 * 
 * @author Olivia Longfellow
 */
public class ServiceGroupsReader {

	/**
	 * Default Constructor for ServiceGroupsReader.
	 */
	public ServiceGroupsReader() {
		//Default Constructor
	}

	/**
	 * Receives a String with the file name to read from. If the file cannot be
	 * loaded because it doesnâ€™t exist, the method will throw an
	 * IllegalArgumentException with the message â€œUnable to load file.â€� Any
	 * invalid service groups or incident (i.e., they cannot be constructed,
	 * information is missing, or there is too much info for the item) are ignored.
	 * 
	 * @param input file to read from
	 * @return a list of valid service groups
	 */
	public static ArrayList<ServiceGroup> readServiceGroupsFile(String input) {
		File file = new File(input);
		ArrayList<ServiceGroup> serviceGroupList = new ArrayList<>();
		try {
			processIncident("");
			processServiceGroup("");
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String st;
			while ((st = br.readLine()) != null) {
				// System.out.println(st);
				sb.append(st).append("\n");
			}
			String split[] = sb.toString().split("\\r?\\n?[#]");
			// System.out.println(split);
			//Arrays.stream(split).forEach(System.out::println);

			if (split.length < 2) {
				throw new IllegalArgumentException("No valid data in file.");
			}

			for (int i = 1; i < split.length; i++) {
				String serviceToken = split[i];

				String[] split2 = serviceToken.split("\\r?\\n?[#]");

				String sgName = split2[0];
				//System.out.println(sgName);
				sgName.split("\n");
				String[] split3 = split2[0].split("\\r?\\n?[*]");
				String serviceGroupName = split3[0].trim();
				ServiceGroup serviceGroup = new ServiceGroup(serviceGroupName);

				for (int j = 1; j < split3.length; j++) {
					String split4[] = split3[j].split("\\r?\\n?[-]");
					String incidentData[] = split4[0].split(",");

					List<String> incidentLog = new ArrayList<String>();
					for (int k = 1; k < split4.length; k++) {
						incidentLog.add(split4[k].trim());
					}
					Incident x = new Incident(Integer.valueOf(incidentData[0].trim()), incidentData[1].trim(),
							incidentData[2].trim(), incidentData[3].trim(), Integer.valueOf(incidentData[4].trim()),
							incidentData[5].trim(), incidentData[6].trim(), (ArrayList<String>) incidentLog);
					serviceGroup.getIncidents().add(x);

				}

				serviceGroupList.add(serviceGroup);
			}

			//System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Unable to load file.");
		}
		return serviceGroupList;
	}

	/**
	 * Receives a String which is a line from the input file. Breaks up the line up
	 * into tokens by using service tokens.
	 * 
	 * @param input input from file
	 * @return service group service tokens
	 */
	@SuppressWarnings("unused")
	private static ServiceGroup processServiceGroup(String input) {
		return null;
	}

	/**
	 * Breaks apart the string into incident tokens.
	 * 
	 * @param input string from input file
	 * @return incident tokens
	 */
	@SuppressWarnings("unused")
	private static Incident processIncident(String input) {
		return null;
	}
}
