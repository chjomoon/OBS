package Cart;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import book.Books;

import java.lang.String;
import java.util.Random;

public class ShoppingCartDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public ArrayList<Books> goodsList = null;
	public ArrayList<ShoppingCart> cartList = null;
	public ArrayList<Order> orderList = null;

	public ShoppingCartDAO(){
      try{
          String dbURL = "jdbc:mysql://localhost:3306/BBS1";
          String dbID = "root";
          String dbPassword = "bangkok19";
          
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
          System.out.println("Connected");
      }catch(Exception e){
      	System.out.println("No Connection");
          e.printStackTrace();
      }
	}
  	
	public int addItem(String userID, String bookID, String cartTotal, int promoId, int quantity) {
		int cartID = getRandomNumberInRange(0, 100);
	    getBookList(bookID);
	    String SQL ="INSERT INTO cart VALUES(?, ?, ?, ?, ?, ?)";
	    try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,cartID);
            pstmt.setString(2,userID);
            pstmt.setString(3,bookID);
            pstmt.setString(4,cartTotal);
            pstmt.setInt(5,promoId);
            pstmt.setInt(6,quantity);

            return pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;//db error
	}

	private int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}//getRandomNumberInRange
	
	public ArrayList<ShoppingCart> getShoppingList(String userID){
		cartList = new ArrayList<>();

		String SQL ="SELECT * from cart WHERE userID = ?";
		try{
        	pstmt = conn.prepareStatement(SQL);
        	
        	pstmt.setString(1,userID);
        	rs = pstmt.executeQuery();
        	
        	while(rs.next()) {
        		cartList.add(
        				new ShoppingCart(       						
        				rs.getInt(1), //cartID);
                		rs.getString(2), //title);
                		rs.getString(3),
                		rs.getString(4),
                		rs.getInt(5),
                		rs.getInt(6)
        						)
        				);
				
        	}
		}catch(Exception e){
	        e.printStackTrace();
	    }
		return cartList;
	}
	
	public ArrayList<Books> getBookList(String bookID){
		goodsList = new ArrayList<>();
		String SQL ="SELECT * from BOOK WHERE bookID = ?";
		try{
        	pstmt = conn.prepareStatement(SQL);
        	
        	pstmt.setString(1,bookID);
        	rs = pstmt.executeQuery();
        	
        	while(rs.next()) {
        		goodsList.add(
        				new Books(
        				rs.getString(1), //bookID);
                		rs.getString(2), //title);
                		rs.getString(3),
                		rs.getString(4),
                		rs.getString(5),
                		rs.getString(6),
                		rs.getString(7),
                		rs.getInt(8),
                		rs.getInt(9),
                		rs.getInt(10)
        						)
        				);
        	}
		}catch(Exception e){
	        e.printStackTrace();
	    }
		return goodsList;
    }//getBookList
	
	public ArrayList<Order> getOrderList(String userID){
		orderList = new ArrayList<>();
		String SQL ="SELECT * from transactions WHERE userID = ?";
		try{
        	pstmt = conn.prepareStatement(SQL);
        	
        	pstmt.setString(1,userID);
        	rs = pstmt.executeQuery();
        	
        	while(rs.next()) {
        		orderList.add(
        				new Order(
        				rs.getString(1), //bookID);
                		rs.getString(2), //title);
                		rs.getString(3),
                		rs.getString(4),
                		rs.getString(5),
                		rs.getString(6),
                		rs.getString(7)
        						)
        				);
        	}
		}catch(Exception e){
	        e.printStackTrace();
	    }
		return orderList;
    }//getBookList
	
	public int placeOrder(String isbn, String userID, String orderDate, String shippingDate, String cardNum, int totalPrice) {
		int order = getRandomNumberInRange(1000, 9999);
		String SQL ="INSERT INTO transactions VALUES(?, ?, ?, ?, ?, ?,?)";
	    try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,order);
            pstmt.setString(2,isbn);
            pstmt.setString(3,userID);
            pstmt.setString(4,orderDate);
            pstmt.setString(5,shippingDate);
            pstmt.setString(6,cardNum);
            pstmt.setInt(7,totalPrice);

            return pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        
        return-1;
		
	}
	
}//ShoppingCartDAO