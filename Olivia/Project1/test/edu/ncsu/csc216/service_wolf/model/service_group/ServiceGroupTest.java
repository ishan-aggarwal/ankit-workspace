package edu.ncsu.csc216.service_wolf.model.service_group;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceGroupTest {
	
	ServiceGroup group;
	
	@Before
	public void setUp() {
		group = new ServiceGroup("testServiceGroup");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testServiceGroupForNull() {
		new ServiceGroup(null);
	}
	
	@Test
	public void testAddIncident() {
		group.addIncident(new Incident("testTitle", "testCaller", "testMessage"));
		assertEquals(1, group.getIncidents().size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddIncidentForNull() {
		group.addIncident(null);
	}
	
	@Test
	public void testGetIncidentById() {
		group.addIncident(new Incident("testTitle", "testCaller", "testMessage"));
		int id = group.getIncidents().get(0).getId();
		Incident incident = group.getIncidentById(id);
		assertEquals("testTitle", incident.getTitle());
		assertEquals("testCaller", incident.getCaller());
		assertEquals("testMessage", incident.incidentLog.get(0));
	}
	
	@Test
	public void testGetIncidentByIdForNull() {
		assertNull(group.getIncidentById(2));
	}
	
	@Test
	public void testExecuteCommand() {
		group.addIncident(new Incident("testTitlee", "testCallerr", "testMessagee"));
		int id = group.getIncidents().get(0).getId();
		group.executeCommand(id, new Command(CommandValue.ASSIGN, "commandInformation", "commandMessage"));
		assertNotNull(id);
	}

}
