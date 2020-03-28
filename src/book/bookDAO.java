package book;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

import book.Books;
import user.User;


public class bookDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    public ArrayList<Books> goodsList = null;
    public bookDAO(){
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
    /*
    public String findInfo(String bookID, String info) {
    	String SQL ="select * from BOOK WHERE bookID =?";
    	try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, bookID);
            rs = pstmt.executeQuery();
            if(rs.next()){
            	String result =rs.getString(info);
            	return result;
            }
    	}catch(Exception e){
            e.printStackTrace();
        }
    	return null;
    }
    */
    //Find book by isbn
    public String[] findInfo(String info, int method) {
    	
        String SQL = "";
        //Find by BookID
        if(method == 1){
            SQL ="SELECT * from books WHERE bookID = ?";
        }
        //Find by ISBN
        else if(method == 2){
            SQL ="SELECT * from books WHERE isbn = ?";
        }
        //Find by Category
        else if(method == 3){
            SQL ="SELECT * from books WHERE category = ?";
        }
        //Find by Author
        else if(method == 4){
            SQL ="SELECT * from books WHERE author = ?";
        }
        //Find by Title
        else if(method == 5){
            SQL ="SELECT * from books WHERE title = ?";
        }
        //Find by Publisher
        else if(method == 6){
            SQL ="SELECT * from books WHERE publisher = ?";
        }
        //Find by year published
        else if(method == 7){
            SQL ="SELECT * from books WHERE yearPublished = ?";
        }else {
            SQL ="SELECT * from books";
        }
        try{
        	pstmt = conn.prepareStatement(SQL);
        	
        	pstmt.setString(1,info);
        	rs = pstmt.executeQuery();
        	
        	while(rs.next()) {
        		String[] result = {"","","","","","","","","",""};
        		
        		System.out.println(result[0] = rs.getString(1)); //bookID);
        		System.out.println(result[1] = rs.getString(2)); //title);
        		System.out.println(result[2] = rs.getString(3)); //isbn
        		System.out.println(result[3] = rs.getString(4)); //category);
        		System.out.println(result[4] = rs.getString(5)); //author);
        		System.out.println(result[5] = rs.getString(6)); //publisher);
        		System.out.println(result[7] = rs.getString(8)); //edition);
        		System.out.println(result[8] = rs.getString(9)); //quantity);
        		System.out.println(result[9] = rs.getString(10)); //price);
        		

        		return result;
				
        	}
		}catch(Exception e){
	        e.printStackTrace();
	    }
        return null;
    }//findInfo

    
    public int addBook(Books book){
        String SQL ="INSERT INTO BOOK VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,book.getBookID());
            pstmt.setString(2,book.getTitle());
            pstmt.setString(3,book.getIsbn());
            pstmt.setString(4,book.getCategory());
            pstmt.setString(5,book.getAuthor());
           
            pstmt.setString(6,book.getPublisher());
            pstmt.setString(7,book.getYearPublished());
            pstmt.setInt(8,book.getEdition());
            pstmt.setInt(9,book.getQuantity());
            pstmt.setInt(10, book.getPrice());

            return pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;//db error
    }
    
    public int updateBook(Books book, String bookID) {
    	String SQL = "UPDATE BOOK SET isbn=?, category=?, author=?, title=?, publisher=?,yearPublished=?, edition=?,quantity=?,price=? WHERE bookID=?";
        try {
            pstmt = conn.prepareStatement(SQL);
        	pstmt.setString(1, book.getIsbn());
        	pstmt.setString(2, book.getCategory());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4,book.getTitle());
            pstmt.setString(5,book.getPublisher());
            pstmt.setString(6,book.getYearPublished());
            pstmt.setInt(7, book.getEdition());
            pstmt.setInt(8, book.getQuantity());
            pstmt.setInt(9, book.getPrice());
            pstmt.setString(10, bookID);
            
            return pstmt.executeUpdate();
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1; //db error
    }
    
    public int deleteBook(String bookID) {
    	String SQL = "DELETE FROM BOOK WHERE bookID =?";
    	try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, bookID);
            return pstmt.executeUpdate();
    	}catch (Exception e){
            e.printStackTrace();
        }
    	return -1;//db error
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

    }
}
