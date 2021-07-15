/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.course;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the implementation of the Conflict interface in Activity.
 * 
 * @author olivialongfellow
 *
 */
public class ActivityTest {

	/**
	 * Test method for checkConflict method No Conflict Test
	 *
	 */
	@Test
	public void testCheckConflict() {
		Activity a1 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "MW", 1330,
				1445);
		Activity a2 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "TH", 1330,
				1445);
		try {
			a1.checkConflict(a2);
			assertEquals("Meeting string for this Activity.", "MW 1:30PM-2:45PM", a1.getMeetingString());
			assertEquals("Meeting string for possibleConflictingActivity.", "TH 1:30PM-2:45PM", a2.getMeetingString());
			assertNotEquals("Incorrect Meeting string for possibleConflictingActivity.", "TH 1:30PM-2:55PM",
					a2.getMeetingString());
		} catch (ConflictException e) {
			fail("A ConflictException was thrown when two Activities at the same time on completely distinct days were compared.");
		}
	}

	/**
	 * Test method for checkConflict method Conflict Test
	 *
	 */
	@Test
	public void testCheckConflictWithConflict() {
		Activity a1 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "MW", 1330,
				1445);
		Activity a2 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "MW", 1445,
				1530);
		try {
			a1.checkConflict(a2);
			fail("A ConflictException was NOT thrown when two Activities had a day/time conflict.");
		} catch (ConflictException e) {
			assertEquals("Incorrect meeting string for this Activity.", "MW 1:30PM-2:45PM", a1.getMeetingString());
			assertEquals("Incorrect meeting string for possibleConflictingActivity.", "MW 2:45PM-3:30PM",
					a2.getMeetingString());
		}
	}

	/**
	 * Test method for checkConflict method Conflict Test start time of
	 * possibleConflictingActivity is equal to end time of this activity
	 *
	 */
	@Test
	public void testCheckConflictWithConflict2() {
		Activity a1 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "MW", 1330,
				1445);
		Activity a2 = new Course("CSC 216", "Software Development Fundamentals", "001", 3, "sesmith5", "MW", 1445,
				1530);
		try {
			a2.checkConflict(a1);
			fail("A ConflictException was NOT thrown when two Activities had a day/time conflict.");
		} catch (ConflictException e) {
			assertEquals("Incorrect meeting string for this Activity.", "MW 1:30PM-2:45PM", a1.getMeetingString());
			assertEquals("Incorrect meeting string for possibleConflictingActivity.", "MW 2:45PM-3:30PM",
					a2.getMeetingString());
		}
	}
}
