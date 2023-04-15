package com.startuporg.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.startuporg.model.StartupAudit;

/**
 * Servlet implementation class viewServlet
 */
public class viewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String processArea = request.getParameter("processArea");
        String questionCategory = request.getParameter("questionCategory");

        List<StartupAudit> questions = new ArrayList<StartupAudit>();

        try {
            // Load the driver class
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/startup", "root", "root");

            // Create a prepared statement to retrieve the questions from the database
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT question, maxscore, actualscore FROM startupaudit WHERE processarea = ? AND questioncategory = ?");
            preparedStatement.setString(1, processArea);
            preparedStatement.setString(2, questionCategory);

            // Execute the query and retrieve the results
            ResultSet rs = preparedStatement.executeQuery();

            // Iterate over the results and add each question to the list
            while (rs.next()) {
//            	int auditSrNo = rs.getInt("audit_srno");
                double actualScore = rs.getDouble("actualscore");
                String auditDate = rs.getString("auditdate");
                String auditee = rs.getString("auditee");
                String auditorTeam = rs.getString("auditorteam");
                String evidenceUpload = rs.getString("evidenceupload");
                double maxScore = rs.getDouble("maxscore");
                String processAreaResult = rs.getString("processarea");
                String question = rs.getString("question");
                String questionCategoryResult = rs.getString("questioncategory");
                String remark = rs.getString("remark");
                double weight = rs.getDouble("weight");
                StartupAudit audit = new StartupAudit();
                
               
            }

            // Close the resources
          //  resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
			ex.printStackTrace();
        }

        // Set the list of questions as an attribute of the request
        request.setAttribute("StartupAudit", questions);

        // Forward the request to the JSP page
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }
}
