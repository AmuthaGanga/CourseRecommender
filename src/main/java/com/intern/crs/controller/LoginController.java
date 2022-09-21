package com.intern.crs.controller;

import java.io.IOException;

import com.intern.crs.dao.UserInfoDao;
import com.intern.crs.object.UserInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		System.out.println("In doPost method of LoginController");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		UserInfoDao userInfoDao = new UserInfoDao();
		UserInfo user = userInfoDao.getUserByUserName(userName);
		
		if(null != user) {

			if(password.equals(user.getPassword())) {
				session.setAttribute("userName", user.getFirstName() + " " + user.getLastName());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("userRole", user.getUserRole());
				getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
			}else {
				session.setAttribute("email", user.getEmail());
				session.setAttribute("message", "Invalid Password!");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else {
			session.setAttribute("message", "Invalid Login details!");
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

}
