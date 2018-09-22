package hw2;

/**
 * @author KEYmaster A TicketMachine has methods allowing a Ticket object to be
 *         updated to show when payment is made. There is a method
 *         insertTicket() to simulate inserting a ticket into the machine. At
 *         that point a transaction is said to be "in progress", and the
 *         transactionInProgress() method returns true, until a subsequent call
 *         to ejectTicket(). The amount due for parking can be obtained from the
 *         method getPaymentDue(). The method makePayment() finally updates the
 *         Ticket object to record the time of payment. (We assume that all
 *         payments are by credit/debit and are successful.) In addition, the
 *         TicketMachine includes an accumulator that records the total amount
 *         of money paid into the machine since it was initialized.
 */
public class TicketMachine {

	private TimeCalculator clock;

	private Ticket ticket;

	private double totalPay;

	private boolean tInP;

	/**
	 * Constructs a TicketMachine that will use the given clock to determine the
	 * current time.
	 * 
	 * @param givenClock-
	 *            clock to be used by this machine.
	 */
	public TicketMachine(TimeCalculator givenClock) {
		clock = givenClock;
		tInP = false;

	}

	/**
	 * Simulates inserting the given ticket into this machine. The method checks if
	 * the ticket is a valid ticket. If it is not, it ejects the ticket. If a
	 * transaction is already in progress, this method does nothing.
	 * 
	 * @param t-
	 *            ticket to be inserted
	 */
	public void insertTicket(Ticket t) {
		ticket = t;
		if (!tInP) {
			tInP = true;
		}
	}

	/**
	 * Determines whether a ticket is currently in this machine.
	 * 
	 * @return-Determines whether a ticket is currently in this machine.
	 */
	public boolean transactionInProgress() {
		return tInP;
	}

	/**
	 * Returns the payment due for the ticket currently in the machine. If no
	 * transaction is in progress, returns 0.0. This method does not modify the
	 * Ticket object or update this machine's total payments. The payment due is
	 * based the current time (according to this machine's clock) and on the entry
	 * time and payment time for the current ticket. The basic amount due is the
	 * result of calling CostCalculator.calculateCost() for the difference (current
	 * time less start time). However, if the payment time is nonzero (indicating
	 * that some payment was already made), the cost of parking from entry time to
	 * payment time (i.e., the amount that must have already been paid) is
	 * subtracted from the amount due.
	 * 
	 * @return- payment due for the ticket currently in the machine
	 */
	public double paymentDue() {
		if (tInP && ticket.getPaymentTime() == 0) {
			return CostCalculator.calculateCost(clock.getTime() - ticket.getEntryTime());
		} else if (tInP && ticket.getPaymentTime() != 0) {
			return CostCalculator.calculateCost(clock.getTime() - ticket.getEntryTime())
					- CostCalculator.calculateCost(ticket.getPaymentTime() - ticket.getEntryTime());
		} else {
			return 0.0;
		}
	}

	/**
	 * Simulates ejecting the ticket from this machine. Has no effect if no
	 * transaction is in progress.
	 */
	public void ejectTicket() {
		tInP = false;
	}

	/**
	 * Updates the current ticket with the payment time and adds the payment amount
	 * to this machine's total. If there is no transaction in progress, this method
	 * has no effect.
	 */
	public void makePayment() {
		totalPay += paymentDue();
		ticket.setTicketPaymentTime(clock.getTime());
	}

	/**
	 * Returns the ticket currently in this machine, or null if there is none.
	 * 
	 * @return- ticket currently in this machine, or null
	 */
	public Ticket getCurrentTicket() {
		if (tInP == true) {
			return ticket;
		}
		return null;
	}

	/**
	 * Returns the total payments made at this machine.
	 * 
	 * @return- total payments
	 */
	public double getTotalPaymentsOnMachine() {
		return totalPay;
	}

}
