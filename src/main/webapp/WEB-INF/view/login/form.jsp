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
	<form:form modelAttribute="login" action="result">
		<p>
			<label for="loginType">로그인 타입</label>
			<form:select path="loginType">
				<option value="">-- 선택하세요 </option>
				<form:options items="${loginTypes }"/>
			</form:select> 
		</p>
		<p>
			<label for="jobCode">직군</label>
			<form:select path="jobCode">
				<option value="">-- 선택하세요 </option>
				<form:options items="${jobCodes }" itemLabel="label" itemValue="code"/>
			</form:select> 
		</p>
		<p>
		    <label for="tool">주로 사용하는 개발 툴</label><br>
		    <form:radiobuttons items="${tools}" path="tool" delimiter="<br>"/>
		</p>
		<p>
			<label>선호 OS</label>
			<form:checkboxes items="${favoriteOsNames}" path="favoriteOs" delimiter=" "/>
		</p>
		<p>
			<label>좋아하는 OS</label>
			<form:checkboxes items="${likeOs}" path="likeOs" itemValue="code" itemLabel="label" delimiter=" "/>
		</p>
		<p>
			<label for="strSubjects">좋아하는 과목</label>
			<form:checkboxes items="${subjects}" path="strSubjects" itemValue="code" itemLabel="label" delimiter=" "/>
		</p>
		<input type="submit" value="결과보기">
	</form:form>
</body>
</html>




