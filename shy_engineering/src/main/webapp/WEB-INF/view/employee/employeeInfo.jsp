<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1>
	<tr><td>사원번호</td><td>아이디</td><td>이름</td><td>부서명</td>
	<td>이메일</td><td>연락처</td>
	<td>입사일</td><td>급여</td></tr>
		<tr><td>${emp.empNo }</td><td>${emp.empId }</td><td>${emp.empName }</td><td>${emp.empDeptNumber }</td>
		<td>${emp.empEmail }</td><td>${emp.empPhoneNumber }</td>
		<td><fmt:formatDate value="${emp.hireDate }" type="date" pattern="yyyy/MM/dd"/></td><td>${emp.salary }</td></tr>
</table>
</body>
</html>