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
<p>
회원 상세정보 페이지 입니다.
</p>
<table border = 1>
	<tr><td>아이디</td><td>${dto.membId}</td></tr>
	<tr><td>이름</td><td>${dto.membName}</td></tr>
	<tr><td>우편번호</td><td>${dto.postNumber}</td></tr>
	<tr><td>주소</td><td>${dto.membAddr} ${dto.detailAddr}</td></tr>
	<tr><td>이메일</td><td>${dto.membEmail }</td></tr>
	<tr><td>연락처</td><td>${dto.membPhoneNumber}</td></tr>
	<tr><td>생년월일</td><td><fmt:formatDate value="${dto.membBirth}" type="date" pattern="yyyy-MM-dd"/></td></tr>
	<tr><td>성별</td><td>${dto.membGender}</td></tr>
	<tr><td>등록일</td><td><fmt:formatDate value="${dto.membEnterDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<tr><td>이메일 수신여부</td><td>${dto.membConfirm}</td></tr>
</table>
<a href="memModify?membId=${dto.membId}">수정</a>
</body>
</html>