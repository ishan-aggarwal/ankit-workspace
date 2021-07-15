package edu.ncsu.csc216.service_wolf.model.service_group;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

import java.util.List;
/**
 * @author olivialongfellow
 *
 */
public class ServiceGroup {

	private String serviceGroupName;
	private List<Incident> incidents;
	private static ServiceGroup singleton;

	/**
	 *
	 * @param validFile
	 */
	public ServiceGroup(String validFile ) {
	}

	/**
	 * method setIncidentCounter
	 */
	public void setIncidentCounter() {
	}

	/**
	 *
	 * @param serviceGroupName
	 */
	public void setServiceGroupName(String serviceGroupName) {
	}

	/**
	 *
	 * @return String
	 */
	public String getServiceGroupName() {
		return null;
	}

	/**
	 *
	 * @param incident
	 */
	public void addIncident(Incident incident) {
	}

	/**
	 *
	 * @return list of incidents
	 */
	public List<Incident> getIncidents() {
		return null;
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	public Incident getIncidentById(int id) {
		return null;
	}

	/**
	 *
	 * @param id
	 * @param c
	 */
	public void executeCommand(int id, Command c) {
	}

	/**
	 *
	 * @param id
	 */
	public void deleteIncidentById(int id) {
	}

}
