/**
 *
 */
package edu.ncsu.csc216.service_wolf.model.incident;

import edu.ncsu.csc216.service_wolf.model.command.Command;

import java.util.ArrayList;


/**
 * @author olivialongfellow
 *
 */
public class Incident {

    /* Integer unique id for an incident. */
    private int incidentId;

    /* String for title of incident */
    private String title;

    /* String for caller of incident */
    private String caller;

	/* String for caller of incident */

	private int reopenCount;

    /* String for caller of incident */
    private String owner;

    /* String for caller of incident */

    private String statusDetails;

	/* String for caller of incident */
	private ArrayList<String> incidentLog;

    /* String for caller of incident */
    private static final String NEW_NAME = "New";

    /* String for caller of incident */
    private static final String IN_PROGRESS_NAME = "In Progress";

    /* String for caller of incident */
    private static final String ON_HOLD_NAME = "On Hold";

    /* String for caller of incident */
    private static final String REDOLVED_NAME = "Resolved";

    /* String for caller of incident */
    private static final String CANCELED_NAME = "Canceled";

    /* String for caller of incident */
    private static final String HOLD_AWAITING_CALLER = "Awaiting Caller";

    /* String for caller of incident */
    private static final String HOLD_AWAITING_CHANGE = "Awaiting Chance";

    /* String for caller of incident */
    private static final String HOLD_AWAITING_VENDOR = "Awaiting Vendor";

    /* String for caller of incident */
    private static final String RESOLUTION_PERMANENTLY_SOLVED = "Permanently Solved";

    /* String for caller of incident */
    private static final String RESOLUTION_WORKAROUND = "Workaround";

    /* String for caller of incident */
    private static final String RESOLUTION_CALLER_CLOSED = "Caller Closed";

	/* String for caller of incident */
	private static final String CANCELLATION_DUPLICATE = "Duplicate";

    /* String for caller of incident */
    private static final String CANCELLATION_UNNECESSARY = "Unnecessary";

    /* String for caller of incident */
    private static final String CANCELLATION_NOT_AN_INCIDENT = "Not an Incident";

    /* String for caller of incident */
    private static final String CANCELLATION_CALLER_CANCELLED = "Caller Canceled";

    /* String for caller of incident */
    private static final String UNOWED = "Unowed";

    /* String for caller of incident */
    private static final String NO_STATUS = "No Staus";

    /* String for caller of incident */
    private static int counter;

    public Incident(String title, String caller, String message) {
    }

    public Incident(int id, String state, String title, String caller, int reopenCount,
					String owner, String statusDetails, ArrayList<String> incidentLog) {
    }

    public int getId() {
        return incidentId;
    }

    private void setId(int incidentId) {
    }

    public String getState() {
    	return null;
	}

	private void setState() {
	}

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getCaller() {
        return caller;
    }

    private void setCaller(String caller) {
        this.caller = caller;
    }

	public int getReopenCount() {
		return reopenCount;
	}

	private void setReopenCount(int reopenCount) {
		this.reopenCount = reopenCount;
	}

    public String getOwner() {
        return owner;
    }

    private void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatusDetails() {
        return statusDetails;
    }

    private void setStatusDetails(String state) {
        this.statusDetails = statusDetails;
    }

    private int addMessageToIncidentLog(String validFile) {
        return 0;
    }

    public static void incrementCounter() {
	}

	private static void setCounter(int counter) {
		Incident.counter = counter;
	}

	public String getIncidentLogMessages() {
		return null;
	}

    public String toString() {
        return null;
    }

    public void update(Command command) {
	}

    /**
     * interface
     */
    public interface IncidentState {
        void updateState(Command command);
        String getStateName();
    }

    /**
     * InProgressState class
     */
    public class InProgressState implements IncidentState {

        private InProgressState() {
        }

        @Override
        public void updateState(Command command) {
        }

        @Override
        public String getStateName() {
            return null;
        }
    }

    /**
     * CanceledState class
     */
    public class CanceledState implements IncidentState{

        private CanceledState() {
        }

        @Override
        public void updateState(Command command) {
        }

        @Override
        public String getStateName() {
            return null;
        }
    }

    /**
     * NewState class
     */
    public class NewState implements IncidentState{

        private NewState() {
        }

        @Override
        public void updateState(Command command) {
        }

        @Override
        public String getStateName() {
            return null;
        }

    }

    /**
     * OnHoldState class
     */
    public class OnHoldState implements IncidentState{

        private OnHoldState() {
        }

        @Override
        public void updateState(Command command) {
        }

        @Override
        public String getStateName() {
            return null;
        }
    }

    /**
     * ResolvedState class
     */
    public class ResolvedState implements IncidentState{

        private ResolvedState() {
        }

        @Override
        public String getStateName() {
            return null;
        }

        @Override
        public void updateState(Command command) {
        }

    }
}

