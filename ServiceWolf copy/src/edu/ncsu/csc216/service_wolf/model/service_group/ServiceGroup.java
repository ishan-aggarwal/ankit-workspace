package edu.ncsu.csc216.service_wolf.model.service_group;

import java.util.List;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

public class ServiceGroup {

	private String serviceGroupName;
	
	public ServiceGroup(String validFile ) {
	}
	
	public void setIncidentCounter() {
	}
	
	public void setServiceGroupName(String serviceGroupName) {
	}
	
	public String getServiceGroupName() {
		return null;
	}
	
	public void addIncident(Incident incident) {
	}
	
	public List<Incident> getIncidents() {
		return null;
	}
	
	public Incident getIncidentById(int id) {
		return null;
	}
	
	public void executeCommand(int id, Command c) {
	}
	
	public void deleteIncidentById(int id) {
	}

}
