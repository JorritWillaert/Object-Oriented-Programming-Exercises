package timeofday;

//Note the usage of getters and setters!
/**
 * Every instance of this class represents the time of the day.
 * @invar Minutes in the interval [0 - 59]
 * 		| getMinutes() >= 0 && getMinutes() <= 59
 * @invar Hours in the interval [0 - 23]
 * 		| getHours() >= 0 && getHours() <= 23
 */
public class TimeOfDay {
	/**
	 * @invar minutesSinceMidnight in the interval [0 - 1439]
	 * 		| minutesSinceMidnight >= 0 && minutesSinceMidnight <= 1439
	 */
	private int minutesSinceMidnight;
	
	
	/**
	 * @pre initialMinutes in the interval [0 - 59]
	 * 		| initialMinutes >= 0 && initialMinutes <= 59
	 * @pre initialHours in the interval [0 - 23]
	 * 		| initialHours >= 0 && initialHours <= 23
	 * @post | getMinutes() == initialMinutes
	 * @post | getHours() == initialHours
	 */
	public TimeOfDay(int initialMinutes, int initialHours) {
		minutesSinceMidnight  = initialMinutes;
		minutesSinceMidnight += initialHours * 60;
	}
	
	/**
	 * @pre Minutes in the interval [0 - 59]
	 * 		| minutes >= 0 && minutes <= 59
	 * @post The minutes of TimeOfDay equals the given minutes
	 * 		| this.getMinutes() == minutes
	 * @post The minutes of TimeOfDay are unchanged
	 * 		| this.getHours() == old(this.getHours())
	 */
	public void setMinutes(int minutes) {
		minutesSinceMidnight = getHours() * 60 + minutes;
	}
	
	/**
	 * @pre Hours in the interval [0 - 23]
	 * 		| hours >= 0 && hours <= 23
	 * @post The hours of TimeOfDay equals the given hours
	 * 		| this.getHours() == hours
	 * @post The minutes of TimeOfDay are unchanged
	 * 		| this.getMinutes() == old(this.getMinutes())
	 */
	public void setHours(int hours) {
		minutesSinceMidnight = hours * 60 + getMinutes();
	}
	
	public int getMinutes() {
		return minutesSinceMidnight % 60;
	}
	
	public int getHours() {
		return minutesSinceMidnight / 60;
	}
}
