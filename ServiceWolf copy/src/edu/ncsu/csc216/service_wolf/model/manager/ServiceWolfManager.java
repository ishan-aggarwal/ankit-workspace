/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * @author olivialongfellow
 *
 */
public class ServiceWolfManager {

	private ServiceWolfManager() {
	}

	public static ServiceWolfManager getInstance() {
		return null;
	}
	
	public void saveToFile(String fileName) {
	}
	
	public void loadFromFile(String fileName) {
	}
	
	public String[][] getIncidentsAsArray() {
		return null;
	}
	
	 public Incident getIncidentById(int id) {
		 return null;
	 }
	 
	 public void executeCommand(int id, Command command) {
	 }
	 
	 public void deleteIncidentById(int id) { 
	 }
	 
	 public void addIncidentToServiceGroup(String title, String caller, String message) {
	 }
	 
	 public void loadServiceGroup(String serviceGroupName) {
	 }

	 public String getServiceGroupName()  {
		 return null;
	 }
	 
	 public String[] getServiceGroupList()  {
		 return null;
	 }
	 
	 public void clearServiceGroups() {
	 }
	 
	 public void editServiceGroup(String updateName) {
	 }
	 
	 private void addServiceGroupToListByName(ServiceGroup serviceGroup) {
	 }
	 
	 public void addServiceGroup(String serviceGroupName) {
	 }

	 public void checkDuplicateServiceName(String input) {
	 }
	 
	 public void deleteServiceGroup() {
	 }
	 
	 protected void resetManager() {
	 }
	 
}
