<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<body>
		
		<ul>
		<c:forEach items="${guitarListGue}" var="listGue">
			<li>${listGue.name}</li>
		</c:forEach>
		</ul>
	</body>

	<form:form action="/mozart/instrument/guitar/save" modelAttribute="model">
	
		Name : <input type="text" name="name"/>
		<input type="submit"/>
	</form:form>	

</html>