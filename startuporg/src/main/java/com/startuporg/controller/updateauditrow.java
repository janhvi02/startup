package com.startuporg.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.startuporg.model.StartupAudit;
import com.startuporg.service.*;

/**
 * Servlet implementation class updateauditrow
 */
@MultipartConfig
public class updateauditrow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String processarea = (String) session.getAttribute("processarea");
			String questioncategory = (String) session.getAttribute("questioncategory");
			int srno = Integer.parseInt(request.getParameter("srno"));
			double actualscore = Double.parseDouble(request.getParameter("actualscore"));
			String remark = request.getParameter("remark");
			Part eupload = request.getPart("eupload");
			String filename = "";
			String filePath = "";
			if (eupload != null) {
				// Create directory with srno as name if it does not exist
				String directoryPath = request.getRealPath("/") + srno;
				File directory = new File(directoryPath);
				if (!directory.exists()) {
					directory.mkdirs();
				}
				filename = "srno_" + srno + "_" + eupload.getSubmittedFileName();
				filePath = directoryPath + "/" + filename;
				eupload.write(filePath);
			}
			int result = service.setPath(actualscore, remark, filename, srno);
			System.out.println(filename);
			if (result != 0) {

				List<StartupAudit> stAudits = service.getall(processarea, questioncategory);
				session.setAttribute("startupAudits", stAudits);
				StartupAudit obj = stAudits.get(0);
				session.setAttribute("processarea", obj.getProcessarea());
				session.setAttribute("questioncategory", obj.getQuestioncategory());
				session.setAttribute("auditdate", obj.getAuditdate());
				session.setAttribute("error", "");
				session.setAttribute("Auditor_Team", obj.getAuditorteam());
				session.setAttribute("Auditee", obj.getAuditee());
				session.setAttribute("filePath", filePath);
				RequestDispatcher rs = request.getRequestDispatcher("third.jsp");
				rs.forward(request, response);
			} else {
				session.setAttribute("error", "Could'nt Update Your Code");
				RequestDispatcher rs = request.getRequestDispatcher("third.jsp");
				rs.forward(request, response);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			session.setAttribute("error", "Could'nt Update Your Code");
			RequestDispatcher rs = request.getRequestDispatcher("third.jsp");
			rs.forward(request, response);
		}
	}
}