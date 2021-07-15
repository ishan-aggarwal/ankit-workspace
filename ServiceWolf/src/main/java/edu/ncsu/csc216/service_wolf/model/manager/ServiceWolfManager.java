/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;

import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;
import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

import java.util.List;

/**
 * @author olivialongfellow
 *
 */
public class ServiceWolfManager {

	private List<ServiceGroup> serviceGroups;
	private ServiceGroup currentServiceGroup;

	/**
	 * default constructor
	 */
	private ServiceWolfManager() {
	}

	public static ServiceWolfManager getInstance() {
		return null;
	}

	/**
	 *
	 * @param fileName
	 */
	public void saveToFile(String fileName) {
	}

	/**
	 *
	 * @param fileName
	 */
	public void loadFromFile(String fileName) {
	}

	/**
	 *
	 * @return String array
	 */
	public String[][] getIncidentsAsArray() {
		return null;
	}

	/**
	 *
	 * @param id
	 * @return Incident
	 */
	 public Incident getIncidentById(int id) {
		 return null;
	 }

	/**
	 *
	 * @param id
	 * @param command
	 */
	 public void executeCommand(int id, Command command) {
	 }

	/**
	 *
	 * @param id
	 */
	 public void deleteIncidentById(int id) { 
	 }

	/**
	 *
	 * @param title
	 * @param caller
	 * @param message
	 */
	 public void addIncidentToServiceGroup(String title, String caller, String message) {
	 }

	/**
	 *
	 * @param serviceGroupName
	 */
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

	/**
	 *
	 * @param updateName
	 */
	 public void editServiceGroup(String updateName) {
	 }

	/**
	 *
	 * @param serviceGroup
	 */
	 private void addServiceGroupToListByName(ServiceGroup serviceGroup) {
	 }

	/**
	 *
	 * @param serviceGroupName
	 */
	 public void addServiceGroup(String serviceGroupName) {
	 }

	/**
	 *
	 * @param input
	 */
	 public void checkDuplicateServiceName(String input) {
	 }

	/**
	 * method deleteServiceGroup
	 */
	public void deleteServiceGroup() {
	 }

	/**
	 * method resetManager
	 */
	protected void resetManager() {
	 }
	 
}
