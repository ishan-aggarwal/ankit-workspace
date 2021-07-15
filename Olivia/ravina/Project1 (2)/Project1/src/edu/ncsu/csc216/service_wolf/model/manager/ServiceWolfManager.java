/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.io.ServiceGroupWriter;
import edu.ncsu.csc216.service_wolf.model.io.ServiceGroupsReader;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Concrete class that maintains a list of ServiceGroups, the active or current
 * serviceGroup, and handles events from the GUI
 * 
 * @author olivialongfellow
 *
 */
public class ServiceWolfManager {

	private static ServiceWolfManager singleton;

	/** A list of ServiceGroups */
	private List<ServiceGroup> serviceGroups;

	/** the active or current serviceGroup */
	private ServiceGroup currentServiceGroup;

	/**
	 * default constructor for ServiceWolfManager
	 */
	private ServiceWolfManager() {
		serviceGroups = new ArrayList<>();
	}

	/*
	 * ServiceWolf implements the Singleton Design Pattern. Only one instance of the
	 * ServiceWolfManager can ever be created
	 * 
	 * @return an instance of ServiceWolfManager
	 * 
	 */

	public static ServiceWolfManager getInstance() {
		if(singleton == null) {
			singleton = new ServiceWolfManager();
		}
		return singleton;
	}

	/**
	 * Write the ServiceGroups to the file using the ServiceGroupWriter class
	 * 
	 * @param fileName name of file
	 */
	public void saveToFile(String fileName) {
		if(this.serviceGroups == null || this.serviceGroups.isEmpty()) {
			throw new IllegalArgumentException("Unable to save file.");
		}
		ServiceGroupWriter.writeServiceGroupsToFile(fileName, this.serviceGroups);
	}

	/**
	 * Uses the ServiceGroupReader to read the given fileName. The returned list of
	 * ServiceGroups are added to the serviceGroup field in sorted order by service
	 * group name
	 * 
	 * @param fileName name of file
	 */
	public void loadFromFile(String fileName) {
		ArrayList<ServiceGroup> sGroups = ServiceGroupsReader.readServiceGroupsFile(fileName);
		this.serviceGroups = sGroups.stream()
				.sorted(Comparator.comparing(ServiceGroup::getServiceGroupName))
				.collect(Collectors.toList());
		this.currentServiceGroup = this.serviceGroups.get(0);
	}

	/**
	 * Returns a 2D Object array that is used to populate the IncidentTableModel
	 * with information
	 * 
	 * @return returns a 2D Object array
	 */
	public String[][] getIncidentsAsArray() {
		if(currentServiceGroup != null) {
			List<Incident> incidents = this.currentServiceGroup.getIncidents();
			int rows = incidents.size();
			String output[][] = new String[rows][4];
			for(int i = 0; i<rows ; i++) {
				output[i][0] = String.valueOf(incidents.get(i).getId());
				output[i][1] = incidents.get(i).getState();
				output[i][2] = incidents.get(i).getTitle();
				output[i][3] = incidents.get(i).getStatusDetails();;
			}
			return output;
		}
		return null;
	}

	/**
	 * Returns the Incident in the list with the given id
	 * 
	 * @param id of Incident
	 * @return returns the Incident in the list with the given id
	 */
	public Incident getIncidentById(int id) {
		return  this.currentServiceGroup.getIncidentById(id);
	}

	/**
	 * Find the Incident with the given id and update it by passing in the given
	 * Command.
	 * 
	 * @param id      id of Incident
	 * @param command command cause the state of a Incident to update
	 */
	public void executeCommand(int id, Command command) {
		Incident incidentById = this.currentServiceGroup.getIncidentById(id);
		if(incidentById != null) {
			incidentById.update(command);
		}
	}

	/**
	 * Removes the Incident with the given id from the list.
	 * 
	 * @param id of Incident
	 */
	public void deleteIncidentById(int id) {
		Incident incidentById = this.currentServiceGroup.getIncidentById(id);
		this.currentServiceGroup.getIncidents().remove(incidentById);
	}

	/**
	 * Adds the incident to the list in sorted order by id.
	 * 
	 * @param title   title of the incident as provided by the user on creation.
	 * @param caller  the name of the user who created the incident as provided on
	 *                creation.
	 * @param message the message of the incident
	 */
	public void addIncidentToServiceGroup(String title, String caller, String message) {
		Incident incident = new Incident(title, caller, message);
		this.currentServiceGroup.getIncidents().add(incident);
	}

	/**
	 * The serviceGroup is then loaded as the currentServiceGroup by calling the
	 * loadServiceGroup(String serviceGroupName) method.
	 * 
	 * @param serviceGroupName name of service group
	 */
	public void loadServiceGroup(String serviceGroupName) {

		Optional<ServiceGroup> serviceGroupOptional = this.serviceGroups.stream().filter(serviceGroup -> serviceGroup.getServiceGroupName().equalsIgnoreCase(serviceGroupName))
				.findFirst();
		if(serviceGroupOptional.isPresent()) {
			ServiceGroup current = serviceGroupOptional.get();
			current.setIncidentCounter();
			this.currentServiceGroup = current;
		}
	}

