package com.startuporg.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.startuporg.model.AuditQuestionSet;
import com.startuporg.model.AuditQuestionSetKey;
import com.startuporg.model.QuestionCategory;
import com.startuporg.model.QuestionCategoryKey;
import com.startuporg.model.StartupAudit;
import com.startuporg.repositroy.repositroy;
import com.startuporg.service.*;

@MultipartConfig
public class uploadquestiondata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<StartupAudit> startupAudits = new ArrayList<StartupAudit>();
		HttpSession session = request.getSession();
		String processarea = (String) session.getAttribute("processarea");
		String questioncategory = (String) session.getAttribute("questioncategory");
		try {
			
			System.out.println(processarea + " : " + questioncategory);
			String[] question = request.getParameterValues("question[]");
			if (question != null) {
				String[] weight1 = request.getParameterValues("weight[]");
				String[] maximum1 = request.getParameterValues("maximum[]");
				int count = service.getId(new QuestionCategory(new QuestionCategoryKey(processarea, questioncategory)));
				for (int i = 0; i < question.length; i++) {
					service.getaudit(
							new AuditQuestionSet(new AuditQuestionSetKey(count++, processarea, questioncategory),
									new QuestionCategory(new QuestionCategoryKey(processarea, questioncategory)),
									question[i], Double.parseDouble(weight1[i]), Double.parseDouble(maximum1[i])));
				}

				int count1 = (int) service.getId();
				for (int i = 0; i < question.length; i++) {

					StartupAudit startupAudit = new StartupAudit();
					startupAudit.setAudit_srno(count1++);
					startupAudit.setAuditdate(new Date());
					startupAudit.setAuditorteam("");
					startupAudit.setAuditee("");
					startupAudit.setProcessarea(processarea);
					startupAudit.setQuestioncategory(questioncategory);
					startupAudit.setQuestion(question[i]);
					startupAudit.setActualscore(0);
					startupAudit.setWeight(Double.parseDouble(weight1[i]));
					startupAudit.setMaxscore(Double.parseDouble(maximum1[i]));
					startupAudit.setRemark("");
					startupAudit.setEvidenceupload("");
					service.savedatastartup_audit(startupAudit);
					startupAudits.add(startupAudit);
				}
			}
			session.removeAttribute("processarea");
			session.removeAttribute("questioncategory");
			List<StartupAudit> stAudits=service.getall(processarea,questioncategory);
			session.setAttribute("startupAudits", stAudits);
			StartupAudit obj=stAudits.get(0);
			session.setAttribute("processarea", obj.getProcessarea());
			session.setAttribute("questioncategory", obj.getQuestioncategory());
			session.setAttribute("auditdate", obj.getAuditdate());
			session.setAttribute("error", "");
			session.setAttribute("Auditor_Team",obj.getAuditorteam());
			session.setAttribute("Auditee",obj.getAuditee());
			
			
			RequestDispatcher rs = request.getRequestDispatcher("third.jsp");
			rs.forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
