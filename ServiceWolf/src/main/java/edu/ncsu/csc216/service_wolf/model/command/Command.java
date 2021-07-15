package edu.ncsu.csc216.service_wolf.model.command;

/**
 * Command class
 */
public class Command {

    private String commandInformation;
    private String commandMessage;
    private CommandValue command;

    /**
     * @param command
     * @param commandInformation
     * @param commandMessage
     */
    public Command(CommandValue command, String commandInformation, String commandMessage) {
        if (command == null) {
            throw new IllegalArgumentException("The Command MUST have a CommandValue");
        }
        if (commandMessage == null || commandMessage.length() == 0) {
            throw new IllegalArgumentException("The Command MUST have a commandMessage");
        }
        if ((command == CommandValue.ASSIGN ||
			command == CommandValue.HOLD ||
				command == CommandValue.RESOLVE ||
				command == CommandValue.CANCEL ) &&
				(commandInformation == null || commandInformation.length() == 0)) {
			throw new IllegalArgumentException("These commands require an additional piece of information");
        }
		if ((command == CommandValue.INVESTIGATE ||
				command == CommandValue.REOPEN) && commandInformation != null) {
			throw new IllegalArgumentException("These commands do NOT require an additional piece of information");
		}
        this.commandInformation = commandInformation;
        this.commandMessage = commandMessage;
        this.command = command;
    }

    /**
     * @return CommandValue
     */
    public CommandValue getCommand() {
        return null;
    }

    /**
     * @return String
     */
    public String getCommandInformation() {
        return commandInformation;
    }

    /**
     * @return String
     */
    public String getCommandMessage() {
        return null;
    }

    /**
     * enum
     */
    public enum CommandValue {
        ASSIGN,
        HOLD,
        INVESTIGATE,
        RESOLVE,
        REOPEN,
        CANCEL;
    }
}
