/**
 *
 */
package edu.ncsu.csc216.service_wolf.model.incident;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue;

import java.util.ArrayList;

/**
 * Concrete class representing the State Pattern context. An Incident keeps
 * track of all incident information including the current state.
 *
 * @author Olivia Longfellow
 *
 */
public class Incident {

	/** Unique id for an incident. */
	private int incidentId;

	/** Title of the incident as provided by the user on creation */
	private String title;

	/** The name of the user who created the incident as provided on creation */
	private String caller;

	/** The number of times an incident has been reopened */
	private int reopenCount;

	/*
	 * The name of the user who owns and is responsible for resolving the incident
	 */
	private String owner;

	/*
	 * The details about the status of the incident which will take on values of the
	 * on hold reasons, resolution reasons, or cancellation reasons depending on the
	 * current state
	 */
	private String statusDetails;

	// incident states

	/** Current state for the incident of type IncidentState */
	@SuppressWarnings("unused")
	private IncidentState currentState;

	/** Final instance of the CanceledState inner class */
	@SuppressWarnings("unused")
	private IncidentState cancelledState;

	/** Final instance of the InProgressState inner class */
	@SuppressWarnings("unused")
	private IncidentState inProgressState;

	/** Final instance of the ResolvedState inner class */
	@SuppressWarnings("unused")
	private IncidentState resolvedState;

	/** Final instance of the NewState inner class */
	@SuppressWarnings("unused")
	private IncidentState newState;

	/** Final instance of the OnHoldState inner class */
	@SuppressWarnings("unused")
	private IncidentState onHoldState;

	/** String for caller of incident */
	public ArrayList<String> incidentLog;

	/** A constant string for the new stateâ€™s name with the value â€œNewâ€�. */
	public static final String NEW_NAME = "New";

	/*
	 * A constant string for the in progress stateâ€™s name with the value â€œIn
	 * Progressâ€�.
	 */
	public static final String IN_PROGRESS_NAME = "In Progress";

	/**
	 * A constant string for the on hold stateâ€™s name with the value â€œOn
	 * Holdâ€�.
	 */
	public static final String ON_HOLD_NAME = "On Hold";

	/**
	 * A constant string for the resolved stateâ€™s name with the value
	 * â€œResolvedâ€�.
	 */
	public static final String RESOLVED_NAME = "Resolved";

	/**
	 * A constant string for the canceled stateâ€™s name with the value
	 * â€œCanceledâ€�.
	 */
	public static final String CANCELED_NAME = "Canceled";

	/**
	 * A constant string for the canceled stateâ€™s name with the value
	 * â€œCanceledâ€�.
	 */
	public static final String HOLD_AWAITING_CALLER = "Awaiting Caller";

	/**
	 * A constant string for the canceled stateâ€™s name with the value
	 * â€œCanceledâ€�.
	 */
	public static final String HOLD_AWAITING_CHANGE = "Awaiting Chance";

	/**
	 * A constant string for the canceled stateâ€™s name with the value
	 * â€œCanceledâ€�.
	 */
	public static final String HOLD_AWAITING_VENDOR = "Awaiting Vendor";

	/**
	 * A constant string for the canceled stateâ€™s name with the value
	 * â€œCanceledâ€�.
	 */
	public static final String RESOLUTION_PERMANENTLY_SOLVED = "Permanently Solved";

	/**
	 * A constant string for the canceled stateâ€™s name with the value
	 * â€œCanceledâ€�.
	 */
	public static final String RESOLUTION_WORKAROUND = "Workaround";

	/** A constant string for the resolution reason of â€œCaller Closedâ€�. */
	public static final String RESOLUTION_CALLER_CLOSED = "Caller Closed";

	/** A constant string for the cancellation reason of â€œDuplicateâ€�. */
	public static final String CANCELLATION_DUPLICATE = "Duplicate";

	/** A constant string for the cancellation reason of â€œUnnecessaryâ€�. */
	public static final String CANCELLATION_UNNECESSARY = "Unnecessary";

