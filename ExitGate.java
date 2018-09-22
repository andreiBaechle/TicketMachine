package hw2;

/**
 * @author KEYmaster An ExitGate checks a ticket and determines whether its
 *         payment time allows the holder to exit.
 */
public class ExitGate {

	private TimeCalculator clock;

	private int carsExited = 0;


	/**
	 * Constructs an ExitGate that will use the given clock.
	 * 
	 * @param givenClock-
	 *            clock to be used by this machine
	 */
	public ExitGate(TimeCalculator givenClock) {
		clock = givenClock;
	}

	/**
	 * Returns true if ticket is paid and the car is exiting within EXIT_TIME_LIMIT
	 * minutes of payment, otherwise returns false. Always returns false if payment
	 * time is zero. It also sets the ticket to invalid if it is paid and the car
	 * exits.
	 * 
	 * @param t-
	 *            ticket whose payment time is to be checked
	 * @return- true if payment time is within EXIT_TIME_LIMIT minutes current time,
	 *          false otherwise
	 */
	public boolean checkTicket(Ticket t) {
       int timeLim = clock.getTime() - t.getPaymentTime();
		if (t.getPaymentTime() == 0) {
			return false;
		} if (timeLim > 0 && timeLim <= CostCalculator.EXIT_TIME_LIMIT) {
			carsExited++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the total number of cars that successfully exited the gate though the
	 * machine. A successful exit is a call to checkTicket() that returned true.
	 * 
	 * @return- number of successful exits
	 */
	public int carsExited() {

		return carsExited;
	}

}
