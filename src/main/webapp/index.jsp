<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WeatherApp</title>
<link rel="stylesheet" href="Style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/77b61b9199.js"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container-fluid div-color">

		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white"
						style="background-color: green">
						<i class="fa-solid fa-cloud" style="font-size: 48px;"></i>
						<h2>Weather App</h2>
					</div>
					<div class="card-body text-center">
						<h1>
							<i class="fa-solid fa-location-dot" style="font-size: 30px;"></i>
							${city}
						</h1>
						<h3>${date}</h3>
						<h1 style="font-size: 8vw">${temperatureCelsius}°C</h1>
						<h1>${weatherCondition}</h1>
						<h1>
							<i class="fa-solid fa-temperature-three-quarters"></i>${humidity}&nbsp;&nbsp;
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<i class="fa-solid fa-wind"></i>${windSpeed}
						</h1>
						<h1></h1>


					</div>
				</div>

			</div>

		</div>
	</div>

	<%-- <div class="container-fluid div-color">
		<h1>${date}</h1>
		<h1>${temperatureCelsius}°C</h1>
		<h1>${humidity}</h1>
		<h1>${windSpeed}</h1>
		<h1>${weatherCondition}</h1>
	</div> --%>
</body>
</html>