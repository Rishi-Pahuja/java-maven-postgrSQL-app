<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Employee Admin Tool</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
	<div class="container">

		<div class="table-container">
			<jsp:include page="employees.jsp" />
		</div>

		<div class="forms-container">
			<div class="form-container">
				<h2>Add Employees</h2>
				<jsp:include page="addEmployees.jsp" />
				<c:if test="${not empty resultMessage && param.action == 'insert'}">
					<p class="result-message">${resultMessage}</p>
				</c:if>
			</div>
			<div class="form-container">
				<h2>Find An Employee By ID</h2>
				<jsp:include page="findEmployees.jsp" />

				<c:if test="${not empty foundEmployee}">
					<p>Found: ${foundEmployee.firstName} ${foundEmployee.lastName}</p>
				</c:if>

				<c:if test="${not empty resultMessage && param.action == 'find'}">
					<p class="result-message">${resultMessage}</p>
				</c:if>
			</div>
			<div class="form-container">
				<h2>Remove an Employee</h2>
				<jsp:include page="deleteEmployee.jsp" />
				<c:if test="${not empty resultMessage && param.action == 'delete'}">
					<p class="result-message">${resultMessage}</p>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
