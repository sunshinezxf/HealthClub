<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="health club register page" />
<meta name="author" content="zhang xu fan" />
<link rel="shortcut icon" href="../material/logo.ico" />
<link rel="stylesheet" href="../css/bootstrap.css" />
<link rel="stylesheet" href="../css/customize.css" />
<title>Health Club--register</title>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="../index.jsp"><img alt="logo"
					src="../material/HealthClub.png" /></a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="../index.jsp">Home</a></li>
					<li><a href="register.jsp">Register</a></li>
					<li><a href="login.jsp">Login</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="grid-layout module">
		<strong>Register</strong>
		<hr>
		<form class="form-register">
			<span>Please fill you information</span><input type="text"
				class="form-control" placeholder="Name" />
			<div class="form-register-sex">
				<input type="radio" name="sex" value="male" />&nbsp; &nbsp;Male
			</div>
			<div class="form-register-sex">
				<input type="radio" name="sex" value="female" />&nbsp; &nbsp;Female
			</div>
			<input type="text" class="form-control" placeholder="Cellphone" />
			<input type="text" class="form-control" placeholder="Age" />
			<button class="btn btn-lg btn-primary btn-block button-commit" type="submit">Register</button>
		</form>
	</div>

</body>
</html>