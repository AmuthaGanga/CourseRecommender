package com.intern.crs.controller;

import java.io.IOException;

import com.intern.crs.dao.CollegeDao;
import com.intern.crs.object.CollegeInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCollegeController
 */
@WebServlet("/UpdateCollegeController")
public class UpdateCollegeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCollegeController() {
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
		System.out.println("In doPost method of UpdateCollegeController");
		CollegeInfo collegeInfo = new CollegeInfo();
		System.out.println("request.getParameter(\"collegeId\") --> " +request.getParameter("collegeId"));
		collegeInfo.setCollegeId(Integer.parseInt(request.getParameter("collegeId")));
		collegeInfo.setCollegeName(request.getParameter("collegeName"));
		collegeInfo.setCity(request.getParameter("city"));
		collegeInfo.setUniversity(request.getParameter("university"));
		collegeInfo.setWebsite(request.getParameter("website"));
		collegeInfo.setAccreditatedBy(request.getParameter("accreditatedBy"));
		collegeInfo.setNaacScore(request.getParameter("naacScore"));
		
		System.out.println(collegeInfo.toString());
		
		String select[] = request.getParameterValues("selectedList");
		
	//	HttpSession session = request.getSession();
		
		CollegeDao collegeDao = new CollegeDao();

		int rowsUpdated = collegeDao.updateCollegeInfo(collegeInfo);
		if(rowsUpdated > 0) {
			//remove the existing mapping
			collegeDao.deleteMappingsByCollegeId(collegeInfo.getCollegeId());
			
			//create new mapping
			if(null != select && select.length > 0) {
				for(String str: select) {
					collegeDao.createCollegeCourseMap(collegeInfo.getCollegeId(), Integer.parseInt(str));
				}
			}
			
			//session.setAttribute("message", "College Added Successfully!!");
			getServletContext().getRequestDispatcher("/FetchCollegesController").forward(request, response);
		}else {
		//	session.setAttribute("message", "College Not Added!! Try again!");
			getServletContext().getRequestDispatcher("/FetchCollegesController").forward(request, response);
		}
	}

}
