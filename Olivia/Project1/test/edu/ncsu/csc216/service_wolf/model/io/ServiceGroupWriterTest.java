package edu.ncsu.csc216.service_wolf.model.io;

import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

/**
 * @author olivialongfellow
 *
 */
public class ServiceGroupWriterTest {
	/**
	 * Tests serviceGroupWriter() ().
	 */
	@Test
	public void testServiceGroupWriter() {
		ServiceGroupWriter groupWriter = new ServiceGroupWriter();
		assertNotNull(groupWriter);
	}

	/**
	 * Tests writeServiceGroupsToFile() ().
	 */
	@Test
	public void testWriteServiceGroupsToFile() {
		ArrayList<ServiceGroup> serviceGroups = ServiceGroupsReader.readServiceGroupsFile("ts-test-files/" +"incidents1.txt");
		ServiceGroupWriter.writeServiceGroupsToFile("ts-test-files/" +"incident.txt", serviceGroups);
		Assert.assertTrue(!serviceGroups.isEmpty());
	}

}