	/** A constant string for the cancellation reason of â€œNot an Incidentâ€�. */
	public static final String CANCELLATION_NOT_AN_INCIDENT = "Not an Incident";

	/** A constant string for the cancellation reason of â€œCaller Cancelledâ€�. */
	public static final String CANCELLATION_CALLER_CANCELLED = "Caller Canceled";

	/** A constant string that represents an unowned incident */
	public static final String UNOWNED = "Unowned";

	/** A constant string that represents an incident with no status reasons. */
	public static final String NO_STATUS = "No Staus";

	/** incremented using Incident.incrementCounter() */
	public static int counter;

	/**
	 * Constructs a Incident from the provided title, caller, and message
	 *
	 * @param title   title of the incident as provided by the user on creation.
	 * @param caller  the name of the user who created the incident as provided on
	 *                creation
	 * @param message the message of incident
	 */
	public Incident(String title, String caller, String message) {
		if (title == null || caller == null || message == null || title.isEmpty() || caller.isEmpty()
				|| message.isEmpty()) {
			throw new IllegalArgumentException("Incident cannot be created..");
		}
		this.incidentId = counter;
		incrementCounter();
		this.title = title;
		this.caller = caller;
		NewState newState = this.new NewState();
		this.currentState = newState;
		this.owner = UNOWNED;
		this.statusDetails = NO_STATUS;
		this.incidentLog = new ArrayList<String>();
		this.incidentLog.add(message);
	}

	/**
	 * Constructs a Incident from the provided id, state, title, caller,
	 * reopenCount, owner, statusDetails, and incidentLog.
	 *
	 * @param id            unique id for an incident.
	 * @param state         state for an incident
	 * @param title         title of the incident as provided by the user on
	 *                      creation
	 * @param caller        the name of the user who created the incident as
	 *                      provided on creation
	 * @param reopenCount   the number of times an incident has been reopened
	 * @param owner         the name of the user who owns and is responsible for
	 *                      resolving the incident
	 * @param statusDetails the details about the status of the incident which will
	 *                      take on values of the on hold reasons, resolution
	 *                      reasons, or cancellation reasons depending on the
	 *                      current state
	 * @param incidentLog   An ArrayList of Strings that contain the original
	 *                      incident description and any messages recorded during
	 *                      incident transitions.
	 */
	public Incident(int id, String state, String title, String caller, int reopenCount, String owner,
					String statusDetails, ArrayList<String> incidentLog) {
		if (state == null || title == null || caller == null || owner == null || statusDetails == null
				|| incidentLog == null || state.isEmpty()
				|| !(NEW_NAME.equals(state) || RESOLVED_NAME.equals(state) || ON_HOLD_NAME.equals(state)
				|| IN_PROGRESS_NAME.equals(state) || CANCELED_NAME.equals(state))
				|| title.isEmpty() || caller.isEmpty() || owner.isEmpty() || statusDetails.isEmpty()) {
			throw new IllegalArgumentException("Incident cannot be created..");
		}
		if (NEW_NAME.equals(state) && !UNOWNED.equals(owner)) {
			throw new IllegalArgumentException("Incident cannot be created..");
		}
		if (id > counter) {
			setCounter(id++);
		}
		this.incidentId = id;
		setState(state);
		this.title = title;
		this.caller = caller;
		this.reopenCount = reopenCount;
		this.owner = owner;
		this.statusDetails = statusDetails;
		this.incidentLog = incidentLog;
	}

	/**
	 * Returns the Incident's id.
	 *
	 * @return the incident id.
	 */
	public int getId() {
		return incidentId;
	}

	/**
	 * Set's the Incident's incidentId.
	 *
	 * @param incidentId Unique id for an incident.
	 */
	@SuppressWarnings("unused")
	private void setId(int incidentId) {
		this.incidentId = incidentId;
	}

	/**
	 * Returns the Incident's id.
	 *
	 * @return the incident id.
	 */
	public String getState() {
		return this.currentState.getStateName();
	}

