package Cart;

public class Order {

	private String transactionID;
	private String isbn;
	private String userID;
	private String orderDate;
	private String shippingDate;
	private String cardNumber;
	private String totalPrice;
	
	public Order() {
		
	}
	public Order(String transactionID, String isbn, String userID, String orderDate, String shippingDate,
			String cardNumber, String totalPrice) {
		super();
		this.transactionID = transactionID;
		this.isbn = isbn;
		this.userID = userID;
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.cardNumber = cardNumber;
		this.totalPrice = totalPrice;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
	
}
