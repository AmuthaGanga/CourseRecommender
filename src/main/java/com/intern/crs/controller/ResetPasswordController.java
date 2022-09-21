package com.intern.crs.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.intern.crs.dao.UserInfoDao;

/**
 * Servlet implementation class ResetPasswordController
 */
@WebServlet("/ResetPasswordController")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doPost method of ResetPasswordController");
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		UserInfoDao userInfoDao = new UserInfoDao();
		
		int rowsUpdated = userInfoDao.updateUserPassword(emailId, password);
		if(rowsUpdated > 0) {
			session.setAttribute("message", "Password updated successfully!! You can login now!");
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "Password updation failed!! Try again!");
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
