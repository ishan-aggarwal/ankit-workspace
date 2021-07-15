/**
*
*/
package edu.ncsu.csc216.service_wolf.model.incident;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests the Incident class.
 * 
 * @author Olivia Longfellow
 *
 */
public class IncidentTest {
	
	
	/**
	 * Tests update().
	 */
	@Test
	public void testUpdate() {
		Incident incident = new Incident("testTitle", "testCaller", "testMessage");
		incident.update(new Command(CommandValue.ASSIGN, "testInfo", "testMessage"));
		Assert.assertNotNull(incident);
	}

	/**
	 * Tests getIncidentLogMessages().
	 */
	@Test
	public void testGetIncidentLogMessages() {
		Incident incident = new Incident("testTitle", "testCaller", "testMessage");
		Assert.assertTrue(!incident.getIncidentLogMessages().isEmpty());
	}

	/**
	 * Tests Incident().
	 */
	@Test
	public void testIncident() {
		Incident incident = new Incident("testTitle", "testCaller", "testMessage");
		assertNotNull(incident);
		assertEquals("Unowned", incident.getOwner());
		assertEquals("No Staus", incident.getStatusDetails());
		assertEquals("New", incident.getState());
		assertEquals(1, incident.incidentLog.size());
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("testMessage");
		Incident incident2 = new Incident(1, "New", "testTitle", "testCaller", 0, "Unowned",
				"No Staus", list);
		assertEquals(1, incident2.getId());
		assertEquals("New", incident2.getState());
		assertEquals("testTitle", incident2.getTitle());
		assertEquals("testCaller", incident2.getCaller());
		assertEquals(0, incident2.getReopenCount());
		assertEquals("No Staus", incident2.getStatusDetails());
		assertEquals(list.size(), incident2.incidentLog.size());
		
		Incident incident3 = new Incident(1, "Resolved", "testTitle", "testCaller", 0, "Owner",
				"No Staus", list);
		assertEquals(1, incident3.getId());
		assertEquals("Resolved", incident3.getState());
		assertEquals("testTitle", incident3.getTitle());
		assertEquals("testCaller", incident3.getCaller());
		assertEquals(0, incident3.getReopenCount());
		assertEquals("No Staus", incident3.getStatusDetails());
		assertEquals(list.size(), incident3.incidentLog.size());
		
		Incident incident4 = new Incident(1, "In Progress", "testTitle", "testCaller", 0, "Owner",
				"No Staus", list);
		assertEquals(1, incident4.getId());
		assertEquals("In Progress", incident4.getState());
		assertEquals("testTitle", incident4.getTitle());
		assertEquals("testCaller", incident4.getCaller());
		assertEquals(0, incident4.getReopenCount());
		assertEquals("No Staus", incident4.getStatusDetails());
		assertEquals(list.size(), incident4.incidentLog.size());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIncidentForNullInput() {
		new Incident(null, null, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testIncidentForNullEmptyInput() {
		new Incident("", "", "");
	}
	
	@Test
	public void testSetCounter() {
		Incident.setCounter(1);
		assertEquals(1, Incident.counter);
	}

	/**
	 * Tests incrementCounter().
	 */
	@Test
	public void testIncrementCounter() {
		Incident.incrementCounter();
		assertEquals(1, Incident.counter);
	}
}