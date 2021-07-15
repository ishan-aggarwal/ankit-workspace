/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import edu.ncsu.csc216.wolf_scheduler.course.Activity;
import edu.ncsu.csc216.wolf_scheduler.course.Course;
import edu.ncsu.csc216.wolf_scheduler.course.Event;
import edu.ncsu.csc216.wolf_scheduler.io.CourseRecordIO;
import edu.ncsu.csc216.wolf_scheduler.io.ActivityRecordIO;

/**
 * Reads in and stores as a list all of the Course records stored in a file.
 * Creates a schedule for the current user and provides functionality for naming
 * the schedule resetting the schedule.
 * 
 * @author Olivia Longfellow
 *
 */
public class WolfScheduler {

	/* array list for Activity catalog */
	public ArrayList<Course> catalog;

	/* array list for Activity schedule */
	public ArrayList<Activity> schedule;

	/* String variable for title */
	public String title;

	/**
	 * Constructs an empty ArrayList to hold the schedule in the schedule field
	 * 
	 * @param validTestFile a valid test file
	 */

	public WolfScheduler(String validTestFile) {
		catalog = new ArrayList<>();
		schedule = new ArrayList<>();
		title = "My Schedule";

		try {
			catalog = CourseRecordIO.readCourseRecords(validTestFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gets the course from the catalog. This array is used in the GUI to create the
	 * table of course catalog information.
	 * 
	 * @return arr returns a 2D String array of the catalog
	 */
	public String[][] getCourseCatalog() {
		if (catalog.size() == 0) {
			return new String[0][4];
		}
		String[][] arr = new String[catalog.size()][4];
		int i = 0;
		for (Activity course : catalog) {
			arr[i][0] = ((Course) course).getName();
			arr[i][1] = ((Course) course).getSection();
			arr[i][2] = course.getTitle();
			arr[i][3] = course.getMeetingString();
			i++;
		}
		return arr;
	}

	/**
	 * Gets the course from the catalog.his array is used in the GUI to create the
	 * table of course catalog information.
	 * 
	 * @return arr returns a 2D String array of the catalog
	 */

	public String[][] getFullScheduledActivities() {
		if (schedule.size() == 0) {
			return new String[0][6];
		}
		String[][] arr = new String[schedule.size()][6];
		int i = 0;
		for (Activity course : schedule) {
			arr[i] = course.getLongDisplayArray();
			i++;
		}
		return arr;
	}

	/**
	 * Gets the course from the catalog. The array is used in the GUI to create the
	 * table of course catalog information.
	 * 
	 * @return arr returns a 2D String array of the catalog
	 */

	public String[][] getScheduledActivities() {
		if (schedule.size() == 0) {
			return new String[0][3];
		}
		String[][] arr = new String[schedule.size()][3];
		int i = 0;
		for (Activity activity : schedule) {
			arr[i] = activity.getShortDisplayArray();
			i++;
		}
		return arr;
	}

	/**
	 * Used to export the course schedule.
	 * 
	 * @param fileName filename where the student’s schedule will be saved to
	 */

	public void exportSchedule(String fileName) {
		try {
			ActivityRecordIO.writeActivityRecords(fileName, schedule);

		} catch (IOException ioException) {
			throw new IllegalArgumentException("The file cannot be saved");
		}

	}

	/**
	 * Used to get course from the catalog.
	 * 
	 * @param name    name of the course
	 * @param section section of the course
	 * @return null if reach the end of the loop without finding the Course
	 */

	public Course getCourseFromCatalog(String name, String section) {
		for (Activity c2 : catalog) {
			if (((Course) c2).getName().equals(name) && ((Course) c2).getSection().equals(section)) {
				return ((Course) c2);
			}
		}

		return null;
	}

	/**
	 * Used to get course from the catalog.
	 * 
	 * @param name    name of the course
	 * @param section section of the course
	 * @return true returns true if the given Course (represented by the name and
	 *         section) meets the following criteria: 1) the course exists in the
	 *         catalog and 2) the course is successfully added to the student’s
	 *         schedule. Return false otherwise.
	 */

	// public boolean addCourseToSchedule(String name, String section) {
	public boolean addCourseToSchedule(String name, String section) {
		// Course course = new Course(name, title, section, 3, "ixdoming", "MW", 1330,
		// 1445);
		Course course = null;
		boolean found = false;
		for (Course c2 : catalog) {
			if (c2.getName().equals(name) && c2.getSection().equals(section)) {
				course = c2;
				found = true;
			}
		}
		if (found) {
			for (Activity c2 : schedule) {
				if (course.isDuplicate(c2)) {
					throw new IllegalArgumentException("You are already enrolled in " + course.getName());
				}
			}
			schedule.add(course);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check that is done at this portion of the code is to see if the Course to be
	 * added is a duplicate of a Course already in the schedule.
	 * 
	 * @param title        title of Course
	 * @param meetingDays  meeting days for Course as series of chars
	 * @param startTime    start time of the Course
	 * @param endTime      end time of the Course
	 * @param weeklyRepeat weekly repeat of the Course
	 * @param eventDetails event details of the Course
	 * @return true if not a duplicate
	 */

	public boolean addEventToSchedule(String title, String meetingDays, int startTime, int endTime, int weeklyRepeat,
			String eventDetails) {
		Event event = new Event(title, meetingDays, startTime, endTime, weeklyRepeat, eventDetails);

		for (Activity c2 : schedule) {
			if (event.isDuplicate(c2)) {
				throw new IllegalArgumentException("You have already created an event called " + event.getTitle());
			}
		}
		schedule.add(event);
		return true;
	}

	/**
	 * Used to get remove course from the schedule.
	 * 
	 * @param idx idx the index of the Activity you want to remove from the schedule
	 * @return true returns true if the given Course (represented by the name and
	 *         section) can be removed from the student’s schedule. Return false
	 *         otherwise.
	 */

	public boolean removeActivityFromSchedule(int idx) {

		try {
			schedule.remove(idx);
			return true;
		} catch (IndexOutOfBoundsException ex) {
			return false;
		}
	}

	/**
	 * Used to set the schedule title.
	 * 
	 * @param title title of the course
	 */

	public void setScheduleTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException("Title cannot be null.");
		}
		this.title = title;
	}

	/**
	 * Used to get the schedule title.
	 * 
	 * @return title the title of the course
	 */
	public String getScheduleTitle() {
		return title;
	}

	/**
	 * Used to reset the course schedule.
	 */

	public void resetSchedule() {
		this.schedule = new ArrayList<>();
	}
}
