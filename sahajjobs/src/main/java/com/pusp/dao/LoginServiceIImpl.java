package com.pusp.dao;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.pusp.db.LogginConnection;
import com.pusp.dto.PersistUserDto;

public class LoginServiceIImpl implements LoginServiceI {
	final static Logger logger = Logger.getLogger(LoginServiceIImpl.class);
	private Connection conn = null;
	LogginConnection loginConn = null;
	String query = "select * from users where u_name = ? and u_pass = ?";
	public LoginServiceIImpl() throws Exception{
		loginConn = new LogginConnection();
	}
	public boolean validateUser(String uname, String pass) throws Exception{
		logger.debug("user :"+uname +" password : "+pass);
		boolean response = false;
		response = getLoginStatus(uname,pass);
		return response;
		
	}
	
	public PersistUserDto saveUser(String fName, String lName, String pass, String email, long mobileNo, String loc,
			int totalExp, String skills, String indudtry, String filePath)throws Exception {
		PersistUserDto persistUserDto = persistUser( fName,  lName, pass, email, mobileNo, loc, totalExp, skills, indudtry, filePath);
		return persistUserDto;
	}
	
	private boolean getLoginStatus(String uname, String pass) throws SQLException{
		boolean msg = false;
		conn  = LogginConnection.getLoginConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, uname);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			msg = true;
		return msg;
	}
	
	
	private PersistUserDto persistUser(String fName, String lName, String pass, String email, long mobileNo, String loc,
			int totalExp, String skills, String indudtry, String filePath)throws Exception {
		conn = LogginConnection.getLoginConnection();
		PersistUserDto dto = new PersistUserDto();
		DatabaseMetaData md = conn.getMetaData();
		String tableName = fName+""+lName;
			int returnCode = -1;
			String query = "create table "+ tableName+"(fName varchar2(30), lName varchar2(30), pass varchar2(30), email varchar2(30),mob number(10), loc varchar2(30),t_Exp number(2),skills varchar2(30),industry varchar2(30),resume clob)";
			try{
				
				File f = new File(filePath);  
				FileReader fr = new FileReader(f);
				Statement st = conn.createStatement();
				returnCode = st.executeUpdate(query);
				logger.info("returncode "+returnCode);
				PreparedStatement ps = conn.prepareStatement("");
				ps.setString(1, fName);
				ps.setString(2, lName);
				ps.setString(3, pass);
				ps.setString(4, email);
				ps.setLong(5, mobileNo);
				ps.setString(6, loc);
				ps.setInt(7, 3);
				ps.setString(8, "");
				ps.setString(9, "");
				ps.setCharacterStream(10,fr,(int)f.length());
				int rtncode = ps.executeUpdate();
				logger.info("after insertion rtncode : "+rtncode);
				if(rtncode >0)
					dto.setSuccessMessage("User Created Successfully");
				
			}
			catch(Exception e){
				dto.setErrorMessage("Unable To create The User Try With Different User");
				logger.error("Error in :LoginServiceIImpl.persistUser()"+e.getMessage());
			}
			
		return dto; 
	}

}
