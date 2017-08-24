package com.pusp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.pusp.db.LogginConnection;
import com.pusp.dto.LoginRequest;
import com.pusp.dto.PersistUserDto;
import com.pusp.dto.SignUpRequestDto;
import com.pusp.dto.UserDetailsResponse;

public class LoginServiceIImpl implements LoginServiceI {
	final static Logger logger = Logger.getLogger(LoginServiceIImpl.class);
	private Connection conn = null;
	LogginConnection loginConn = null;
	String query = "select * from users where u_name = ? and u_pass = ?";
	public LoginServiceIImpl() throws Exception{
		loginConn = new LogginConnection();
	}
	public boolean validateUser(LoginRequest request) throws Exception{
		logger.debug("user :"+request.getUser() +" password : "+request.getPassword());
		boolean response = false;
		response = getLoginStatus(request);
		return response;
		
	}
	
	public PersistUserDto saveUser(SignUpRequestDto request)throws Exception {
		PersistUserDto persistUserDto = persistUser(request);
		return persistUserDto;
	}
	
	
	private boolean getLoginStatus(LoginRequest request) throws SQLException{
		boolean msg = false;
		conn  = LogginConnection.getLoginConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, request.getUser());
		ps.setString(2, request.getPassword());
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			msg = true;
		return msg;
	}
	public UserDetailsResponse getUserDetails(String userName) {
		UserDetailsResponse userDetailsResponse = fetchUserDetails(userName);
		if(userDetailsResponse != null)
			userDetailsResponse.setSuccessMsg("Suucess");
		return userDetailsResponse;
	}
	
	private PersistUserDto persistUser(SignUpRequestDto request)throws Exception {
		conn = LogginConnection.getLoginConnection();
		PersistUserDto dto = new PersistUserDto();
		String tableName = request.getfName()+""+request.getlName();
			int returnCode = -1;
			String query = "create table "+ tableName+"(fName varchar2(30), lName varchar2(30), pass varchar2(30), email varchar2(30),mob number(10), loc varchar2(30),t_Exp number(2),skills varchar2(30),industry varchar2(30))";
			try{
				
				/*File f = new File(request.getFilePath());  
				FileReader fr = new FileReader(f);*/
				Statement st = conn.createStatement();
				returnCode = st.executeUpdate(query);
				
				logger.info("returncode "+returnCode+"table created successfully");
				PreparedStatement ps = conn.prepareStatement("insert into "+tableName +" values (?,?,?,?,?,?,?,?,?)");
				ps.setString(1, request.getfName());
				ps.setString(2, request.getlName());
				ps.setString(3, request.getPass());
				ps.setString(4, request.getEmail());
				ps.setLong(5, request.getMobile());
				ps.setString(6, request.getLocation());
				ps.setInt(7, request.getExperience());
				ps.setString(8, request.getSkills());
				ps.setString(9, request.getIndustry());
				//ps.setCharacterStream(10,fr,(int)f.length());
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
	
	public UserDetailsResponse fetchUserDetails(String userName) {
		UserDetailsResponse userDetailsResponse = null;
		String query = "select * from "+userName +"";
		Connection conn = LogginConnection.getLoginConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userDetailsResponse = new UserDetailsResponse();
				userDetailsResponse.setfName(rs.getString(1));
				userDetailsResponse.setlName(rs.getString(2));
				userDetailsResponse.setEmail(rs.getString(4));
				userDetailsResponse.setMobileNo(rs.getLong(5));
				userDetailsResponse.setLoc(rs.getString(6));
				userDetailsResponse.setExperience(rs.getInt(7));
				userDetailsResponse.setSkills(rs.getString(8));
				userDetailsResponse.setIndustry(rs.getString(9));
			}
		} catch (SQLException e) {
			logger.error("Error in LoginServiceIImpl.fetchUserDetails"+e.getMessage());
			e.printStackTrace();
		}
		return userDetailsResponse;
	}

}
