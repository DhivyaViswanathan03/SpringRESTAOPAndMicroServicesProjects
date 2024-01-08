package in.ineuron.response;

public class CurrencyResponse {

	private Integer currencyId;
	private String currencyFrom;
	private String currencyTo;
	private Integer currencyValue;
	
	public CurrencyResponse() {
		
	}
	public Integer getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrencyFrom() {
		return currencyFrom;
	}
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}
	public String getCurrencyTo() {
		return currencyTo;
	}
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}
	public Integer getCurrencyValue() {
		return currencyValue;
	}
	public void setCurrencyValue(Integer currencyValue) {
		this.currencyValue = currencyValue;
	}
	
	
	

}
