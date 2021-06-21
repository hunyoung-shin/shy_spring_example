<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="empUpdateOk" method="post" name="frm">
<table border = "1">
	<tr><td colspan="2">직원 상세 정보</td></tr>
	<tr><td>아이디</td>
		<td>${dto.empId}</td></tr>
	<tr><td>비밀번호</td>
		<td><input type="password" name="empPw">
				<span>${pw.Fail }</span></td></tr>
	<tr><td>이름</td>
		<td>${dto.empName}</td></tr>
	<tr><td>부서번호</td>
		<td><input type="text" name="empDeptNumber" value="${dto.empDeptNumber}"></td></tr>
	<tr><td>이메일</td>
		<td><input type="text" name="empEmail" value="${dto.empEmail}"></td></tr>
	<tr><td>전화번호</td>
		<td><input type="text" name="empPhoneNumber" value="${dto.empPhoneNumber }"></td></tr>
	<tr><td>급여</td>
		<td><input type="text" name="salary" value="${dto.salary}"></td></tr>
	<tr><td colspan="2" align="center">
			<input type="submit" value="정보 수정 완료" />
			<input type="button" value="수정 안함" onclick="javascript:history.back();" /> 
			</td></tr>
</table>
</form>
</body>
</html>