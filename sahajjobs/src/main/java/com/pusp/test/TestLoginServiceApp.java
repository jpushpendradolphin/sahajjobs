package com.pusp.test;

import com.pusp.dao.LoginServiceI;
import com.pusp.dao.LoginServiceIImpl;
import com.pusp.db.LogginConnection;
import com.pusp.dto.PersistUserDto;

public class TestLoginServiceApp {

	public static void main(String[] args) throws Exception {
		LogginConnection conn = new LogginConnection();
		System.out.println("conn :"+conn);
		LoginServiceI service = new LoginServiceIImpl();
		PersistUserDto msg = service.saveUser("p", "yadav", "", "", 1, "", 0, "", "", "");
		System.out.println("msg :"+msg.getErrorMessage());

	}

}
