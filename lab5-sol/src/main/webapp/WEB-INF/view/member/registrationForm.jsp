<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>오디션 지원</title>
</head>
<body>
	<h2>SpringIdol 오디션 지원</h2>
	<br>
	
	<form:form modelAttribute="regReq" method="post">
		<label for="name">이름</label>: 
		<form:input path="name" />
		<form:errors path="name"/> <br/>
		
		<label for="password">비밀번호</label>: 
		<form:password path="password" showPassword="true"/>
		<form:errors path="password"/> <br/>
		
		<label for="confirmPassword">비밀번호 확인</label>: 
		<form:password path="confirmPassword" showPassword="true"/>
		<form:errors path="confirmPassword"/>
		<form:errors path="samePasswordConfirmPassword"/>   <!-- @AssertTrue 에 의한 오류 발생 시 출력  --> 
		<br/>  
		
		<label for="phone">휴대폰 번호</label>:
		<form:input path="phone" placeholder="예: 01x-1234-5678"/>
		<form:errors path="phone"/> <br/>
		
		<label for="email">이메일</label>:
		<form:input path="email" placeholder="예: abc@gmail.com"/>
		<form:errors path="email"/> <br/>
		
		<label>주소</label>:
		street
		<form:input path="address.street" />
		<form:errors path="address.street"/>&nbsp;
		city
		<form:input path="address.city" size="10"/>
		<form:errors path="address.city"/>&nbsp; 
		zipcode
		<form:input path="address.zipcode" size="7" />
		<form:errors path="address.zipcode"/> <br/>
		
		지원 분야:
		<%-- <select name="type">
			<c:forEach var="t" items="${performTypes}">
				<option value="${t}" 
					<c:if test="${t == regReq.type}">selected</c:if>>
					${t}
				</option>
			</c:forEach>
		</select><br/> --%>  
		<%-- 위와 같이 해도 되지만 다음과 같이 <form:select>를 이용하는 것이 간편함 --%>
		<form:select path="type" items="${performTypes}" /><br/> 
		<form:errors path="type"/> 
		 
		<label for="title">곡명/연기명</label>:
		<form:input path="title" />
		<form:errors path="title"/> <br/>
		
		<label for="length">공연 시간(분)</label>:
		<form:input path="length" size="3"/>
		<form:errors path="length"/> <br/>
		
		<label>온라인 공연 희망   
		<%-- <form:checkbox path="online" value="true" checked="${online ? 'checked' : '' }"/>
		 --%>
		<form:checkbox path="online" />
		</label><br/></br>
		
		<input type="submit" value="신청" />
	
	</form:form>
</body>
</html>