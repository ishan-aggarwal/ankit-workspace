/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	}

	/**
	 * Tests loadFromFile().
	 */
	@Test
	public void testLoadFromFile() {
	}

	/**
	 * Tests loadServiceGroup().
	 */
	@Test
	public void testLoadServiceGroup() {
		this.serviceWolfManager.loadServiceGroup("testServiceGroup");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testGetIncidentById() {
		this.serviceWolfManager.addServiceGroup("testServiceGroupP");
		/*
		 * this.serviceWolfManager.addIncidentToServiceGroup("title", "caller",
		 * "message"); this.serviceWolfManager.getIncidentById(1);
		 */
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
	}

	/**
	 * Tests addServiceGroup().
	 */
	@Test
	public void testAddServiceGroup() {
		this.serviceWolfManager.addServiceGroup("testServiceGroup2");
	}

	/**
	 * Tests checkDuplicateServiceName().
	 */
	@Test
	public void testCheckDuplicateServiceName() {
		this.serviceWolfManager.checkDuplicateServiceName("testServiceGroup1");
	}
	
	


}
