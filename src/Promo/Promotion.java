package Promo;

public class Promotion {

	private int promoID;
	private String promoName;
	private double percentage;
	private int dollarOff;
	private String startDate;
	private String expDate;
	private String code;
	
	public Promotion() {
		
	}
	public Promotion(int promoID, String promoName, double percentage, int dollarOff, String startDate, String expDate,
			String code) {
		super();
		this.promoID = promoID;
		this.promoName = promoName;
		this.percentage = percentage;
		this.dollarOff = dollarOff;
		this.startDate = startDate;
		this.expDate = expDate;
		this.code = code;
	}
	public int getPromoID() {
		return promoID;
	}
	public void setPromoID(int promoID) {
		this.promoID = promoID;
	}
	public String getPromoName() {
		return promoName;
	}
	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public int getDollarOff() {
		return dollarOff;
	}
	public void setDollarOff(int dollarOff) {
		this.dollarOff = dollarOff;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

		
	
	
}
