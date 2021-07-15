package edu.ncsu.csc216.service_wolf.model.io;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

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
	}

	/**
	 * Receives a String with the file name to read from. If the file cannot be
	 * loaded because it doesnâ€™t exist, the method will throw an
	 * IllegalArgumentException with the message â€œUnable to load file.â€� Any invalid
	 * service groups or incident (i.e., they cannot be constructed, information is
	 * missing, or there is too much info for the item) are ignored.
	 * 
	 * @param input file to read from
	 * @return a list of valid service groups
	 */
	public static ArrayList<ServiceGroup> readServiceGroupsFile(String input) {
		File file = new File("resources/"+input);   
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String st; 
			  while ((st = br.readLine()) != null)  {
				 // System.out.println(st); 
				  sb.append(st).append("\n");
			  }
			  String split[] = sb.toString().split("\\r?\\n?[#]");
			  //System.out.println(split);
			  Arrays.stream(split)
			  .forEach(System.out::println);
			  String sg = split[1];
			  
			  System.out.println();
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		} 
		return null;
	}
	public static void main(String[] args) {
		readServiceGroupsFile("incidents1.txt");
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
