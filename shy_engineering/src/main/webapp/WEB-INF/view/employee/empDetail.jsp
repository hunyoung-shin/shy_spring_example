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
<table border = "1">
	<tr><td colspan="2">직원 상세 정보</td></tr>
	<tr><td>사원번호</td><td>${dto.empNo}</td></tr>
	<tr><td>아이디</td><td>${dto.empId}</td></tr>
	<tr><td>이름</td><td>${dto.empName}</td></tr>
	<tr><td>부서번호</td><td>${dto.empDeptNumber}</td></tr>
	<tr><td>이메일</td><td>${dto.empEmail}</td></tr>
	<tr><td>전화번호</td><td>${dto.empPhoneNumber }</td></tr>
	<tr><td>입사일</td><td><fmt:formatDate value="${dto.hireDate}" type="date" pattern="yyyy-MM-dd"/></td>
	<tr><td>급여</td><td>${dto.salary}</td></tr>
</table>

<a href="empUpdate">정보 수정</a>

</body>
</html>