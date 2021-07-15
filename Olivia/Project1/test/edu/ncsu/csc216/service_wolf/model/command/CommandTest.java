package edu.ncsu.csc216.service_wolf.model.command;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Command class
 * 
 * @author olivialongfellow
 *
 */
public class CommandTest {
	/**
	 * Tests Command().
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCommand() {

		new Command(null, "test", "test");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCommandWithoutInformation() {
		new Command(Command.CommandValue.ASSIGN, "", "test");
	}

	@Test
	public void testCommandWithoutInformationSuccess() {
		Command command = new Command(Command.CommandValue.ASSIGN, "test", "test");
		Assert.assertNotNull(command.getCommandMessage());
		Assert.assertNotNull(command.getCommand());
		Assert.assertNotNull(command.getCommandInformation());
	}

}
