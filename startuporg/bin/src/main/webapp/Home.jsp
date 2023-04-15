<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Question Category Master</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0/css/bootstrap.min.css">

<!-- Materialize CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Custom CSS -->
<style>

	.container {
		margin-top: 50px;
	}
	.btn {
		margin-right: 10px;
	}
	@media (max-width: 768px) {
		.btn {
			margin-top: 10px;
		}
	}
</style>

</head>
<body>
	<div class="container">
	<div class="card mt-5 p-4 mb-5">
		<div class="row justify-content-center">
			<div class="col-md-8 col-lg-12 p-3">
				<h3 class="text-center">Question Category</h3>
				<div class="d-flex justify-content-center  container mt-5">
					<a href="first.jsp" class="btn fs-2 btn-primary">Create New Question Set</a>
					<a href="view.jsp" class="btn fs-2 btn-secondary">&nbsp;View Question Set&nbsp;</a>
				</div>
			</div>
		</div>
	</div>
	</div>

	<!-- jQuery -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<!-- Bootstrap JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>

	<!-- Materialize JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</body>
</html>
