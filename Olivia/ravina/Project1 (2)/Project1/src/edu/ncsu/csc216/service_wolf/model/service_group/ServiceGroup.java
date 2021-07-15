package edu.ncsu.csc216.service_wolf.model.service_group;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

/**
 * Concrete class that maintains its name and a list of Incidents in the service
 * group.
 *
 * @author Olivia Longfellow
 *
 */
public class ServiceGroup {

	/** Set the service group name */
	@SuppressWarnings("unused")
	private String serviceGroupName;

	/** Create a new empty List */
	@SuppressWarnings("unused")
	private List<Incident> incidents;

	/** Implements the Singleton design pattern */
	@SuppressWarnings("unused")
	private static ServiceGroup singleton;

	/**
	 * Creates constructor for ServiceGroup.
	 *
	 * @param serviceGroupName
	 */
	public ServiceGroup(String serviceGroupName) {
		System.out.println(serviceGroupName);
		if (null == serviceGroupName) {
			throw new IllegalArgumentException("Invalid service group name");
		}
		this.serviceGroupName = serviceGroupName;
		incidents = new ArrayList<>();
	}

	/**
	 * set the counter for the Incident instances to the value of the maximum id in
	 * the list of Incidents for the service group + 1.
	 */
	public void setIncidentCounter() {
		int maxId = this.incidents.stream().mapToInt(incident -> incident.getId()).max().orElse(0);
		Incident.counter = maxId + 1;
	}

	/**
	 * Sets the service group names
	 *
	 * @param serviceGroupName name of service group
	 */
	public void setServiceGroupName(String serviceGroupName) {
		this.serviceGroupName = serviceGroupName;
	}

	/**
	 * Returns the name of the service group.
	 *
	 * @return returns the name of the service group.
	 */
	public String getServiceGroupName() {
		return this.serviceGroupName;
	}

	/**
	 * Adds the incident to the list in sorted order by id
	 *
	 * @param incident incident managed by system
	 */
	public void addIncident(Incident incident) {

		if (incident == null
				|| this.incidents.stream().map(inc -> inc.getId()).anyMatch(id -> id == incident.getId())) {
			throw new IllegalArgumentException("Incident cannot be created.");
		}

		this.incidents.add(incident);
		this.incidents = this.incidents.stream().sorted(Comparator.comparing(Incident::getId))
				.collect(Collectors.toList());
	}

	/**
	 * Returns the List of Incidents.
	 *
	 * @return returns the List of Incidents.
	 */
	public List<Incident> getIncidents() {
		return this.incidents;
	}

	/**
	 * Returns the Incident in the list with the given id. If there is no Incident
	 * with that id, the method returns null
	 *
	 * @param id id of Incident
	 * @return returns the Incident in the list with the given id
	 */
	public Incident getIncidentById(int id) {
		
		for(Incident incident2:this.incidents) {
			if(id == incident2.getId()) {
				return incident2;
			}
		}
		return null;
	}

	/**
	 * Will find the Incident with the given id and update it by passing in the
	 * given Command.
	 *
	 * @param id id of incident
	 * @param c  command being passed in
	 */
	public void executeCommand(int id, Command c) {

		Incident incidentById = this.incidents.stream().filter(incident -> incident.getId() == id).findFirst()
				.orElseGet(null);
		if (null != incidentById) {
			incidentById.update(c);
		}
	}

	/**
	 * Removes the Incident with the given id from the list.
	 *
	 * @param id id of Incident
	 */
	public void deleteIncidentById(int id) {

		Incident incidentById = this.incidents.stream().filter(incident -> incident.getId() == id).findFirst()
				.orElseGet(null);
		if (null != incidentById) {
			this.incidents.remove(incidentById);
		}
	}

}