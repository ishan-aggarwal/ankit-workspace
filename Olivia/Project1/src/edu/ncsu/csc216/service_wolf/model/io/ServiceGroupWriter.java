package edu.ncsu.csc216.service_wolf.model.io;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

/**
 * Writes the given list of ServiceGroups to the file name provided.
 * 
 * @author Olivia Longfellow
 */
public class ServiceGroupWriter {

	/**
	 * ServiceGroupWriter default constructor
	 */
	public ServiceGroupWriter() {
		//default constructor
	}

	/**
	 * Receives a String with the file name to write to and a List of ServiceGroups
	 * to write to file. Uses Incident’s toString() method to create the properly
	 * formatted output for an Incident. If there are any errors or exceptions, an
	 * IllegalArgumentException is thrown with the message “Unable to save file.
	 *
	 * @param input input from file name
	 * @param list  of ServiceGroups to write to file.
	 */
	public static void writeServiceGroupsToFile(String input, List<ServiceGroup> list) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(input))) {
			StringBuilder sb = new StringBuilder();

			for (ServiceGroup serviceGroup : list) {

				sb.append("# ").append(serviceGroup.getServiceGroupName()).append("\r\n");
				for (Incident t : serviceGroup.getIncidents()) {

					sb.append("* ");
					sb.append(t.getId()).append(",");
					sb.append(t.getState()).append(",");
					sb.append(t.getTitle()).append(",");
					sb.append(t.getCaller()).append(",");
					sb.append(t.getReopenCount()).append(",");
					sb.append(t.getOwner()).append(",");
					sb.append(t.getStatusDetails()).append("\r\n");

					for (String log : t.incidentLog) {
						sb.append("- ").append(log).append("\r\n");
					}
				}
			}

			bw.write(sb.toString());
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Unable to write in a file.");
		}
	}
}