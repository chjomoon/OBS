package Promo;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import book.Books;

import java.lang.String;
import java.util.Random;

import Cart.Order;
import Cart.ShoppingCart;

public class PromoDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public ArrayList<Promotion> promoList = null;

	public PromoDAO(){
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
  	
	public int addCode(int promoID, String name, double percentage, int dollarOff, String startDate, String expDate,
			String code) {
		int cartID = getRandomNumberInRange(0, 100);
	    String SQL ="INSERT INTO promotions VALUES(?, ?, ?, ?, ?, ?, ?)";
	    try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,cartID);
            pstmt.setString(2,name);
            pstmt.setDouble(3,percentage);
            pstmt.setInt(4,dollarOff);
            pstmt.setString(5,startDate);
            pstmt.setString(6,expDate);
            pstmt.setString(6,code);

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
	
	public ArrayList<Promotion> getPromoList(){
		promoList = new ArrayList<>();

		String SQL ="SELECT * from cart";
		try{
        	pstmt = conn.prepareStatement(SQL);
        	
        	//pstmt.setInt(1,promoID);
        	rs = pstmt.executeQuery();
        	
        	while(rs.next()) {
        		promoList.add(
        				new Promotion(       						
        				rs.getInt(1), //cartID);
                		rs.getString(2), //title);
                		rs.getDouble(3),
                		rs.getInt(4),
                		rs.getString(5),
                		rs.getString(6),
                		rs.getString(7)
        						)
        				);
				
        	}
		}catch(Exception e){
	        e.printStackTrace();
	    }
		return promoList;
	}
	
}
