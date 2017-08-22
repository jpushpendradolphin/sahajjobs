package com.pusp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pusp.dao.LoginServiceI;
import com.pusp.dao.LoginServiceIImpl;
import com.pusp.dto.SignUpRequestDto;

/**
 * Servlet implementation class SignUp
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filePath = "C:/Users/admin/Desktop/jobs/sahajjobs/src/main/resources";
		/*MultipartRequest m = new MultipartRequest(request,filePath);*/  

		SignUpRequestDto requestDto = new SignUpRequestDto();
		
		requestDto.setfName(request.getParameter("fName"));
		requestDto.setlName(request.getParameter("lName"));
		requestDto.setPass(request.getParameter("pass"));
		requestDto.setEmail(request.getParameter("email"));
		System.out.println("mobile"+request.getParameter("email"));
		requestDto.setMobile(Long.parseLong(request.getParameter("mobile")));
		requestDto.setLocation(request.getParameter("location"));
		requestDto.setExperience(Integer.parseInt(request.getParameter("experience")));
		requestDto.setSkills(request.getParameter("skills"));
		requestDto.setIndustry(request.getParameter("industry"));
		requestDto.setFilePath(filePath);
		try {
			LoginServiceI service = new LoginServiceIImpl();
			service.saveUser(requestDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