	/**
	 * Set's the Incident's incidentId.
	 *
	 */
	@SuppressWarnings("unused")
	private void setState(String state) {

		switch (state) {
			case NEW_NAME:
				NewState newState = this.new NewState();
				this.currentState = newState;
				break;
			case RESOLVED_NAME:
				ResolvedState resolvedState = this.new ResolvedState();
				this.currentState = resolvedState;
				break;
			case ON_HOLD_NAME:
				OnHoldState onHoldState = this.new OnHoldState();
				this.currentState = onHoldState;
				break;
			case IN_PROGRESS_NAME:
				InProgressState inProgressState = this.new InProgressState();
				this.currentState = inProgressState;
				break;
			case CANCELED_NAME:
				CanceledState canceledState = this.new CanceledState();
				this.currentState = canceledState;
				break;
		}

	}

	/**
	 * Returns the Incident's id.
	 *
	 * @return the incident id.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set's the Incident's title.
	 *
	 * @param title of the incident as provided by the user on creation.
	 */
	@SuppressWarnings("unused")
	private void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the Incident's Caller.
	 *
	 * @return caller the name of the user who created the incident as provided on
	 *         creation
	 */
	public String getCaller() {
		return caller;
	}

	/**
	 * Set's the Incident's caller.
	 *
	 * @param caller caller the name of the user who created the incident as
	 *               provided on creation.
	 */
	@SuppressWarnings("unused")
	private void setCaller(String caller) {
		this.caller = caller;
	}

	/**
	 * Returns the Incident's reopenCount.
	 *
	 * @return the incident reopenCount.
	 */
	public int getReopenCount() {
		return reopenCount;
	}

	/**
	 * Set's the Incident's reopenCount.
	 *
	 * @param reopenCount the number of times an incident has been reopened.
	 */
	@SuppressWarnings("unused")
	private void setReopenCount(int reopenCount) {
		this.reopenCount = reopenCount;
	}

	/**
	 * Returns the Incident's owner.
	 *
	 * @return the incident owner.
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Set's the Incident's owner.
	 *
	 * @param owner the name of the user who owns and is responsible for resolving
	 *              the incident.
	 */
	@SuppressWarnings("unused")
	private void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Returns the Incident's statusDetails.
	 *
	 * @return the incident statusDetails.
	 */
	public String getStatusDetails() {
		return statusDetails;
	}

	/**
	 * Set's the Incident's statusDetails.
	 *
	 * @param statusDetails The details about the status of the incident which will
	 *                      take on values of the on hold reasons, resolution
	 *                      reasons, or cancellation reasons depending on the
	 *                      current state
	 * @param state         The current state of the incident.
	 */
	@SuppressWarnings("unused")
	private void setStatusDetails(String state, String statusDetails) {
		this.statusDetails = statusDetails;
	}

	/**
	 * Adds the Incident's message to incident log.
	 *
	 * @param validFile validFile for input
	 * @return 0
	 */
	@SuppressWarnings("unused")
	private int addMessageToIncidentLog(String validFile) {
		return 0;
	}

	/**
	 * Incident is incremented by a counter.
	 */
	public static void incrementCounter() {
		counter++;
	}

	/**
	 * Set's the Incident's counter.
	 *
	 * @param counter how Incident is incremented
	 */
	public static void setCounter(int counter) {
		Incident.counter = counter;
	}

	/**
	 * Returns the Incident's log messages.
	 *
	 * @return Incident log message.
	 */
	public String getIncidentLogMessages() {
		return null;
	}

	/**
	 * Returns the string representation of the Incident that is printed during file
	 * save operations
	 *
	 * @return the string representation of the Incident that is printed during file
	 *         save operations
	 */
	public String toString() {
		return "Incident [incidentId=" + incidentId + ", title=" + title + ", caller=" + caller + ", reopenCount="
				+ reopenCount + ", owner=" + owner + ", statusDetails=" + statusDetails + ", currentState="
				+ currentState + ", cancelledState=" + cancelledState + ", inProgressState=" + inProgressState
				+ ", resolvedState=" + resolvedState + ", newState=" + newState + ", onHoldState=" + onHoldState
				+ ", incidentLog=" + incidentLog + "]";
	}

