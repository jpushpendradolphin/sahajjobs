<!DOCTYPE html>
<%@ page import="com.pusp.dto.*" %>
<html>
<head>
<link rel="stylesheet" href="css/login.css"></link>
</head>
<body>
<%   
	String loggedInUser =(String)request.getAttribute("user");  
	%> 
<div class="container">

<header>
Hello Mr. <%= loggedInUser %>
</header>
  
<nav>
  <ul>
    <li><a href="Contact.jsp">Contact Us</a></li>
    <li><a href="Logout.jsp">Logout</a></li>
  </ul>
</nav>

<article>
	<%   
	UserDetailsResponse userResponse = (UserDetailsResponse)request.getAttribute("userDetails");
	%> 
	<%if(userResponse != null)
		out.println();
	%>
  	<h1>Your Details are</h1>
  	<table align = "center">
  	<tr>
  	<td>First Name</td>
  	<td><%= userResponse.getfName()%></td>
  	</tr>
  	<tr>
  	<td>Last Name</td>
  	<td><%= userResponse.getlName()%></td>
  	</tr>
  	<tr>
  	<td>Email Name</td>
  	<td><%= userResponse.getEmail()%></td>
  	</tr>
  	<tr>
  	<td>Mobile No</td>
  	<td><%= userResponse.getMobileNo()%></td>
  	</tr>
  	<tr>
  	<td>Location</td>
  	<td><%= userResponse.getLoc()%></td>
  	</tr>
  	<tr>
  	<td>Industry</td>
  	<td><%= userResponse.getIndustry()%></td>
  	</tr>
  	<tr>
  	<td>Skills</td>
  	<td><%= userResponse.getSkills()%></td>
  	</tr>
  	</table>
</article>

<footer>Copyright &copy; chetakjobs.com</footer>

</div>

</body>
</html>
