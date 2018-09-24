<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
First Name: <form:input path="firstName" />
		<br>
		<br>
Last Name: <form:input path="lastName" />
		<br>
		<br>
		Country:
	<form:select path="country">
			<form:options items="${student.countryOptions}"></form:options>

		</form:select>
		<br>
		<br>
		Favorite Language: 
		
		Java<form:radiobutton path="favoriteLanguage" value="Java" />
		C#<form:radiobutton path="favoriteLanguage" value="C#" />
		Ruby<form:radiobutton path="favoriteLanguage" value="Ruby" />
		PHP<form:radiobutton path="favoriteLanguage" value="PHP" />
		<br>
		<br>
		
		Operating Systems: 
		
		Windows<form:checkbox path="operatingSystems" value="Windows" />
		Linux<form:checkbox path="operatingSystems" value="Linux" />
		Mac<form:checkbox path="operatingSystems" value="Mac" />

		<br>
		<br>
		<input type="submit" value="submit">
	</form:form>

</body>
</html>