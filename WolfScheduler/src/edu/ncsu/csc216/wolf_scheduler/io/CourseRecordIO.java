package edu.ncsu.csc216.wolf_scheduler.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_scheduler.course.Course;

/**
 * Reads Course records from text files. Writes a set of CourseRecords to a
 * file.
 * 
 * @author Sarah Heckman
 */
public class CourseRecordIO {

	/**
	 * Reads course records from a file and generates a list of valid Courses. Any
	 * invalid Courses are ignored. If the file to read cannot be found or the
	 * permissions are incorrect a File NotFoundException is thrown.
	 * 
	 * @param fileName file to read Course records from
	 * @return a list of valid Courses
	 * @throws FileNotFoundException if the file cannot be found or read
	 */
	public static ArrayList<Course> readCourseRecords(String fileName) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new FileInputStream(fileName)); // Create a file scanner to read the file
		ArrayList<Course> courses = new ArrayList<>(); // Create an empty array of Course objects
		while (fileReader.hasNextLine()) { // While we have more lines in the file
			try { // Attempt to do the following
					// Read the line, process it in readCourse, and get the object
					// If trying to construct a Course in readCourse() results in an exception, flow
					// of control will transfer to the catch block, below
				Course course = readCourse(fileReader.nextLine());

				// Create a flag to see if the newly created Course is a duplicate of something
				// already in the list
				boolean duplicate = false;
				// Look at all the courses in our list
				for (int i = 0; i < courses.size(); i++) {
					// Get the course at index i
					Course current = courses.get(i);
					// Check if the name and section are the same
					if (course.getName().equals(current.getName())
							&& course.getSection().equals(current.getSection())) {
						// It's a duplicate!
						duplicate = true;
						break; // We can break out of the loop, no need to continue searching
					}
				}
				// If the course is NOT a duplicate
				if (!duplicate) {
					courses.add(course); // Add to the ArrayList!
				} // Otherwise ignore
			} catch (IllegalArgumentException e) {
				// The line is invalid b/c we couldn't create a course, skip it!
				// e.printStackTrace();
				courses.clear();
			}
		}
		// Close the Scanner b/c we're responsible with our file handles
		fileReader.close();
		// Return the ArrayList with all the courses we read!
		return courses;
	}

	/**
	 * Receives a String which is a line from the input file. Breaks up the line up
	 * into tokens by using the comma character
	 * 
	 * @param nextLine next line of file
	 * @return course courses that are valid
	 * @throws Exception if the file cannot be found or read
	 */
	private static Course readCourse(String nextLine) throws IllegalArgumentException {

		Scanner scanner = new Scanner(nextLine);
		scanner.useDelimiter(",");

		Course course = null;

		try {

			String name = scanner.next();
			String title = scanner.next();
			String section = scanner.next();
			int credits = scanner.nextInt();
			String instructorId = scanner.next();
			String meetingDays = scanner.next();
			int startTime = 0;
			int endTime = 0;
			if (meetingDays.equals("A")) {
				course = new Course(name, title, section, credits, instructorId, meetingDays);
			} else {
				startTime = scanner.nextInt();
				endTime = scanner.nextInt();
				course = new Course(name, title, section, credits, instructorId, meetingDays, startTime, endTime);
			}

			System.out.print(course.toString());

		} catch (NoSuchElementException x) {
			throw new IllegalArgumentException();
		}

		return course;
	}

	/**
	 * Writes the given list of Courses
	 * 
	 * @param fileName file to write schedule of Courses to
	 * @param courses  list of Courses to write
	 * @throws IOException if cannot write to file
	 */
	public static void writeCourseRecords(String fileName, ArrayList<Course> courses) throws IOException {
		PrintStream fileWriter = new PrintStream(new File(fileName));

		for (int i = 0; i < courses.size(); i++) {
			fileWriter.println(courses.get(i).toString());
		}

		fileWriter.close();
	}

}