	/**
	 * Returns the service group name
	 * 
	 * @return service group name
	 */
	public String getServiceGroupName() {
		if(this.currentServiceGroup != null) {
			return this.currentServiceGroup.getServiceGroupName();
		}
		return null;
	}

	/**
	 * Returns the service group list.
	 * 
	 * @return service group list.
	 */
	public String[] getServiceGroupList() {
		return this.serviceGroups.stream()
				.map(serviceGroup -> serviceGroup.getServiceGroupName())
				.toArray(String[]::new);
	}

	/**
	 * Resets serviceGroup to an empty array list
	 */
	public void clearServiceGroups() {
		this.serviceGroups = Collections.EMPTY_LIST;
		this.currentServiceGroup = null;
	}

	/**
	 * Updates the currentServiceGroup’s name to the given value
	 * 
	 * @param updateName the current service group's name needed to be updated
	 */
	public void editServiceGroup(String updateName) {

		if(!(updateName == null || updateName.isEmpty()
				|| serviceGroups.stream().map(serviceGroup -> serviceGroup.getServiceGroupName())
				.anyMatch(sGroupName -> sGroupName.equalsIgnoreCase(updateName)))) {

			//delete current service group from list of groups
			serviceGroups.remove(currentServiceGroup);

			//update the service group name
			currentServiceGroup.setServiceGroupName(updateName);

			//add to the list and sort
			addServiceGroupToListByName(currentServiceGroup);

			this.loadServiceGroup(updateName);
		}
	}

	/**
	 * Adds the current service group to the list by name.
	 * 
	 * @param serviceGroup service group name
	 */
	@SuppressWarnings("unused")
	private void addServiceGroupToListByName(ServiceGroup serviceGroup) {
		serviceGroups.stream().forEach(sg -> System.out.println(sg.getIncidents().size()));
		serviceGroups.add(serviceGroup);
		serviceGroups = serviceGroups.stream()
				.sorted(Comparator.comparing(ServiceGroup::getServiceGroupName))
				.collect(Collectors.toList());
	}

	/**
	 * Creates a new ServiceGroup with the given name and adds it to the
	 * serviceGroup list in sorted order by name
	 * 
	 * @param serviceGroupName name of service group
	 */
	public void addServiceGroup(String serviceGroupName) {

		if(serviceGroupName == null || serviceGroupName.isEmpty()
			|| serviceGroups.stream().map(serviceGroup -> serviceGroup.getServiceGroupName())
				.anyMatch(sGroupName -> sGroupName.equalsIgnoreCase(serviceGroupName))) {
			throw new IllegalArgumentException("Invalid service group name.");
		}

		ServiceGroup serviceGroup = new ServiceGroup(serviceGroupName);
		//add to the list
		addServiceGroupToListByName(serviceGroup);

		loadServiceGroup(serviceGroupName);
	}

	/**
	 * Service name is not a duplicate with an existing service group
	 * 
	 * @param serviceGroupName input service group name
	 */
	public void checkDuplicateServiceName(String serviceGroupName) {
		boolean present = serviceGroups.stream().map(serviceGroup -> serviceGroup.getServiceGroupName())
				.anyMatch(sGroupName -> sGroupName.equalsIgnoreCase(serviceGroupName));
		if(present) {
			throw new IllegalArgumentException("Invalid service group name.");
		}
	}

	/**
	 * Deletes the currentServiceGroup.
	 */
	public void deleteServiceGroup() {
		if(this.currentServiceGroup == null) {
			throw new IllegalArgumentException("No service group selected.");
		}
		this.serviceGroups.remove(currentServiceGroup);
		if(serviceGroups.isEmpty()) {
			this.currentServiceGroup = null;
		} else {
			this.currentServiceGroup = serviceGroups.get(0);
		}

	}

	/**
	 * Resets the current manager.
	 */
	protected void resetManager() {
		singleton = null;
	}

	/**
	 * Return Service Groups.
	 * 
	 * @return Service Groups
	 */
	public List<ServiceGroup> getServiceGroups() {
		return serviceGroups;
	}

	/**
	 * Sets service groups.
	 */
	public void setServiceGroups(List<ServiceGroup> serviceGroups) {
		this.serviceGroups = serviceGroups;
	}

	/**
	 * Return current service groups.
	 * 
	 * @return current Service Groups
	 */
	public ServiceGroup getCurrentServiceGroup() {
		return currentServiceGroup;
	}

	/**
	 * Set current service groups
	 */
	public void setCurrentServiceGroup(ServiceGroup currentServiceGroup) {
		this.currentServiceGroup = currentServiceGroup;
	}

}
