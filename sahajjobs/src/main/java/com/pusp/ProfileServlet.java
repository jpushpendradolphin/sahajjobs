package com.pusp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pusp.dao.LoginServiceI;
import com.pusp.dao.LoginServiceIImpl;
import com.pusp.dto.UserDetailsResponse;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginServiceI loginService = new LoginServiceIImpl();
			UserDetailsResponse userDetailsResponse = loginService.getUserDetails(request.getParameter("uname"));
			
				request.setAttribute("userDetails", userDetailsResponse);
				request.setAttribute("user", request.getParameter("uname"));
				RequestDispatcher rd = request.getRequestDispatcher("/UProfile.jsp");
				rd.forward(request, response);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
