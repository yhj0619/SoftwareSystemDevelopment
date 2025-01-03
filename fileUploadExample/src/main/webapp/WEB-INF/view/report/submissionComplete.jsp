<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리포트 제출 완료</title>
</head>
<body>
리포트 제출 완료
<br>
<div>
	fileUrl: ${fileUrl}<br>
	<img src="<c:url value='${fileUrl}'/>"/>
</div>

<p><a href="<c:url value='/index' />">Go to index</a></p>
</body>
</html>
