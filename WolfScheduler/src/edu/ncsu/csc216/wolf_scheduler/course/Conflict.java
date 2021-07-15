package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * Conflict interface will be specific to the Activity hierarchy 
 * 
 * @author Olivia Longfellow
 *
 */
public interface Conflict {
	
	/**
	 * Conflict interface will be specific to the Activity hierarchy 
	 * 
	 * @param possibleConflictingActivity conflicting activity in schedule  
	 * @throws ConflictException checked exception 
	 * 
	 */
	void checkConflict(Activity possibleConflictingActivity) throws ConflictException;

}