	/**
	 * Delegates the current stateâ€™s updateState(Command) method.
	 *
	 * @param command encapsulate user actions (or transitions) that cause the state
	 *                of a Incident to update
	 */
	public void update(Command command) throws UnsupportedOperationException {
		this.currentState.updateState(command);
	}

	/**
	 * Interface that describes the behavior of concrete *State classes for the
	 * ServiceWolf FSM
	 *
	 * @param command command encapsulate user actions (or transitions) that cause
	 *                the state of a Incident to update
	 */
	public interface IncidentState {
		void updateState(Command command);

		String getStateName();
	}

	/**
	 * Concrete class that represents the in progress state of the ServiceWolf FSM
	 */
	public class InProgressState implements IncidentState {

		/**
		 * Final instance of the InProgressState inner class
		 */
		private InProgressState() {
		}

		/**
		 * Method drives the finite state machine by delegating to the current stateâ€™s
		 *
		 *
		 * @param command command encapsulate user actions (or transitions) that cause
		 *                the state of a Incident to update
		 */
		public void updateState(Command command) {
		}

		/**
		 * Returns the state name of Incident
		 *
		 * @return state name of Incident
		 */
		public String getStateName() {
			return IN_PROGRESS_NAME;
		}
	}

	/**
	 * Concrete class that represents the canceled state of the ServiceWolf FSM
	 */
	public class CanceledState implements IncidentState {

		/* Final instance of the CanceledState inner class */
		private CanceledState() {
		}

		/**
		 * Method drives the finite state machine by delegating to the current stateâ€™s
		 * updateState(Command) method
		 *
		 * @param command command encapsulate user actions (or transitions) that cause
		 *                the state of a Incident to update
		 */
		public void updateState(Command command) {
		}

		/**
		 * Returns the state name of Incident
		 *
		 * @return state name of Incident
		 */
		public String getStateName() {
			return CANCELED_NAME;
		}
	}

	/**
	 * Concrete class that represents the new state of the ServiceWolf FSM.
	 */
	public class NewState implements IncidentState {

		/** Final instance of the NewState inner class. */
		private NewState() {
		}

		/**
		 * Method drives the finite state machine by delegating to the current stateâ€™s
		 * updateState(Command) method
		 *
		 * @param command command encapsulate user actions (or transitions) that cause
		 *                the state of a Incident to update
		 */
		public void updateState(Command command) {
			/*
			 * CommandValue commandValue = command.getCommand();
			 * if("ASSIGN".equals(commandValue)) {
			 * 
			 * } else if("HOLD".equals(commandValue))
			 */
		}

		/**
		 * Returns the state name of Incident
		 *
		 * @return state name of Incident
		 */
		public String getStateName() {
			return NEW_NAME;
		}

	}

	/**
	 * Concrete class that represents the on hold state of the ServiceWolf FSM.
	 */
	public class OnHoldState implements IncidentState {

		/** Final instance of the OnHoldState inner class. */
		private OnHoldState() {
		}

		/**
		 * Method drives the finite state machine by delegating to the current stateâ€™s
		 * updateState(Command) method
		 *
		 * @param command command encapsulate user actions (or transitions) that cause
		 *                the state of a Incident to update
		 */
		public void updateState(Command command) {
		}

		/**
		 * Returns the state name of Incident
		 *
		 * @return state name of Incident
		 */
		public String getStateName() {
			return ON_HOLD_NAME;
		}
	}

	/**
	 * Concrete class that represents the resolved state of the ServiceWolf FSM
	 */
	public class ResolvedState implements IncidentState {

		/* Final instance of the ResolvedState inner class. */
		private ResolvedState() {
		}

		/**
		 * Returns the state name of Incident
		 *
		 * @return state name of Incident
		 */
		public String getStateName() {
			return RESOLVED_NAME;
		}

		/**
		 * Method drives the finite state machine by delegating to the current stateâ€™s
		 * updateState(Command) method
		 *
		 * @param command command encapsulate user actions (or transitions) that cause
		 *                the state of a Incident to update
		 */
		public void updateState(Command command) {
		}

	}
}