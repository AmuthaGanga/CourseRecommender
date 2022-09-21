package com.intern.crs.controller;

import java.io.IOException;

import com.intern.crs.dao.CourseDao;
import com.intern.crs.object.CourseInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCourseController
 */
@WebServlet("/UpdateCourseController")
public class UpdateCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourseController() {
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
		System.out.println("In doPost method of UpdateCourseController");
		CourseInfo courseInfo = new CourseInfo();
		System.out.println("request.getParameter(\"courseId\") --> " +request.getParameter("courseId"));
		courseInfo.setCourseId(Integer.parseInt(request.getParameter("courseId")));
		courseInfo.setCourseName(request.getParameter("courseName"));
		courseInfo.setDuration(request.getParameter("duration"));
		courseInfo.setEligibility(request.getParameter("eligibility"));
		courseInfo.setPlacementOpportunities(request.getParameter("placement"));
		
		CourseDao courseDao = new CourseDao();

		int rowsUpdated = courseDao.updateCourseInfo(courseInfo);
		if(rowsUpdated > 0) {
			//session.setAttribute("message", "College Added Successfully!!");
			getServletContext().getRequestDispatcher("/FetchCoursesController").forward(request, response);
		}else {
		//	session.setAttribute("message", "College Not Added!! Try again!");
			getServletContext().getRequestDispatcher("/FetchCoursesController").forward(request, response);
		}
	}

}
