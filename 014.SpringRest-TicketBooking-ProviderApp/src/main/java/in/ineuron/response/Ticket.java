package in.ineuron.response;

public class Ticket {
	private String ticketId;
	private String passengerFirstName;
	private String passengerLastName;
	private String from;
	private String to;
	private String journeyDate;
	private String status;
	private String ticketNumber;
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getPassengerFirstName() {
		return passengerFirstName;
	}
	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}
	public String getPassengerLastName() {
		return passengerLastName;
	}
	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerFirstName=" + passengerFirstName + ", passengerLastName="
				+ passengerLastName + ", from=" + from + ", to=" + to + ", journeyDate=" + journeyDate + ", status="
				+ status + ", ticketNumber=" + ticketNumber + "]";
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
