package edu.ncsu.csc216.service_wolf.model.io;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

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
		ServiceGroupWriter.writeServiceGroupsToFile("incident.txt", new ArrayList<>());
	}

}