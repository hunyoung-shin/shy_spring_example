<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1>
	<tr><td colspan="2">나의 정보</td></tr>
	<tr><td>아이디</td><td>${dto.membId}</td></tr>
	<tr><td>이름</td><td>${dto.membName}</td></tr>
	<tr><td>우편번호</td><td>${dto.postNumber}</td></tr>
	<tr><td>주소</td><td>${dto.membAddr}</td></tr>
	<tr><td>상세주소</td><td>${dto.detailAddr}</td></tr>
	<tr><td>이메일</td><td>${dto.membEmail }</td></tr>
	<tr><td>등록일</td><td><fmt:formatDate value="${dto.membEnterDate}" type="date" pattern="yyyy-MM-dd"/></td>
	<tr><td>연락처</td><td>${dto.membPhoneNumber}</td></tr>
	<tr><td>생년월일</td><td><fmt:formatDate value="${dto.membBirth}" type="date" pattern="yyyy-MM-dd"/></td></tr>
	<tr><td>성별</td><td><c:if test="${dto.membGender == 'M'}">남자</c:if>
						<c:if test="${dto.membGender == 'F'}">여자</c:if></td></tr>
	<tr><td>이메일 수신여부</td><td><c:if test="${dto.membConfirm =='Y' }">예</c:if>
							   <c:if test="${dto.membConfirm =='N' }">아니오</c:if></td></tr>
</table><br/>

<a href="memUpdate">수정</a>

</body>
</html>