/**
 * js file here
 */

	function validateForm() {
	    var uname = document.forms["loginForm"]["uname"].value;
	    var pass = document.forms["loginForm"]["pass"].value;
	    if (uname == "" || uname == undefined) {
	        alert("User Name must be filled out");
	        return false;
	    }
	    
	    if (pass == "" || pass == undefined) {
	        alert("Password must be filled out");
	        return false;
	    }
	}
	
	function validateSignUpForm()
	{
		
		var fName = document.forms["signUpForm"]["fName"].value;
		if(fName == "" || fName == undefined)
		{
			alert("First Name must be filled out");
			return false;
		}
		
		var pass = document.forms["signUpForm"]["pass"].value;
		var repass = document.forms["signUpForm"]["repass"].value;
		if(pass != repass)
		{
			alert("Password and Repassword Should Match");
			return false;
		}
		var email = document.forms["signUpForm"]["email"].value;
		var atpos = email.indexOf("@");
	    var dotpos = email.lastIndexOf(".");
		if(atpos<1 || dotpos<atpos+2 || dotpos+2 >= email.length)
		{
			alert("Please Enter a valid Email");
			return false;
		}
		
		var mobile = document.forms["signUpForm"]["mobile"].value;
		if(mobile = "" || mobile == undefined)
		{
			alert("mobile no. must be filled out");
			return false;
		}
		
		if(isNaN(mobile))
		{
			alert("Please Enter a Valid Phone No");
			return false;
		}
		
	}
	
