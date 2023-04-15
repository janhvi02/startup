<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container mt-5 card card-body">

		<form action="uploadquestiondata" method="post" enctype="multipart/form-data">
			<h2 class="fs-4">
				Process Area &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="processarea" value="<c:out value="${processarea }" />"   disabled />
			</h2>
			<h2 class="fs-4">
				Question Category <input type="text" name="questioncategory" value="<c:out value="${questioncategory }" />"
					  disabled />
			</h2>
			<div class="table-responsive">
				<table class="table table-bordered ">
					<thead class="text-center">
						<tr>
							<th>Sr. No.</th>
							<th>Question</th>
							<th>Weight</th>
							<th>Maximum</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody id="table-body">
						<tr>
							<td><input type="number" name="srno[]" class="form-control"
								value="1" readonly></td>
							<td><input type="text" name="question[]"
								class="form-control" required="required" maxlength="255"></td>
							<td><input type="number" name="weight[]" class="form-control">
							</td>
							<td><input type="number" name="maximum[]" class="form-control">
							</td>
							<td><input type="button" value="Delete" disabled
								class="btn btn-danger" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="text-center mt-3">
				<button class="btn btn-primary" onclick="addRow()">Add Row</button>
			</div>
			<div class="container text-center mt-3">
				<a href="first.jsp" class="btn btn-secondary">&nbsp;&nbsp;Back&nbsp;&nbsp;</a>
				<input type="submit" class="btn btn-success" value="Submit">
			</div>
		</form>
	</div>
	<script>
		function addRow() {
			// Get the table body element
			const tableBody = document.getElementById("table-body");

			// Create a new row
			const newRow = document.createElement("tr");

			// Create the srno cell
			const srnoCell = document.createElement("td");
			const srnoInput = document.createElement("input");
			srnoInput.type = "number";
			srnoInput.name = "srno[]";
			srnoInput.classList.add("form-control");
			srnoInput.readOnly = true;
			srnoInput.value = tableBody.children.length + 1; // set the value of the input field
			srnoCell.appendChild(srnoInput);
			newRow.appendChild(srnoCell);

			// Create the question cell
			const questionCell = document.createElement("td");
			const questionInput = document.createElement("input");
			questionInput.type = "text";
			questionInput.name = "question[]";
			questionInput.required = true;
			questionInput.style.maxLength = 255;
			questionInput.classList.add("form-control");
			questionCell.appendChild(questionInput);
			newRow.appendChild(questionCell);

			// Create the weight cell
			const weightCell = document.createElement("td");
			const weightInput = document.createElement("input");
			weightInput.type = "text";
			weightInput.name = "weight[]";
			weightInput.classList.add("form-control");
			weightCell.appendChild(weightInput);
			newRow.appendChild(weightCell);

			// Create the maximum cell
			const maximumCell = document.createElement("td");
			const maximumInput = document.createElement("input");
			maximumInput.type = "text";
			maximumInput.name = "maximum[]";
			maximumInput.classList.add("form-control");
			maximumCell.appendChild(maximumInput);
			newRow.appendChild(maximumCell);

			// Create the delete cell
			const deleteCell = document.createElement("td");
			const deleteButton = document.createElement("button");
			deleteButton.type = "button";
			deleteButton.classList.add("btn", "btn-danger");
			deleteButton.innerText = "Delete";
			deleteButton.addEventListener("click", function() {
				tableBody.removeChild(newRow);
			});
			deleteCell.appendChild(deleteButton);
			newRow.appendChild(deleteCell);

			// Append the new row to the table body
			tableBody.appendChild(newRow);
		}
	</script>
</body>

</html>