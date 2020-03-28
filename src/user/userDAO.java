package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class userDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public userDAO(){
        try{            
            String dbURL = "jdbc:mysql://localhost:3306/bbs1";
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
    public int login(String userID, String userPassword){
        String SQL = "SELECT userPassword, role From USER WHERE userID = ?";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                //if password matching with the database in mysql
                if(rs.getString(1).equals(userPassword)&& rs.getInt(2)==2){
                    return 2; //login success
                }else if (rs.getString(1).equals(userPassword) ){
                	return 1;
                }else if (rs.getInt(12)==0){
                	return -3;
                }else{
                    return 0; //wrong password
                }
            }
            return -1; //No User Info
        }catch(Exception e){
            e.printStackTrace();
        }
        return -2; //Data Base Error
    }

    public String findInfo(String userID, String info) {
    	String SQL ="select * from USER WHERE userID =?";
    	try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
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
    //public
    public int findPasswd(String userID, String userFirstName, String userLastName, String userEmail){
        String SQL = "SELECT userFirstName, userLastName, userEmail From USER WHERE userID = ?";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                //if password matching with the database in mysql
                if(rs.getString(1).equals(userFirstName) && rs.getString(2).equals(userLastName) && rs.getString(3).equals(userEmail)){
                    return 1; //Find success
                }
                else{
                    return 0; //wrong Information
                }
            }
            return -1; //No User Info
        }catch(Exception e){
            e.printStackTrace();
        }
        return -2; //Data Base Error
    }
    public int signUp(User user){
        String SQL ="INSERT INTO USER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,user.getUserID());
            pstmt.setString(2,user.getUserPassword());
            pstmt.setString(3,user.getUserFirstName());
            pstmt.setString(4,user.getUserLastName());
            pstmt.setString(5,user.getUserEmail());
            pstmt.setString(6,user.getUserAddr());
            pstmt.setString(7,user.getCcName());
            pstmt.setInt(8,user.getCcNum());
            pstmt.setInt(9, user.getCcExp());
            pstmt.setInt(10, user.getCcCvv());
            pstmt.setInt(11,0);
            pstmt.setString(12,randomString());

            System.out.println(user.getUserID());
            System.out.println(user.getUserPassword());

            return pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;//db error
    }

    
    public int updateUser(User user, String id) {
    	String SQL = "UPDATE USER SET userPassword=?, userFirstName=?, userLastName=?, userAddr=?, ccName=?,ccNum=?, ccExp=?,ccCvv=? WHERE userID=?";
        try {
            pstmt = conn.prepareStatement(SQL);
        	pstmt.setString(1, user.getUserPassword());
        	pstmt.setString(2, user.getUserFirstName());
            pstmt.setString(3, user.getUserLastName());
            pstmt.setString(4,user.getUserAddr());
            pstmt.setString(5,user.getCcName());
            pstmt.setInt(6,user.getCcNum());
            pstmt.setInt(7, user.getCcExp());
            pstmt.setInt(8, user.getCcCvv());
            pstmt.setString(9, id);
            
            System.out.println("New Password: "+user.getUserPassword());
            
            return pstmt.executeUpdate();
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1; //db error
    }

    /*
    *THIS IS NOT OUR CODE. Credit to GeeksForGeeks for code used
    * https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
    * Accessed July 24, 2019
    *
    * Generates a string of random characters. Used in confirmation email
     */
    private String randomString(){
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz"
                + "~!@#$%&*";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        System.out.println("Random Code : "+sb.toString());
        return sb.toString();
    }//randomString
    
    public int activate(String userID, String code){
        String SQL = "SELECT userCode, role From USER WHERE userID = ?";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                //if password matching with the database in mysql
                if(rs.getString(12).equals(code)&& rs.getInt(2)==0){
                    return 1; //activation success
                }
                else
                    return 0;
            }
            return -1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -2;
    }

}
