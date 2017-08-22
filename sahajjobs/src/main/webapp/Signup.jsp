<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/login.css"></link>
<script src="js/login.js"></script>
</head>
<body>

<div class="container">

<header>
Signup Page
</header>
  
<nav>
  <ul>
    <li><a href="Home.jsp">Home</a></li>
    <li><a href="Contact.jsp">Contact Us</a></li>
  </ul>
</nav>

<article style = "text-align : center">
  <h1>Welcome To Signup Page</h1>
  <form action = "signup" method = "post" name = "signUpForm">
  <table align = "center">
  <tr>
  <td>FirstName</td>
  <td><input type = "text" name = "fName"/></td>
  <td>LastName</td>
  <td><input type = "text" name = "lName"/></td>
  </tr>
  <tr>
  <td>Password</td>
  <td><input type = "password" name = "pass"/></td>
  <td>RePassword</td>
  <td><input type = "text" name = "repass"/></td>
  </tr>
  <tr>
  <td>Email Address</td>
  <td><input type = "text" name = "email"/></td>
  <td>Mobile#</td>
  <td><input type = "text" name = "mobile"/></td>
  </tr>
  <tr>
  <td>Current Location</td>
  <td>
  <select name = "location">
    <option value="Hyderabad">Hyderabad</option>
    <option value="Bengalore">Bengalore</option>
    <option value="Kolkata">Kolkata</option>
    <option value="Delhi">Delhi</option>
    <option value="Chenai">Chenai</option>
  </select>
  </td>
  <td>Total Experience</td>
  <td>
  <select name = "experience">
    <option value="0">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
  </select>
  </td>
  </tr>
  <tr>
  <td>Key Skills</td>
  <td>
  <select name = "skills">
    <option value="java">Java</option>
    <option value=".net">.Net</option>
    <option value="Testing">Testing</option>
  </select>
  </td>
  </tr>
  <tr>
  <td>Industry</td>
  <td>
  <select name = "industry">
    <option value="IT">IT</option>
    <option value="NonIt">NonIt</option>
    <option value="BPO">BPO</option>
  </select>
  </td>
  </tr>
  <tr>
  <!-- <td>Upload Resume</td>
  <td><input type = "file" value = "Upload Resume"/></td> -->
  </tr>
  <tr>
  <td><input type = "submit" value = "Login"/></td>
  </tr>
  </table>
  </form>
</article>

<footer>Copyright &copy; chetakjobs.com</footer>

</div>

</body>
</html>
