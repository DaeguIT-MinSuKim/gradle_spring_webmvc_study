<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="login" method="post" action="result">
		<p>
			<label for="loginType">로그인 타입</label>
			<%-- <form:select path="loginType" items="${loginTypes}" /> --%>
			<form:select path="loginType">
				<option value="none">--- 선택하세요---</option>
				<form:options items="${loginTypes}" />
			</form:select>
		</p>
<%-- 		<c:if test="${jobCodes != null}">
			<p>
				<label for="jobCode">직군</label>
				<form:select path="jobCode">
					<option value="">-- 선택하세요---</option>
					<form:options items="${jobCodes}" itemValue="label"
						itemLabel="code" />
				</form:select>
			</p>
		</c:if>

		<c:if test="${favoriteOsNames != null}">
			<p>
				<label for="favoriteOs">선호 OS</label><br>
				<form:checkboxes items="${favoriteOsNames}" path="favoriteOs" />
			</p>
		</c:if>

		<c:if test="${osCodes != null}">
			<p>
				<label for="osCode">선호 OS</label><br>
				<form:checkboxes items="${osCodes}" itemValue="code"
					itemLabel="label" path="osCode" />
			</p>
		</c:if>
 --%>
		<p>
		<br>
		<form:checkbox path="allowNoti" label="이메일을 수신합니다." />
		</p>

		<c:if test="${tools != null}">
			<p>
				<label>주로 사용하는 개발 툴</label>
				<br>
				<form:radiobuttons items="${tools}" path="tool" />
			</p>
		</c:if>

		<p>
			<label for="etc"> 기타 </label> <br>
			<form:textarea path="etc" cols="20" rows="3" />
		</p>
		<input type="submit" value="결과보기">
	</form:form>
</body>
</html>