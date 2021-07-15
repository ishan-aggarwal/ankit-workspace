package edu.ncsu.csc216.service_wolf.model.io;

import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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
		ArrayList<ServiceGroup> serviceGroups = ServiceGroupsReader.readServiceGroupsFile("ts-test-files/" +"incidents1.txt");
		Assert.assertTrue(!serviceGroups.isEmpty());
	}
}