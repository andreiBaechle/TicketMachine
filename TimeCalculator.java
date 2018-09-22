package hw2;

/**
 * A TimeCalculator serves as a simple clock counter to simulate the passage of time. Time is assumed 
 * to be in minutes, represented as a single integer.
 * @author Andrei Baechle 
 */
public class TimeCalculator {
	
	private int clock;
	
	/**
	 * Constructs a new clock with a current time of zero.
	 */
	public TimeCalculator() {
	clock = 0;
		
	}
	
	/**
	 * Returns this clock's current time.
	 * @return- the current time
	 */
	public int getTime() {
		return clock;
	}
	
	/**
	 * Simulates the passage of time for the given number of minutes.
	 * @param minutes- number of minutes to be added to this clock's time
	 */
	public void passageOfTime(int minutes) {
		clock += minutes;
	}
	
	/**
	 * Simulates the passage of time for the given hours and minutes.
	 * @param hours- number of hours to be added
	 * @param minutes- number of minutes to be added
	 */
	public void passageOfTime(int hours, int minutes) {
		hours = hours * 60;
		clock = clock + hours + minutes;
	}

}
