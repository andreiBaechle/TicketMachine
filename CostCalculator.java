package hw2;

/**
 * @author Andrei Baechle
 *         A CostCalculator calculates parking rates for the parking
 *         garage.
 */
public class CostCalculator extends java.lang.Object {
	/**
	 * Maximum allowed time in minutes between payment of a ticket and exit from the
	 * garage.
	 */
	public static final int EXIT_TIME_LIMIT = 10;

	/**
	 * Returns the cost of parking for the given total number of minutes, based on
	 * the current rates for the garage.
	 * 
	 * @param minutes-
	 *            number of minutes parked
	 * @return- cost for parking the given number of minutes
	 */
	public static double calculateCost(int minutes) {
		double cost = 0;
		
		while (minutes > 1440) {
			minutes-= 1440;
			cost = cost + 15.00;
		}
		if (minutes > 600) {
			cost += 15.00;
		} else if (minutes > 300 && minutes <= 600) {
			cost += 11.00;
		} else if (minutes > 240 && minutes <= 300) {
			cost = 8.00;
		} else if (minutes > 180 && minutes <= 240) {
			cost += 6.50;
		} else if (minutes > 120 && minutes <= 180) {
			cost += 5.00;
		} else if (minutes > 60 && minutes <= 120) {
			cost += 3.50;
		} else if (minutes > 30 && minutes <= 60) {
			cost += 2.00;
		} else if (minutes > 15 && minutes <= 30) {
			cost += 0.50;
		} else {
			cost += 0.00;
		}

		return cost;

	}

}
