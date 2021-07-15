package edu.ncsu.csc216.service_wolf.model.io;

import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

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
	}

}
