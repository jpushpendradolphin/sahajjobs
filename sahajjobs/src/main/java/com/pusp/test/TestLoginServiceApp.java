package com.pusp.test;

import com.pusp.dao.LoginServiceI;
import com.pusp.dao.LoginServiceIImpl;
import com.pusp.db.LogginConnection;
import com.pusp.dto.PersistUserDto;
import com.pusp.dto.SignUpRequestDto;

public class TestLoginServiceApp {

	public static void main(String[] args) throws Exception {
		SignUpRequestDto request = new  SignUpRequestDto();
		request.setfName("pushpendra");
		request.setlName("Yadav");
		LogginConnection conn = new LogginConnection();
		System.out.println("conn :"+conn);
		LoginServiceI service = new LoginServiceIImpl();
		/*PersistUserDto msg = service.saveUser(request);
		System.out.println("msg :"+msg.getErrorMessage());
		 */
		service.getUserDetails("PP");
	}

}
