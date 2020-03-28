<%--
  Created by IntelliJ IDEA.
  User: chanjo
  Date: 2019-07-10
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>   
<%@ page import ="java.io.PrintWriter" %>
<%@ page import ="java.util.ArrayList" %>     
<%@ page import ="user.userDAO" %>
<%@ page import ="Email.EmailSender" %>
<%@ page import ="java.io.PrintWriter" %>
<%@ page import = "java.time.LocalDate"%>
<%@ page import ="java.time.format.DateTimeFormatter"%>
<%@ page import = "java.time.format.FormatStyle" %>
<%@ page import ="Cart.ShoppingCart" %>
<%@ page import ="Cart.ShoppingCartDAO" %>
<%@ page import ="java.util.ArrayList" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="user.User" scope = "page"></jsp:useBean>
<jsp:setProperty name="user" property="userID"></jsp:setProperty>
<jsp:setProperty name="user" property="userPassword"></jsp:setProperty>
<jsp:setProperty name="user" property="userEmail"></jsp:setProperty>
<jsp:setProperty name="user" property="userFirstName"></jsp:setProperty>
<jsp:setProperty name="user" property="userLastName"></jsp:setProperty>
<jsp:setProperty name="user" property="userAddr"></jsp:setProperty>
<jsp:setProperty name="user" property="ccName"></jsp:setProperty>
<jsp:setProperty name="user" property="ccNum"></jsp:setProperty>
<jsp:setProperty name="user" property="ccExp"></jsp:setProperty>
<jsp:setProperty name="user" property="ccCvv"></jsp:setProperty>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <title>Checkout Processing</title>
</head>
<body>
<%
	String userID = null;
	String userEmail = null;
	if(session.getAttribute("userID")!=null){
		userDAO userDAO = new userDAO();
	    userID = (String) session.getAttribute("userID");
	    userEmail =userDAO.findInfo(userID, "userEmail");
	}
    LocalDate localDate = LocalDate.now();
    String formattedDate = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));	
	
   	ShoppingCartDAO ShoppingCartDAO = new ShoppingCartDAO();
   	
   	Object imObject = session.getAttribute("totalPrice");
   	Integer totalPrice = (Integer) imObject;
    System.out.println("Total Price is $"+totalPrice);

    //System.out.println("Total Price is $"+session.getAttribute("totalPrice"));
    System.out.println("Book ISBN : "+session.getAttribute("isbn"));
	System.out.println("Card Number : "+session.getAttribute("ccNum"));
    
    
	int order = ShoppingCartDAO.placeOrder((String)session.getAttribute("isbn"), userID, formattedDate, formattedDate, (String)session.getAttribute("ccNum"),totalPrice);
    if(order == -1){
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('DB Erro')");
        script.println("history.back()"); //go back to login page
        script.println("</script>");
    }else{
        //session.setAttribute("userID", user.getUserID());
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("location.href = 'checkoutDone.jsp'"); //go back to login page
        script.println("</script>");
    }
	    
    
    EmailSender emailSender = new EmailSender();
    emailSender.sendEmail(userEmail,"","");
    
    
%>


</body>
</html>
