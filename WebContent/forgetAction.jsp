<%--
  Created by IntelliJ IDEA.
  User: chanjo
  Date: 2019-07-10
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8" %>
<%@ page import ="user.userDAO" %>
<%@ page import ="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="user.User" scope = "page"></jsp:useBean>
<jsp:setProperty name="user" property="userID"></jsp:setProperty>
<jsp:setProperty name="user" property="userName"></jsp:setProperty>
<jsp:setProperty name="user" property="userEmail"></jsp:setProperty>
<jsp:setProperty name="user" property="userPassword"></jsp:setProperty>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <title>Login Processing</title>
</head>
<body>
    <%
        String userID =user.getUserID();
    	String userName = user.getUserName();
    	String userEmail = user.getUserEmail();
		
        userDAO userDAO = new userDAO();
        System.out.println(userID +" "+ userName);
        int result = userDAO.findPasswd(userID, userName, userEmail);
        if(result == 1){
        	System.out.println("Success");
        	String passwd = user.getUserPassword();
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('Password has been found')");
            script.println("location.href = 'login.jsp'"); //go back to login page 
            script.println("</script>");
            System.out.println("Your Password is "+passwd);
        }else if(result == 0){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('Wrong information')");
            script.println("history.back()"); //go back to login page
            script.println("</script>");
        }else if(result == -1){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('No ID can be found')");
            script.println("history.back()"); //go back to login page
            script.println("</script>");
        }else if(result == -2){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('DB error has been occurred')");
            script.println("history.back()"); //go back to login page
            script.println("</script>");
        }

    %>


</body>
</html>
