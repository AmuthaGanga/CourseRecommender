package com.intern.crs.controller;

import java.io.IOException;

import com.intern.crs.dao.CollegeDao;
import com.intern.crs.object.CollegeInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateCollegeController
 */
@WebServlet("/CreateCollegeController")
public class CreateCollegeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCollegeController() {
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
		System.out.println("In doPost method of CreateCollegeController");
		CollegeInfo collegeInfo = new CollegeInfo();
		collegeInfo.setCollegeName(request.getParameter("collegeName"));
		collegeInfo.setCity(request.getParameter("city"));
		collegeInfo.setUniversity(request.getParameter("university"));
		collegeInfo.setWebsite(request.getParameter("website"));
		collegeInfo.setAccreditatedBy(request.getParameter("accreditatedBy"));
		collegeInfo.setNaacScore(request.getParameter("naacScore"));
		
		System.out.println(collegeInfo.toString());
		
		String select[] = request.getParameterValues("selectedList");
		
		HttpSession session = request.getSession();
		
		CollegeDao collegeDao = new CollegeDao();
		CollegeInfo exists = collegeDao.fetchCollegeByName(collegeInfo.getCollegeName());

		if(null == exists) {
			int collegeId = collegeDao.createNewCollege(collegeInfo);
			if(collegeId > 0) {
				if(null != select && select.length > 0) {
					for(String str: select) {
					collegeDao.createCollegeCourseMap(collegeId, Integer.parseInt(str));
					}
				}
				//session.setAttribute("message", "College Added Successfully!!");
				getServletContext().getRequestDispatcher("/FetchCollegesController").forward(request, response);
			}
		}else {
			session.setAttribute("message", "College Name already exists!!! Try Adding a new college!!");
			getServletContext().getRequestDispatcher("/addNewCollege.jsp").forward(request, response);
		}
		
	}

}
