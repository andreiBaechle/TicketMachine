package hw2;

/**
 * @author Andrei Baechle
 *         An EntryGate generates new tickets having a start time
 *         determined by the internal clock.
 */
public class EntryGate {

	private TimeCalculator clock;

	private Ticket ticket;

	private int count;

	/**
	 * Constructs an EntryGate that will use the given clock.
	 * 
	 * @param givenClock-
	 *            clock to be used by this machine
	 */
	public EntryGate(TimeCalculator givenClock) {
		clock = givenClock;
	}

	/**
	 * Returns a newly constructed ticket whose start time is the current time
	 * according to this machine's clock. The ticket is also set to a valid ticket.
	 * 
	 * @return- new ticket object
	 */
	public Ticket takeTicket() {
		ticket = new Ticket(clock.getTime());
		ticket.setTicketPaymentTime(0);
		count++;
		return ticket;
	}

	/**
	 * Returns the total number of cars that successfully entered the gate though
	 * the machine. A successful entry is the number of times takeTicket() has been
	 * called.
	 * 
	 * @return- number of successful exits
	 */
	public int carsEntered() {
		return count;
	}

}
