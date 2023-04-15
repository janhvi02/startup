package com.startuporg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.startuporg.model.QuestionCategory;
import com.startuporg.model.QuestionCategoryKey;


@MultipartConfig
public class uploadquestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String processarea=request.getParameter("processarea");
		String questioncategory=request.getParameter("questioncategory");
		HttpSession session = request.getSession();
		session.removeAttribute("msg");
		try {
			QuestionCategoryKey key=new QuestionCategoryKey(processarea,questioncategory);
			System.out.println(key.getProcessarea()+" : "+key.getQuestioncategory());
			QuestionCategory questionCategory=new QuestionCategory(key);
			
			
			
			int result=com.startuporg.service.service.getdata(questionCategory);
			if(result!=0) {
				session.setAttribute("questioncategory", questioncategory);
				session.setAttribute("processarea", processarea);
				RequestDispatcher rs = request.getRequestDispatcher("second.jsp");
				rs.forward(request, response);
			}else {
//				session.setAttribute("msg", "This is already present");
				session.setAttribute("questioncategory", questioncategory);
				session.setAttribute("processarea", processarea);
				RequestDispatcher rs = request.getRequestDispatcher("second.jsp");
				rs.forward(request, response);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			session.setAttribute("msg", "Couldn't Process Pleased Try Again");
			RequestDispatcher rs = request.getRequestDispatcher("first.jsp");
			rs.forward(request, response);
		}
	}

}
