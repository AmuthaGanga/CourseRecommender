package com.intern.crs.controller;

import java.io.IOException;
import java.util.List;

import com.intern.crs.dao.UserInfoDao;
import com.intern.crs.object.UserInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FetchCollegesController
 */
@WebServlet("/FetchStudentsController")
public class FetchStudentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchStudentsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet method of FetchStudentsController");
		HttpSession session = request.getSession();
		
		UserInfoDao userInfoDao = new UserInfoDao();
		List<UserInfo> usersList = userInfoDao.fetchAllUsers();
		System.out.println("users list --> " + usersList);
		
		if(null != usersList && usersList.size() > 0) {
			session.setAttribute("usersList", usersList);
			getServletContext().getRequestDispatcher("/students.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "Data not available in database");
			getServletContext().getRequestDispatcher("/students.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doPost method of FetchStudentsController");
		HttpSession session = request.getSession();
		
		UserInfoDao userInfoDao = new UserInfoDao();
		List<UserInfo> usersList = userInfoDao.fetchAllUsers();
		System.out.println("users list --> " + usersList);
		
		if(null != usersList && usersList.size() > 0) {
			session.setAttribute("usersList", usersList);
			getServletContext().getRequestDispatcher("/students.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "Data not available in database");
			getServletContext().getRequestDispatcher("/students.jsp").forward(request, response);
		}
	}

}
