<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page For Startup Question Audit</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0/css/bootstrap.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<!-- Custom CSS -->
<style>
.container {
	margin-top: 50px;
}

.form-group label {
	font-weight: bold;
}

.btn {
	margin-top: 10px;
}
</style>

</head>
<script type="text/javascript">
	var element = document.getElementById('#id');
</script>
<body>

	<c:if test="${ not empty msg}">
		<script>
			alert("<c:out value="${msg}" />")
		</script>
	</c:if>
	<div class="container">
		<div class="card mt-5 p-4 mb-5">

			<h4 class="text-center">Question Category</h4>
			<form action="uploadquestion" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="processarea">Select Process Area</label> <select
						class="form-control" name="processarea" id="processarea" required>
						<option value="">Select a Process Area</option>
						<option value="Idea_Management">Idea Management</option>
						<option value="Knowledge_Management">Knowledge Management</option>
						<option value="Research_Management">Research Management</option>
						<option value="Entrepreneur_Management">Entrepreneur
							Management</option>
						<option value="Contract_Management">Contract Management</option>
						<option value="Delivery_Management">Delivery Management</option>
						<option value="Support_Management">Support Management</option>
						<option value="Social_Responsibility_Management">Social
							Responsibility Management</option>
						<option value="Scope_Management">Scope Management</option>
						<option value="Finance_Management">Finance Management</option>
						<option value="Project_Management">Project Management</option>
						<option value="Integration_Management">Integration
							Management</option>
						<option value="Operations_Management">Operations
							Management</option>
						<option value="HR_Management">HR Management</option>
						<option value="Security_Management">Security Management</option>
						<option value="Process_Management">Process Management</option>
						<option value="Innovation_Management">Innovation
							Management</option>
						<option value="Compliance_Management">Compliance
							Management</option>
						<option value="Technology_Transfer_Management_Perspective">Technology
							Transfer Management Perspective</option>
						<option value="Risk_Management">Risk Management</option>
						<option value="Governance_Management">Governance
							Management</option>
						<option value="Capacity_Management">Capacity Management</option>
						<option value="Infrastructure_Management">Infrastructure
							Management</option>
						<option value="Mergers_and_Acquisition_Management">Mergers
							and Acquisition Management</option>
						<option value="Performance_Management">Performance
							Management</option>
						<option value="Partnership_Management">Partnership
							Management</option>
						<option value="IPO_Management">IPO Management</option>
					</select>
				</div>
				<div class="form-group">
					<label for="inputfield">Question Category</label> <input
						type="text" class="form-control" name="questioncategory"
						id="inputfield" required>
				</div>
				<div class="container text-center">
					<a href="Home.jsp" class="btn btn-secondary">&nbsp;&nbsp;Back&nbsp;&nbsp;</a>
					<input type="submit" class="btn btn-primary" value="Submit">
				</div>
			</form>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>

</body>
</html>
