package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * A second child class of Activity.
 * 
 * @author Olivia Longfellow
 *
 */

public class Event extends Activity {

	/** Integer for minimum weekly repeats */
	private static int MIN_WEEKLY_REPEAT = 1;

	/** Integer for maximum weekly repeats */
	private static int MAX_WEEKLY_REPEAT = 4;

	/** Integer representing weekly repeats. */
	private Integer weeklyRepeat;

	/** String representing event details. */
	private String eventDetails = "";

	/**
	 * Event knows about two other items in addition to those provided by Activity:.
	 * 
	 * @param title        title of Event
	 * @param meetingDays  meeting days of Event
	 * @param startTime    start time of Event
	 * @param endTime      end time of Event
	 * @param weeklyRepeat weeklyRepeat of Event
	 * @param eventDetails event details of Event
	 */
	public Event(String title, String meetingDays, int startTime, int endTime, int weeklyRepeat, String eventDetails) {
		super(title, meetingDays, startTime, endTime);
		setWeeklyRepeat(weeklyRepeat);
		setEventDetails(eventDetails);
	}

	/**
	 * Gets the weekly repeat.
	 * 
	 * @return the weeklyRepeat
	 */
	public int getWeeklyRepeat() {
		return weeklyRepeat;
	}

	/**
	 * Sets the weekly repeat.
	 * 
	 * @param weeklyRepeat the weeklyRepeat to set
	 */
	public void setWeeklyRepeat(int weeklyRepeat) {
		if (weeklyRepeat < MIN_WEEKLY_REPEAT || weeklyRepeat > MAX_WEEKLY_REPEAT) {
			throw new IllegalArgumentException("Invalid weekly repeat.");
		}
		this.weeklyRepeat = weeklyRepeat;
	}

	/**
	 * Gets the event details.
	 * 
	 * @return the eventDetails
	 */
	public String getEventDetails() {
		return eventDetails;
	}

	/**
	 * Sets the event details.
	 * 
	 * @param eventDetails the eventDetails to set
	 */
	public void setEventDetails(String eventDetails) {
		if (eventDetails == null) {
			throw new IllegalArgumentException("Invalid event details.");
		}
		this.eventDetails = eventDetails;
	}

	/**
	 * Provides a short version of the array of information to provide to the GUI.
	 * 
	 * @return result of array
	 */
	@Override
	public String[] getShortDisplayArray() {

		String[] result = new String[4];
		result[0] = "";
		result[1] = "";
		result[2] = this.getTitle();
		result[3] = this.getMeetingString();
		return result;
	}

	/**
	 * Provides a long version of the array of information to provide to the GUI.
	 * 
	 * @return result of array
	 */
	@Override
	public String[] getLongDisplayArray() {
		String[] result = new String[7];
		result[0] = "";
		result[1] = "";
		result[2] = this.getTitle();
		result[3] = "";
		result[4] = "";
		result[5] = this.getMeetingString();
		result[6] = this.getEventDetails();
		return result;
	}

	/**
	 * Activity will handle their own checks on meetingDays appropriate for their
	 * requirements.
	 * 
	 * @param meetingDays meeting days for Course as series of chars
	 * @param startTime   the start time of the course
	 * @param endTime     the end time of the course
	 */
	@Override
	public void setMeetingDaysAndTime(String meetingDays, int startTime, int endTime) {
		if (meetingDays == null || meetingDays.equals("")) {
			throw new IllegalArgumentException("Invalid instructor meeting days.");
		}
		if (meetingDays.equals("A")) {
			throw new IllegalArgumentException("Invalid instructor meeting days.");
		} else {
			// counters
			int m = 0;
			int t = 0;
			int w = 0;
			int h = 0;
			int f = 0;
			int u = 0;
			int s = 0;

			for (int i = 0; i < meetingDays.length(); i++) {
				if (meetingDays.charAt(i) == 'M') {
					m++;
				} else if (meetingDays.charAt(i) == 'T') {
					t++;
				} else if (meetingDays.charAt(i) == 'W') {
					w++;
				} else if (meetingDays.charAt(i) == 'H') {
					h++;
				} else if (meetingDays.charAt(i) == 'F') {
					f++;
				} else if (meetingDays.charAt(i) == 'U') {
					u++;
				} else if (meetingDays.charAt(i) == 'S') {
					s++;
				}

				else {
					throw new IllegalArgumentException("Invalid meeting days.");
				}
			}

			if (m > 1 || t > 1 || w > 1 || h > 1 || f > 1 || u > 1 || s > 1) {
				throw new IllegalArgumentException("Invalid meeting days.");
			}
		}
		super.setMeetingDaysAndTime(meetingDays, startTime, endTime);
	}

	/**
	 * Provides a long version of the array of information to provide to the GUI.
	 * 
	 * @return result of array
	 */
	@Override
	public String getMeetingString() {

		return super.getMeetingString() + " (every " + getWeeklyRepeat() + " weeks)";
	}

	/**
	 * Produces a comma separated string with the title, meetingDays, startTime
	 * ,endTime ,weeklyRepeat ,details
	 * 
	 * @return a comma separated string
	 */
	@Override
	public String toString() {
		return getTitle() + "," + getMeetingDays() + "," + getStartTime() + "," + getEndTime() + "," + getWeeklyRepeat()
				+ "," + getEventDetails();
	}

	/**
	 * Check that is done at this portion of the code is to see if the Course to be
	 * added is a duplicate of a Course already in the schedule.
	 * 
	 * @param activity activity of course
	 * 
	 * @return false if a duplicate
	 */

	public boolean isDuplicate(Activity activity) {
		if (activity instanceof Event) {
			Event event = (Event) activity;
			return this.getTitle().equals(event.getTitle());
		}
		return false;

	}

}
