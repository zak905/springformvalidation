<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
<h2>Add a new Person</h2>
<form:form action="add" commandName="person"> 
<div>  First name </div><form:input path="firstname"/>
<form:errors path="firstname" style="color: red;"></form:errors>
<div>Last name </div><form:input path="lastName"/>
<form:errors path="lastName" style="color: red;"></form:errors>
<div> Age </div><form:input path="age"/>
<form:errors path="age" style="color: red;"></form:errors>
<div> Departement </div><form:input path="departement"/>
<form:errors path="departement" style="color: red;"></form:errors>
<input type="submit" value="Add"/>
</form:form>
</body>
</html>
