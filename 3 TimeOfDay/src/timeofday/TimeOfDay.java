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
	
	//Note: if a method is not yet implemented you can throw a RunTimeException.
	//e.g. public int getHours() {throw new RunTimeException("Not yet implemented"); }
	
	/**
	 * Initializes this object with the given hours and minutes.
	 * 
	 * Contractueel programmeren: 
	 * @pre initialMinutes in the interval [0 - 59]
	 * 		| initialMinutes >= 0 && initialMinutes <= 59
	 * @pre initialHours in the interval [0 - 23]
	 * 		| initialHours >= 0 && initialHours <= 23
	 * 
	 * Defensief programmeren:
	 * @throws IllegalArgumentException if the hours are not between 0 and 23
	 * 		| initialHours < 0 || 23 < initialHours
	 * @throws IllegalArgumentException if the minutes are not between 0 and 59
	 * 		| initialMinutes < 0 || 59 < initialMinutes
	 * Slechts 1 van de 2 gebruiken!
	 * 
	 * @post | getMinutes() == initialMinutes
	 * @post | getHours() == initialHours
	 */
	public TimeOfDay(int initialMinutes, int initialHours) {
		//Defensief programmeren
		if (initialHours < 0 || initialHours > 23) {
			throw new IllegalArgumentException("Bad hours");
		}
		if (initialMinutes < 0 || initialMinutes > 59) {
			throw new IllegalArgumentException("Bad minutes");
		}
		minutesSinceMidnight  = initialMinutes;
		minutesSinceMidnight += initialHours * 60;
	}
	
	/**
	 * 
	 * Sets this object's minutes.
	 * 
	 * Contractueel:
	 * @pre Minutes in the interval [0 - 59]
	 * 		| minutes >= 0 && minutes <= 59
	 * 
	 * Defensief:
	 * @throws IllegalArgumentException if the given hours are not between 0 and 23
	 * 		| minutes < 0 || 59 < minutes
	 * 
	 * @post The minutes of TimeOfDay equals the given minutes
	 * 		| this.getMinutes() == minutes
	 * @post The minutes of TimeOfDay are unchanged
	 * 		| this.getHours() == old(this.getHours())
	 */
	public void setMinutes(int minutes) {
		//Defensief:
		if (minutes < 0 || 59 < minutes) {
			throw new IllegalArgumentException("Bad minutes");
		}
		minutesSinceMidnight = getHours() * 60 + minutes;
	}
	
	/**
	 * Sets this object's hours.
	 * 
	 * Contractueel:
	 * @pre Hours in the interval [0 - 23]
	 * 		| hours >= 0 && hours <= 23
	 * 
	 * Defensief:
	 * @throws IllegalArgumentException if the given hours are not between 0 and 23
	 * 		| hours < 0 || 23 < hours
	 * 
	 * @post The hours of TimeOfDay equals the given hours
	 * 		| this.getHours() == hours
	 * @post The minutes of TimeOfDay are unchanged
	 * 		| this.getMinutes() == old(this.getMinutes())
	 */
	public void setHours(int hours) {
		//Defensief:
		if (hours < 0 || 23 < hours) {
			throw new IllegalArgumentException("Bad hours");
		}
		minutesSinceMidnight = hours * 60 + getMinutes();
	}
	
	/**
	 * @post | result == getMinutesSinceMidnight() % 60
	 */
	public int getMinutes() { //Dit is een afgeleide getter
		return minutesSinceMidnight % 60;
	}
	
	/**
	 * @post | result == getMinutesSinceMidnight() / 60
	 */
	public int getHours() { //Dit is een afgeleide getter
		return minutesSinceMidnight / 60;
	}
	
	/**
	 * @basic
	 */
	public int getMinutesSinceMidnight() { //Dit is een basis getter
		return minutesSinceMidnight;
	}
}
