package in.ineuron.request;

public class PassengerInfo {
	private String passengerFirstName;
	private String passengerLastName;
	private String from;
	private String to;
	private String journeyDate;
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
	@Override
	public String toString() {
		return "PassengerInfo [passengerFirstName=" + passengerFirstName + ", passengerLastName=" + passengerLastName
				+ ", from=" + from + ", to=" + to + ", journeyDate=" + journeyDate + "]";
	}
	public PassengerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
