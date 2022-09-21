package com.intern.crs.controller;

import java.io.IOException;
import java.util.List;

import com.intern.crs.dao.CourseDao;
import com.intern.crs.object.CourseInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FetchCoursesController
 */
@WebServlet("/FetchCoursesController")
public class FetchCoursesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchCoursesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet method of FetchCoursesController");
		HttpSession session = request.getSession();
		
		CourseDao courseDao = new CourseDao();
		List<CourseInfo> coursesList = courseDao.fetchAllCourses();
		System.out.println("courses list --> " + coursesList);
		
		if(null != coursesList && coursesList.size() > 0) {
			session.setAttribute("coursesList", coursesList);
			session.setAttribute("message", "");
			getServletContext().getRequestDispatcher("/courses.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "");
			getServletContext().getRequestDispatcher("/courses.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doPost method of FetchCoursesController");
		HttpSession session = request.getSession();
		
		CourseDao courseDao = new CourseDao();
		List<CourseInfo> coursesList = courseDao.fetchAllCourses();
		System.out.println("courses list --> " + coursesList);
		
		if(null != coursesList && coursesList.size() > 0) {
			session.setAttribute("coursesList", coursesList);
			session.setAttribute("message", "");
			getServletContext().getRequestDispatcher("/courses.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "");
			getServletContext().getRequestDispatcher("/courses.jsp").forward(request, response);
		}
	}

}
