package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * Activity implements Conflict Class.
 * 
 * @author Olivia Longfellow
 *
 */

public abstract class Activity implements Conflict {

	/**
	 * An instance method of Activity. Activity contains the checkConflict
	 * implementation. Compares the current instance with the parameter
	 * possibleConflictingActivity to see if there is any conflict in their days and
	 * times
	 * 
	 * @param possibleConflictingActivity conflicting activity in schedule
	 * @throws ConflictException if there is a conflict, the checked
	 *                           ConflictException is thrown
	 * 
	 */

	@Override
	public void checkConflict(Activity possibleConflictingActivity) throws ConflictException {
		// calling activity details
		int startTimeCallingActivity = this.getStartTime();
		int endTimeCallingActivity = this.getEndTime();
		String meetingDaysCallingActivity = this.getMeetingDays();

		// PossibleConflictingActivity details
		int startTimePossibleConflictingActivity = possibleConflictingActivity.getStartTime();
		int endTimePossibleConflictingActivity = possibleConflictingActivity.getEndTime();
		String meetingDaysPossibleConflictingActivity = possibleConflictingActivity.getMeetingDays();

		// conflict when end time of this activity is same as start time of possible
		// conflicting activity
		if (meetingDaysCallingActivity.equalsIgnoreCase(meetingDaysPossibleConflictingActivity)) {
			if (endTimeCallingActivity == startTimePossibleConflictingActivity) {
				throw new ConflictException(
						"Conflict was thrown since meeting days were same for both activities and end time of this Activity is equal to start time of Possible Conflicting Activity.");
			}
		}

		// conflict when end time of possible conflicting activity is same as start time
		// of this activity
		if (meetingDaysPossibleConflictingActivity.equalsIgnoreCase(meetingDaysCallingActivity)) {
			if (endTimePossibleConflictingActivity == startTimeCallingActivity) {
				throw new ConflictException(
						"Conflict was thrown since meeting days were same for both activities and end time of Possible Conflicting Activity is equal to start time of this Activity.");
			}
		}
	}

	/** Integer for upper hour of time */
	private static int UPPER_HOUR = 24;
	/** Integer for upper minute time */
	private static int UPPER_MINUTE = 60;
	/** Course's title. */
	private String title;
	/** Course's meeting days */
	private String meetingDays;

	/** Course's starting time */
	private int startTime;
	/** Course's ending time */
	private int endTime;

	/* Provides a short version of the array of information to provide to the GUI */
	public abstract String[] getShortDisplayArray();

	/** Provides a long version of the array of information to provide to the GUI */

	public abstract String[] getLongDisplayArray();

	/**
	 * Provides a short version of the array of information to provide to the GUI
	 * 
	 * @param meetingDays meeting days of activity
	 * @param title       title of Activity
	 * @param startTime   start time of the course
	 * @param endTime     end time of the course
	 */

	public Activity(String title, String meetingDays, int startTime, int endTime) {
		super();
		setTitle(title);

		setMeetingDaysAndTime(meetingDays, startTime, endTime);
	}

	/**
	 * Generates a hashCode for Activity using all fields.
	 * 
	 * @return hashCode for Course
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endTime;
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/**
	 * Compares a given object to this object for equality on all fields
	 * 
	 * @param obj the Object to compare
	 * @return true if the objects are the same on all fields
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (endTime != other.endTime)
			return false;
		if (meetingDays == null) {
			if (other.meetingDays != null)
				return false;
		} else if (!meetingDays.equals(other.meetingDays))
			return false;
		if (startTime != other.startTime)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/**
	 * Returns the Activity's title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set's the Activity's title.
	 * 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		if (title == null || title.equals("")) {
			throw new IllegalArgumentException("Invalid title.");
		}
		this.title = title;
	}

	/**
	 * Returns the Activity's meeting days and times.
	 * 
	 * @param meetingDays meetingDays days when the course meets
	 * @param startTime   startTime when the course starts
	 * @param endTime     endTime when the course ends
	 */
	public void setMeetingDaysAndTime(String meetingDays, int startTime, int endTime) {

		int startHour = startTime / 100;
		int startMinute = startTime % 100;
		int endHour = endTime / 100;
		int endMinute = endTime % 100;

		if (startHour < 0 || startHour >= UPPER_HOUR) {
			throw new IllegalArgumentException("Invalid start time.");
		}
		if (startMinute < 0 || startMinute >= UPPER_MINUTE) {
			throw new IllegalArgumentException("Invalid start time.");
		}
		if (endHour < 0 || endHour >= UPPER_HOUR) {
			throw new IllegalArgumentException("Invalid end time.");
		}
		if (endMinute < 0 || endMinute >= UPPER_MINUTE) {
			throw new IllegalArgumentException("Invalid end time.");
		}
		if (endTime < startTime) {
			throw new IllegalArgumentException("End time cannot be before start time.");
		}

		this.meetingDays = meetingDays;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * Returns the Activity's meetingDays.
	 * 
	 * @return the meetingDays
	 */
	public String getMeetingDays() {
		return meetingDays;
	}

	/**
	 * Returns the Course's startTime.
	 * 
	 * @return the startTime
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Returns the Activity's endTime.
	 * 
	 * @return the endTime
	 */
	public int getEndTime() {
		return endTime;
	}

	/**
	 * Provides meeting information as a string in standard time format.
	 * 
	 * @return getMeetingDays, getTimeString, getTimeString
	 */
	public String getMeetingString() {
		if (getMeetingDays().equals("A")) {
			return "Arranged";
		}
		return getMeetingDays() + " " + getTimeString(getStartTime()) + "-" + getTimeString(getEndTime());
	}

	/**
	 * Converts military time to standard time.
	 * 
	 * @param time time of the Course
	 * @return hour_str, min_str, am_pm returns the hour, minute, and am or pm
	 */

	private String getTimeString(int time) {

		if (time == 1200) {
			return "12:00PM";
		}

		if (time == 0) {
			return "12:00AM";
		}

		int hour = time / 100;
		int min = time % 100;

		String am_pm = "";

		if (hour >= 12) {
			am_pm = "PM";

		} else {
			am_pm = "AM";
		}
		if (hour > 12) {
			hour = hour - 12;
		}
		String hour_str = String.valueOf(hour);

		String min_str = "";
		if (min < 10) {
			min_str += "0";
		}
		min_str += String.valueOf(min);

		return hour_str + ":" + min_str + am_pm;
	}

	/*
	 * Abstract method for checking duplicate
	 * 
	 * @param Activity activity of schedule
	 */
	public abstract boolean isDuplicate(Activity activity);

}