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
	<form:form action="result2" >
		<p>
			<label for="loginType">로그인 타입</label>
			<select name="loginType" id="loginType">
				<option value="">-- 선택하세요 </option>
				<c:forEach items="${loginTypes }" var="type">
					<option value="${type}" >${type}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label for="jobCode">직군</label>
			<select name="jobCode">
				<option value="">-- 선택하세요 </option>
				<c:forEach items="${jobCodes }" var="jobCode">
					<option value="${jobCode}" >${jobCode.label }</option>
				</c:forEach>
			</select>
		</p>

		<p>
			<label for="likeOs">좋아하는 과목</label>
			<c:forEach items="${likeOs }" var="os" varStatus="idx">
				<label>${os.label }</label>
				<input type="checkbox" name="likeOs" value="${os.code}">
			</c:forEach>
		</p>
		<input type="submit" value="결과보기">
	</form:form>
</body>
</html>




