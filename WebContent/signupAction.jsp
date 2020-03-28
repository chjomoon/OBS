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
<%@ page import ="Email.EmailSender" %>
<%@ page import ="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="user.User" scope = "page"></jsp:useBean>
<jsp:setProperty name="user" property="userID"></jsp:setProperty>
<jsp:setProperty name="user" property="userPassword"></jsp:setProperty>
<jsp:setProperty name="user" property="userEmail"></jsp:setProperty>
<jsp:setProperty name="user" property="userName"></jsp:setProperty>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <title>Login Processing</title>
</head>
<body>
    <%
        String userID = null;
    	String userEmail = null;
        if(session.getAttribute("userID")!=null){
            userID = (String) session.getAttribute("userID");
            userEmail =(String) session.getAttribute("userEmail");
            PrintWriter script = response.getWriter();
        }
        if(userID != null){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('Already Logged in')");
            script.println("location.href = 'index.jsp"); //go back to login page
            script.println("</script>");
        }
        if(user.getUserID()==null||user.getUserPassword()==null){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('You should submit all the information to process registration.')");
            script.println("history.back()"); //go back to login page
            script.println("</script>");
        } else{
            userDAO userDAO = new userDAO();
            int result = userDAO.signUp(user);
            if(result == -1){
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("alert('Existing ID')");
                script.println("history.back()"); //go back to login page
                script.println("</script>");
            }else{
                //session.setAttribute("userID", user.getUserID());
                PrintWriter script = response.getWriter();
                
                EmailSender emailSender = new EmailSender();
                emailSender.sendEmail(userEmail,"","");
                
                script.println("<script>");
                script.println("location.href = 'confirm.jsp'"); //go back to login page
                script.println("</script>");
            }
        }


    %>


</body>
</html>
