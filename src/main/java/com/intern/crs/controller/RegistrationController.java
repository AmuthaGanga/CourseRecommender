package com.intern.crs.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

import com.intern.crs.dao.UserInfoDao;
import com.intern.crs.object.UserInfo;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
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
		System.out.println("In doPost method of RegistrationController");
		UserInfo userInfo = new UserInfo();
		userInfo.setFirstName(request.getParameter("firstName"));
		userInfo.setLastName(request.getParameter("lastName"));
		userInfo.setDob(Date.valueOf(request.getParameter("dob")));
		userInfo.setGender(request.getParameter("gender"));
		userInfo.setPhone_number(request.getParameter("phone"));
		userInfo.setEmail(request.getParameter("email"));
		userInfo.setAddress(request.getParameter("address"));
		userInfo.setPassword(request.getParameter("password"));
		
		System.out.println(userInfo.toString());
		
		HttpSession session = request.getSession();
		
		UserInfoDao userInfoDao = new UserInfoDao();
		
		// check whether the email already exists
		UserInfo existingUser = userInfoDao.getUserByUserName(userInfo.getEmail());
		
		if(null == existingUser) {
			int rowsCreated = userInfoDao.createNewUser(userInfo);
			if(rowsCreated > 0) {
				session.setAttribute("message", "Account created successfully!! You can login now!");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				session.setAttribute("message", "Account creation failed!! Try again!");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else {
			session.setAttribute("message", "Email Id already exists!!");
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
