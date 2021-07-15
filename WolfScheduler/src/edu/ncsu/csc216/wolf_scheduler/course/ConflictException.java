
package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * A custom checked exception specifically for conflicts. The ConflictException
 * class extends Exception, which implements the Serializable interface.
 * 
 * @author Olivia Longfellow
 *
 */
public class ConflictException extends Exception {
	/** ID used for serialization. */
	private static final long serialVersionUID = 1L;

	/**
	 * A parameterized constructor with a String specifying a message for the
	 * Exception object. The message is passed to the parent’s constructor
	 * 
	 * @param message message for exception object
	 *
	 */
	public ConflictException(String message) {
		super(message);
	}

	/**
	 * A parameterless constructor that calls the parameterized constructor with an
	 * author specified default message.
	 *
	 */

	public ConflictException() {
		this("Sample message");
	}
}
