<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List By Type</title>
</head>
<body>
	<%
       		try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BucketList2","postgres","GanHari@74");
           Statement statement = connection.createStatement() ;
           String s = "select * from bucketlist where list_type = 'Learn Python';";
           ResultSet resultset = statement.executeQuery(s) ;
       %>
       
       <h1 style="text-align" : center>LIST BY TYPE</h1>
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