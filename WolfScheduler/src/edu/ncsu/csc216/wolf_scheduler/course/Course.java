/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * Represents the class for Courses. Inherits attributes and methods from the
 * Activity class.
 * 
 * @author Olivia Longfellow
 *
 */
public class Course extends Activity {

	/** Integer for minimum course length name */
	private static int MIN_NAME_LENGTH = 5;

	/** Integer for maximum course length name */
	private static int MAX_NAME_LENGTH = 8;

	/** Integer for minimum letter count */
	private static int MIN_LETTER_COUNT = 1;

	/** Integer for maximum letter count */
	private static int MAX_LETTER_COUNT = 4;

	/** Integer for digit count */
	private static int DIGIT_COUNT = 3;

	/** Integer for section length */
	private static int SECTION_LENGTH = 3;

	/** Integer for maximum credit hours */
	private static int MAX_CREDITS = 5;

	/** Integer for minimum credit hours */
	private static int MIN_CREDITS = 1;

	/** Course's name. */
	private String name;
	/** Course's section. */
	private String section;
	/** Course's credit hours */
	private int credits;
	/** Course's instructor */
	private String instructorId;

	/**
	 * Creates a Course with the given name, title, section, credits, instructorId,
	 * and meetingDays for courses that are arranged.
	 * 
	 * @param name         name of Course
	 * @param title        title of Course
	 * @param section      section of Course
	 * @param credits      credit hours for Course
	 * @param instructorId instructor's unity id
	 * @param meetingDays  meeting days for Course as series of chars
	 * @param startTime    the start time of the course
	 * @param endTime      the end time of the course
	 */

	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays,
			int startTime, int endTime) {
		super(title, meetingDays, startTime, endTime);
		setName(name);
		setSection(section);
		setCredits(credits);
		setInstructorId(instructorId);
	}

	/**
	 * Creates a Course with the given name, title, section, credits, instructorId,
	 * and meetingDays for courses that are arranged.
	 * 
	 * @param name         name of Course
	 * @param title        title of Course
	 * @param section      section of Course
	 * @param credits      credit hours for Course
	 * @param instructorId instructor's unity id
	 * @param meetingDays  meeting days for Course as series of chars
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays) {
		this(name, title, section, credits, instructorId, meetingDays, 0, 0);
	}

	/**
	 * Generates a hashCode for Course using all fields.
	 * 
	 * @return hashCode for Course
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + credits;
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		return true;
	}

	/**
	 * Returns the Course's name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Course's name. If the name is null, has a length less than 5 or more
	 * than 8, does not contain a space between letter characters and number
	 * characters, has less than 1 or more than 4 letter characters, and not exactly
	 * three trailing digit characters, an IllegalArgumentException is thrown.
	 * 
	 * @param name the name to set
	 * @throws IllegalArgumentException if the name parameter is invalid
	 */
	private void setName(String name) {
		boolean flag = false;
		int lCount = 0;
		int dCount = 0;
		// throw exception if name is null or empty
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}
		// Throw exception if the name contains less than 5 character or greater than 8
		// characters
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Name's length should be between 5 and 8, inclusive.");
		}

		for (int i = 0; i < name.length(); i++) {
			if (!flag) {
				if (Character.isLetter(name.charAt(i))) {
					lCount++;
				} else if (name.charAt(i) == ' ') {
					flag = true;
				} else {
					throw new IllegalArgumentException("Names should have 1-4 letters, a space, and 3 digits.");
				}
			} else {
				if (Character.isDigit(name.charAt(i))) {
					dCount++;
				} else {
					throw new IllegalArgumentException("Names should have 1-4 letters, a space, and 3 digits.");
				}
			}

		}
		if (lCount < MIN_LETTER_COUNT || lCount > MAX_LETTER_COUNT) {
			throw new IllegalArgumentException("Names should have 1-4 letters, a space, and 3 digits.");
		}
		if (dCount != DIGIT_COUNT) {
			throw new IllegalArgumentException("Names should have 1-4 letters, a space, and 3 digits.");
		}
		this.name = name;
	}

	/**
	 * Returns the Course's section.
	 * 
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * Set's the Course's section.
	 * 
	 * @param section the section to set
	 */
	public void setSection(String section) {
		if (section == null) {
			throw new IllegalArgumentException("Invalid section.");
		} else if (section.length() != SECTION_LENGTH) {
			throw new IllegalArgumentException("Invalid section.");
		}
		for (int i = 0; i < section.length(); i++) {
			if (!Character.isDigit(section.charAt(i))) {
				throw new IllegalArgumentException("Section should be three digits.");
			}

		}
		this.section = section;
	}

	/**
	 * Returns the Course's Credits.
	 * 
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Set's the Course's credits
	 * 
	 * @param credits the credits to set
	 */
	public void setCredits(int credits) {
		if (credits < MIN_CREDITS || credits > MAX_CREDITS) {
			throw new IllegalArgumentException("Credits should be between 1 and 5, inclusive.");
		}
		this.credits = credits;
	}

	/**
	 * Returns the Course's instuctorID.
	 * 
	 * @return the instructorId
	 */
	public String getInstructorId() {
		return instructorId;
	}

	/**
	 * Set's the Course's instuctorID.
	 * 
	 * @param instructorId the instructorId to set
	 */
	public void setInstructorId(String instructorId) {
		if (instructorId == null || instructorId.equals("")) {
			throw new IllegalArgumentException("Invalid instructor id.");
		}
		this.instructorId = instructorId;
	}

	/**
	 * Returns a comma separated value String of all Course fields.
	 * 
	 * @return String representation of Course
	 */
	@Override
	public String toString() {
		if (getMeetingDays().equals("A")) {
			return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + ","
					+ getMeetingDays();
		}
		return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + "," + getMeetingDays()
				+ "," + getStartTime() + "," + getEndTime();
	}

	/**
	 * Course will handle their own checks on meetingDays appropriate for their
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
			startTime = 0;
			endTime = 0;
		} else {
			// counters
			int m = 0;
			int t = 0;
			int w = 0;
			int h = 0;
			int f = 0;

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
				}

				else {
					throw new IllegalArgumentException("Invalid meeting days.");
				}
			}

			if (m > 1 || t > 1 || w > 1 || h > 1 || f > 1) {
				throw new IllegalArgumentException("Invalid meeting days.");
			}
		}

		super.setMeetingDaysAndTime(meetingDays, startTime, endTime);
	}

	/**
	 * Returns an array of length 4 containing the Course name, section, title, and
	 * meeting string
	 * 
	 * @return result of array
	 */
	@Override
	public String[] getShortDisplayArray() {
		String[] result = new String[4];
		result[0] = this.getName();
		result[1] = this.getSection();
		result[2] = this.getTitle();
		result[3] = this.getMeetingString();

		return result;
	}

	/**
	 * /** Returns an array of length 4 containing the Course name, section, title,
	 * and meeting string
	 * 
	 * @return result of array
	 */

	@Override
	public String[] getLongDisplayArray() {
		String[] result = new String[7];
		result[0] = this.getName();
		result[1] = this.getSection();
		result[2] = this.getTitle();
		result[3] = "" + this.getCredits();
		result[4] = this.getInstructorId();
		result[5] = this.getMeetingString();
		result[6] = "";

		return result;
	}

	/**
	 * Check that is done at this portion of the code is to see if the Course to be
	 * added is a duplicate of a Course already in the schedule.
	 * 
	 * @param activity activity of course
	 * @return false if a duplicate
	 */
	public boolean isDuplicate(Activity activity) {
		if (activity instanceof Course) {
			Course course = (Course) activity;
			return this.getTitle().equals(course.getTitle());
		}
		return false;

	}

}
