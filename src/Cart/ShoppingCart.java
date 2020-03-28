package Cart;



public class ShoppingCart {

	private int cartID;  
	private String userID;
	private String cartTotal;
	private String bookID;
	private int promoId;
	private int quantity;
	
	public ShoppingCart() {
		
	}
	
	public ShoppingCart(int cartID, String userID, String bookID, String cartTotal, 
			 int promoId, int quantity) {
		super();
		this.cartID = cartID;
		this.userID = userID;
		this.cartTotal = cartTotal;
		this.bookID = bookID;
		this.promoId = promoId;
		this.quantity = quantity;
	}
	
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(String cartTotal) {
		this.cartTotal = cartTotal;
	}
	
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	} 
	public int getPromoId() {
		return promoId;
	}
	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	


	
}