<%@page import="java.sql.SQLException"%>
<%@page import="com.atmecs.daos.TechTalkdaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.atmecs.pojo.*" %>
    <%@ page import="java.util.List"  isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}%>
Hello, <%=session.getAttribute("username")%>
<form action="TechTalk" method="POST">
<% 	TechTalkdaoImpl techTalkDao = new TechTalkdaoImpl();
try {
	List<Talks> techTalks = techTalkDao.getTechTalks();
	pageContext.setAttribute("list", techTalks);
} catch (SQLException e) {
	e.printStackTrace();
}%>
 <table border="1">
   <thead>
      <tr>
      <td>Date</td>
      <td>TechTalk</td>
      <td>Presentator</td>
      </tr>
   </thead>
   <tbody>

	  <c:forEach var="talk" items="${list}">
                <tr>
                    <td><c:out value="${talk.date}" /></td>
                    <td><c:out value="${talk.techTalk}" /></td>
                    <td><c:out value="${talk.presentator}" /></td>
                </tr>
      </c:forEach>
  </tbody>
 </table>
 </form>
 <a href="logout.jsp">logout</a>
 <a href="addTechTalk.jsp">Add Your Talk</a>

</body>
</html>