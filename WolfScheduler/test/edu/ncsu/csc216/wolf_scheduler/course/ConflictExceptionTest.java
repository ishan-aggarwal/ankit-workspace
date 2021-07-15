/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.course;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for the ConflictExceptionClass.
 * 
 * @author Olivia Longfellow
 *
 */
public class ConflictExceptionTest {

	/**
	 * Test method for parameterized ConflictException constructor .
	 */
	@Test
	public void testConflictExceptionString() {
		ConflictException ce = new ConflictException("Custom exception message");
		assertEquals("Custom exception message", ce.getMessage());
	}

	/**
	 * Test method for parameterless ConflictException constructor.
	 */
	@Test
	public void testConflictException() {
		ConflictException ce = new ConflictException();
		assertEquals("Sample message", ce.getMessage());

	}

}
