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
	 * @invar Minutes in the interval [0 - 59]
	 * 		| minutes >= 0 && minutes <= 59
	 * @invar Hours in the interval [0 - 23]
	 * 		| hours >= 0 && hours <= 23
	 */
	private int minutes;
	private int hours;
	
	
	/**
	 * @pre initialMinutes in the interval [0 - 59]
	 * 		| initialMinutes >= 0 && initialMinutes <= 59
	 * @pre initialHours in the interval [0 - 23]
	 * 		| initialHours >= 0 && initialHours <= 23
	 * @post | getMinutes() == initialMinutes
	 * @post | getHours() == initialHours
	 */
	public TimeOfDay(int initialMinutes, int initialHours) {
		this.minutes  = initialMinutes;
		this.hours = initialHours;
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
		this.minutes = minutes;
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
		this.hours = hours;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getHours() {
		return hours;
	}
}
