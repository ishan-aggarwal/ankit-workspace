/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;

import edu.ncsu.csc216.service_wolf.model.io.ServiceGroupsReader;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author olivialongfellow
 *
 */
public class ServiceWolfManagerTest {

	//creating singleton instance to test
	ServiceWolfManager serviceWolfManager;

	@Before
	public void setUp() {
		this.loadData();
	}

	private void loadData() {
		serviceWolfManager = ServiceWolfManager.getInstance();
		ArrayList<ServiceGroup> serviceGroups = ServiceGroupsReader.readServiceGroupsFile("ts-test-files/" +"incidents1.txt");
		serviceWolfManager.setServiceGroups(serviceGroups);
		serviceWolfManager.setCurrentServiceGroup(serviceGroups.get(0));

	}

	/**
	 * Tests getInstance().
	 */
	@Test
	public void testGetInstance() {
		Assert.assertNotNull(ServiceWolfManager.getInstance());
	}

	/**
	 * Tests saveToFile().
	 */
	@Test
	public void testSaveToFile() {
		serviceWolfManager.saveToFile("incidents.txt");
		Assert.assertNotNull(serviceWolfManager.getCurrentServiceGroup());
	}

	/**
	 * Tests loadFromFile().
	 */
	@Test
	public void testLoadFromFile() {
		serviceWolfManager.loadFromFile("ts-test-files/" +"incidents1.txt");
		Assert.assertNotNull(serviceWolfManager.getCurrentServiceGroup());
	}

	/**
	 * Tests loadServiceGroup().
	 */
	@Test
	public void testLoadServiceGroup() {
		this.serviceWolfManager.loadServiceGroup("testServiceGroup");
		Assert.assertNotNull(this.serviceWolfManager.getServiceGroups());
	}
	
	@Test
	public void testGetIncidentById() {
		this.serviceWolfManager.addServiceGroup("testServiceGroup");
		Assert.assertEquals("testServiceGroup",this.serviceWolfManager.getCurrentServiceGroup().getServiceGroupName());
	}

	/**
	 * Tests getServiceGroupName().
	 */
	@Test
	public void testGetServiceGroupName() {
		Assert.assertNotNull(this.serviceWolfManager.getServiceGroupName());
	}

	/**
	 * Tests getServiceGroupList().
	 */
	@Test
	public void testGetServiceGroupList() {
		Assert.assertNotNull(this.serviceWolfManager.getServiceGroupList());
	}

	/**
	 * Tests clearServiceGroups().
	 */
	@Test
	public void testClearServiceGroups() {
		this.serviceWolfManager.clearServiceGroups();
		Assert.assertTrue(this.serviceWolfManager.getServiceGroups().isEmpty());
		this.loadData();
	}

	/**
	 * Tests editServiceGroup().
	 */
	@Test
	public void testEditServiceGroup() {
		this.serviceWolfManager.editServiceGroup("testServiceGroup1");
		Assert.assertNotNull(this.serviceWolfManager.getServiceGroups());
	}

	/**
	 * Tests addServiceGroup().
	 */
	@Test
	public void testAddServiceGroup() {
		this.serviceWolfManager.addServiceGroup("testServiceGroup2");
		Assert.assertNotNull(this.serviceWolfManager.getServiceGroups());
	}

	/**
	 * Tests checkDuplicateServiceName().
	 */
	@Test
	public void testCheckDuplicateServiceName() {
		this.serviceWolfManager.checkDuplicateServiceName("testServiceGroup1");
		Assert.assertNotNull(this.serviceWolfManager.getServiceGroups());
	}

	/**
	 * Tests getIncidentsAsArray().
	 */
	@Test
	public void testGetIncidentsAsArray() {
		this.serviceWolfManager.addIncidentToServiceGroup("12","test","test");
		Assert.assertNotNull(this.serviceWolfManager.getIncidentsAsArray());
	}



}
