package com.intern.crs.controller;

import java.io.IOException;

import com.intern.crs.dao.CourseDao;
import com.intern.crs.object.CourseInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateCourseController
 */
@WebServlet("/CreateCourseController")
public class CreateCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCourseController() {
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
		System.out.println("In doPost method of CreateCourseController");
		CourseInfo courseInfo = new CourseInfo();
		courseInfo.setCourseName(request.getParameter("courseName"));
		courseInfo.setDuration(request.getParameter("duration"));
		courseInfo.setEligibility(request.getParameter("eligibility"));
		courseInfo.setPlacementOpportunities(request.getParameter("placement"));
		
		System.out.println(courseInfo.toString());
		
		HttpSession session = request.getSession();
		
		CourseDao courseDao = new CourseDao();
		CourseInfo exists = courseDao.fetchCourseByName(courseInfo.getCourseName());

		if(null == exists) {
			int rowsCreated = courseDao.createNewCourse(courseInfo);
			if(rowsCreated > 0) {
				//session.setAttribute("message", "Course Added Successfully!!");
				getServletContext().getRequestDispatcher("/FetchCoursesController").forward(request, response);
			}
		}else {
			session.setAttribute("message", "Course Name already exists!!! Try Adding a new course!!");
			getServletContext().getRequestDispatcher("/addNewCourse.jsp").forward(request, response);
		}
	}

}
