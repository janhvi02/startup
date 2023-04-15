package com.startuporg.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.startuporg.model.QuestionCategory;
import com.startuporg.service.*;

/**
 * Servlet implementation class updateaudit
 */
public class updateaudit extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String processarea = (String) session.getAttribute("processarea");
		String questioncategory = (String) session.getAttribute("questioncategory");
		try {
            System.out.println("here is data "+request.getParameter("p"));
			String auditorTeam = request.getParameter("Auditor_Team");
			String Auditee = request.getParameter("Auditee");

			int result = service.setfield(processarea, questioncategory, auditorTeam, Auditee);
			if (result != 0) {
				session.removeAttribute("auditdate");
				session.removeAttribute("Auditor_Team");
				session.removeAttribute("Auditee");
				session.setAttribute("auditdate", new Date());
				session.setAttribute("Auditor_Team", auditorTeam);
				session.setAttribute("Auditee", Auditee);
				session.setAttribute("error", "");
				RequestDispatcher rs = request.getRequestDispatcher("third.jsp");
				rs.forward(request, response);
			} else {
				session.setAttribute("error", "Could'nt Update Your Code");
				RequestDispatcher rs = request.getRequestDispatcher("third.jsp");
				rs.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Could'nt Update Your Code");
			RequestDispatcher rs = request.getRequestDispatcher("third.jsp");
			rs.forward(request, response);
		}

	}

}
