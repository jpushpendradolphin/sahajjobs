<!DOCTYPE html>
<%@ page import="com.pusp.dto.*" %>
<html>
<head>
<link rel="stylesheet" href="css/login.css"></link>
</head>
<body>

<div class="container">

<header>
Profile Page
</header>
  
<nav>
  <ul>
    <li><a href="Login.jsp">Login</a></li>
    <li><a href="Signup.jsp">SignUp</a></li>
    <li><a href="Contact.jsp">Contact Us</a></li>
    <li><a href="Logout.jsp">Logout</a></li>
  </ul>
</nav>

<article>
	<%   
	String user =(String)request.getAttribute("user");  
	SignUpRequestDto requestDto = (SignUpRequestDto)request.getAttribute("signUpRequest");
	%> 
  <h1 style = "color : green; text-align : center">Hello Mr <%= user %></h1>
  	You Are Registered with Following Details
  	<table>
  	<tr>
  	<td>First Name</td>
  	<td><%= requestDto.getfName()%></td>
  	</tr>
  	<tr>
  	<td>First Name</td>
  	<td><%= requestDto.getlName()%></td>
  	</tr>
  	<tr>
  	<td>First Name</td>
  	<td><%= requestDto.getEmail()%></td>
  	</tr>
  	<tr>
  	<td>First Name</td>
  	<td><%= requestDto.getMobile()%></td>
  	</tr>
  	<tr>
  	<td>First Name</td>
  	<td><%= requestDto.getLocation()%></td>
  	</tr>
  	<tr>
  	<td>First Name</td>
  	<td><%= requestDto.getIndustry()%></td>
  	</tr>
  	<tr>
  	<td>First Name</td>
  	<td><%= requestDto.getSkills()%></td>
  	</tr>
  	</table>
</article>

<footer>Copyright &copy; chetakjobs.com</footer>

</div>

</body>
</html>
