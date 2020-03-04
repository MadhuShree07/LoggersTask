<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<form action="forgot.do" method="post">

		<div class="container">


		<!-- <div
			class="cover-container d-flex w-100 h-100 p-5 mx-auto flex-column"> -->



			<nav class="navbar  navbar-expand-md navbar-dark bg-primary"
				style="opacity: 0.5"; >
				<div
					class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link"
							href="login.jsp" style="font-family:arial;"></a></li>
					</ul>
				</div>
				<div class="mx-auto order-0">
					<a class="navbar-brand mx-auto" href="home.jsp" style="font-family:arial;">Homepage</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target=".dual-collapse2">
						<span class="navbar-toggler-icon"></span>
					</button>
				</div>

				<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link"
							href="reg.jsp" style="font-family: arial;">
								</a></li>
					</ul>
				</div>
			</nav>
		</div>
		<div class="text-center" align="center">

			<span style="color: green; font-family: arial;">Invalid mail}</span>
			<span style="color: red; font-family: arial;">${Password not Matched}</span>
			<span style="color: red; font-family: arial;">${Success}</span>
			<span style="color: red; font-family: arial;">${register}</span>
		</div>

		<div class="container w-50%">
			<div class="card-body" align="center">
				<h2 class="card-title" font="bold" style="font-family: italica;">
					<b>Enter email</b>
				</h2>

				<div class="form-group">
					<div class="form-group col-md-3">
						<label for="Email">Email</label> <input type="email"
							class="form-control"
							id="Email" name="email">
					</div>
				<div class="form-group">
					<div class="form-group col-md-3">
						<label for="Email">password</label> <input type="password"
							class="form-control"
							id="password" name="password">
					</div>
						<div class="form-group">
					<div class="form-group col-md-3">
						<label for="confirmPassword">confirmPassword</label> <input type="emconfirmPasswordail"
							class="form-control"
							id="confirmPassword" name="confirmPassword">
					</div>
					

					
						<button type="submit" class="btn btn-success">Reset
							</button>
					</div>
				</div>
</div>
</div>
</form>

</form>

</body>
</html>
