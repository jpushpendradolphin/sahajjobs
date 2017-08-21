package com.pusp.dao;

import com.pusp.dto.LoginRequest;
import com.pusp.dto.PersistUserDto;
import com.pusp.dto.SignUpRequestDto;

public interface LoginServiceI {
	public boolean validateUser(LoginRequest request)throws Exception;
	public PersistUserDto saveUser(SignUpRequestDto request)throws Exception;
}

