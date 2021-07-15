package edu.ncsu.csc216.service_wolf.model.command;

/**
 * The Command class creates objects that encapsulate user actions (or
 * transitions) that cause the state of a Incident to update
 * 
 * @author Oliva Longfellow
 */
public class Command {

	/** Command Information. Empty string or non null. */
	private String commandInformation;

	/** A Command MUST have a commandMessage. Command message. */
	@SuppressWarnings("unused")
	private String commandMessage;

	/**
	 * A Command MUST have a CommandValue of ASSIGN, HOLD, INVESTIGATE, RESOLVE,
	 * REOPEN, CANCEL
	 */
	@SuppressWarnings("unused")
	private CommandValue command;

	/**
	 * Creates Constructor for Command.
	 * 
	 * @param command            command cause the state of a Incident to update.
	 *                           Contains xCommandValue command, String
	 *                           commandInformation, String commandMessage.
	 * @param commandInformation Command Information. Empty string or non null
	 * @param commandMessage     A Command MUST have a commandMessage. Command
	 *                           message.
	 */
	public Command(CommandValue command, String commandInformation, String commandMessage) {
		if (command == null) {
			throw new IllegalArgumentException("The Command MUST have a CommandValue");
		}
		if (commandMessage == null || commandMessage.length() == 0) {
			throw new IllegalArgumentException("The Command MUST have a commandMessage");
		}
		if ((command == CommandValue.ASSIGN || command == CommandValue.HOLD || command == CommandValue.RESOLVE
				|| command == CommandValue.CANCEL)
				&& (commandInformation == null || commandInformation.length() == 0)) {
			throw new IllegalArgumentException("These commands require an additional piece of information");
		}
		if ((command == CommandValue.INVESTIGATE || command == CommandValue.REOPEN) && commandInformation != null) {
			throw new IllegalArgumentException("These commands do NOT require an additional piece of information");
		}
		this.commandInformation = commandInformation;
		this.commandMessage = commandMessage;
		this.command = command;
	}

	/**
	 * Return the command information
	 *
	 * @return the command information
	 */
	public String getCommandInformation() {
		return commandInformation;
	}

	/**
	 * Returns the Command Value.
	 *
	 * @return CommandValue the value of the Command
	 */
	public CommandValue getCommand() {
		return command;
	}

	/**
	 * Return the command message
	 * 
	 * @return the command message
	 */
	public String getCommandMessage() {
		return commandMessage;
	}

	/**
	 * Enumeration code with the fields of Command
	 */
	public enum CommandValue {
		ASSIGN, HOLD, INVESTIGATE, RESOLVE, REOPEN, CANCEL;
	}
}
