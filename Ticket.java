package hw2;

/**
 * 
 * @author KEYmaster A Ticket models a parking ticket that records the time of
 *         entry, the time of payment and validation of ticket. Time is assumed
 *         to be represented in minutes as a single integer.
 */
public class Ticket {

	private int startT;

	private int payT;

	private boolean valid;

	/**
	 * Constructs a ticket with the given start time and a payment time of zero.
	 * 
	 * @param givenStartTime-
	 *            start time for this ticket
	 */
	public Ticket(int givenStartTime) {
		startT = givenStartTime;
		payT = 0;
		valid = false;

	}

	/**
	 * Returns the start time for this ticket.
	 * 
	 * @return- the start time of this ticket
	 */
	public int getEntryTime() {
		return startT;
	}

	/**
	 * Returns the payment time for this ticket.
	 * 
	 * @return- payment time for the ticket
	 */
	public int getPaymentTime() {
		return payT;
	}

	/**
	 * Sets the payment time for this ticket.
	 * 
	 * @param givenPaymentTime-
	 *            time to be set
	 */
	public void setTicketPaymentTime(int givenPaymentTime) {
		payT = givenPaymentTime;
	}

	/**
	 * Returns if the ticket is valid or not.
	 * 
	 * @return- true if ticket is valid, false otherwise
	 */
	public boolean ticketValid() {
		return valid;
	}

	/**
	 * Sets the ticket validation to given validation.
	 * 
	 * @param givenValid-
	 *            boolean variable that sets the value of ticket valid
	 */
	public void setValid(boolean givenValid) {
		valid = givenValid;
	}

}
