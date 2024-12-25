<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<h1>An error occurred:</h1>

<!-- Source: https://stackoverflow.com/questions/8135980/how-can-i-print-error-stack-trace-in-jsp-page -->
<p class="result-message">Exception: ${requestScope['javax.servlet.error.exception']}</p>
<p class="result-message">Request URI: ${requestScope['javax.servlet.error.request_uri']}</p>
<p class="result-message">Status Code: ${requestScope['javax.servlet.error.status_code']}</p>
</body>
</html>
