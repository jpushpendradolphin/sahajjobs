package com.pusp.dao;

import com.pusp.dto.PersistUserDto;

public interface LoginServiceI {
	public boolean validateUser(String uname, String pass)throws Exception;
	public PersistUserDto saveUser(String fName,String lName,String pass,String email,long mobileNo,
			String loc,int totalExp,String skills,String indudtry,String filePath)throws Exception;
}

