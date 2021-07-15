package edu.ncsu.csc216.service_wolf.model.io;

import org.junit.Before;
import org.junit.Test;

/**
 * @author olivialongfellow
 *
 */
public class ServiceGroupsReaderTest {
	
	/**
	 * Tests readServiceGroupsFile().
	 */
	@Test
	public void testReadServiceGroupsFile() {
		ServiceGroupsReader.readServiceGroupsFile("incident.txt");
	}

	/**
	 * Tests processServiceGroup() ().
	 */
	@Test
	public void testProcessServiceGroup() {
	}

	/**
	 * Tests processIncident().
	 */
	@Test
	public void testProcessIncident() {
	}

}