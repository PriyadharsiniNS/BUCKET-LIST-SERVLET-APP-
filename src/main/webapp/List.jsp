<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your List</title>
</head>
<body>
	<H1 style="text-align:center">List</H1>
	<%--<c:forEach var="item" 
	items="${Items}">
	<c:out value="${item}"/><br>
	</c:forEach>--%>
       <%
       		try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BucketList2","postgres","GanHari@74");
           Statement statement = connection.createStatement() ;
           ResultSet resultset = statement.executeQuery("select * from bucketlist") ;
       %>
      <TABLE BORDER="1">
      
      <TR>
      <TH>List ID</TH>
      <TH>List Type</TH>
      <TH>Description</TH>
      <TH>List Priority</TH>
     
      </TR>
     <% while(resultset.next()){ %>
      <TR>
       <TD> <%= resultset.getInt(1) %></td>
       <TD> <%= resultset.getString(2) %></TD>
       <TD> <%= resultset.getString(3) %></TD>
       <TD> <%= resultset.getInt(4) %></TD>

      </TR>
      <% } %>
     </TABLE>
</body>
</html>