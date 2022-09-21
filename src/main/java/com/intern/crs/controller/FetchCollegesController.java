package com.intern.crs.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.intern.crs.dao.CollegeDao;
import com.intern.crs.object.CollegeInfo;

/**
 * Servlet implementation class FetchCollegesController
 */
@WebServlet("/FetchCollegesController")
public class FetchCollegesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchCollegesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet method of FetchCollegesController");
		HttpSession session = request.getSession();
		
		CollegeDao collegeDao = new CollegeDao();
		List<CollegeInfo> collegesList = collegeDao.fetchAllColleges();
		System.out.println("colleges list --> " + collegesList);
		
		if(null != collegesList && collegesList.size() > 0) {
			session.setAttribute("collegesList", collegesList);
			session.setAttribute("message", "");
			getServletContext().getRequestDispatcher("/colleges.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "");
			getServletContext().getRequestDispatcher("/colleges.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doPost method of FetchCollegesController");
		HttpSession session = request.getSession();
		
		CollegeDao collegeDao = new CollegeDao();
		List<CollegeInfo> collegesList = collegeDao.fetchAllColleges();
		System.out.println("colleges list --> " + collegesList);
		
		if(null != collegesList && collegesList.size() > 0) {
			session.setAttribute("collegesList", collegesList);
			session.setAttribute("message", "");
			getServletContext().getRequestDispatcher("/colleges.jsp").forward(request, response);
		}else {
			session.setAttribute("message", "");
			getServletContext().getRequestDispatcher("/colleges.jsp").forward(request, response);
		}
	}

}
