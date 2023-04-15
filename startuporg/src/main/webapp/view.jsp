<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- --<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Questions Form</title>
</head>
<body>
    <h1>Questions Form</h1>
    <form method="post" action="viewServlet">
        <label for="processArea">Process Area:</label>
        <input type="text" id="processArea" name="processArea" required>
        <br><br>
        <label for="questionCategory">Question Category:</label>
        <input type="text" id="questionCategory" name="questionCategory" required>
        <br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html> -->
 <%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Audit Questions</title>
    <style>
        /* Add styles for the form elements */
        label {
            display: inline-block;
            width: 150px;
            font-weight: bold;
        }
        input[type="text"] {
            width: 300px;
            padding: 5px;
            font-size: 16px;
            border: 1px solid #ccc;
        }
        button[type="submit"] {
            background-color:#0000FF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            text-align: left;
            padding: 8px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
    <h1>Audit Questions</h1>
    <form method="post" action="">
        <label for="processarea">Process Area:</label>
        <input type="text" id="processarea" name="processarea" required>
        <br><br>
        <label for="questioncategory">Question Category:</label>
        <input type="text" id="questioncategory" name="questioncategory" required>
        <br><br>
        <button type="submit">Search</button>
    </form>

    <% 
    if (request.getMethod().equals("POST")) {
        String processarea = request.getParameter("processarea");
        String questioncategory = request.getParameter("questioncategory");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/startup", "root", "root");

            String sql = "SELECT * FROM startupaudit WHERE processarea = ? AND questioncategory = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, processarea);
            stmt.setString(2, questioncategory);

            ResultSet rs = stmt.executeQuery();
    %>

    <table border="1">
        <tr>
            <th>Audit SR No</th>
            <th>Actual Score</th>
            <th>Audit Date</th>
            <th>Auditee</th>
            <th>Auditor Team</th>
            <th>Evidence Upload</th>
            <th>Max Score</th>
            <th>Process Area</th>
            <th>Question</th>
            <th>Question Category</th>
            <th>Remark</th>
            <th>Weight</th>
        </tr>

    <% while(rs.next()) { %>
        <tr>
            <td><%= rs.getInt("audit_srno") %></td>
            <td><%= rs.getDouble("actualscore") %></td>
            <td><%= rs.getTimestamp("auditdate") %></td>
            <td><%= rs.getString("auditee") %></td>
            <td><%= rs.getString("auditorteam") %></td>
            <td><%= rs.getString("evidenceupload") %></td>
            <td><%= rs.getDouble("maxscore") %></td>
            <td><%= rs.getString("processarea") %></td>
            <td><%= rs.getString("question") %></td>
            <td><%= rs.getString("questioncategory") %></td>
            <td><%= rs.getString("remark") %></td>
            <td><%= rs.getDouble("weight") %></td>
        </tr>
    <% } %>
    </table>

    <% 
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    } 
    %>
</body>
</html>
 


