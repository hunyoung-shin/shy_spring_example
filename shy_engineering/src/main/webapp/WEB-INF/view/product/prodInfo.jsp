<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
수정 페이지 입니다.<br/>
<form action="prodModifyOk" method="post">
<input type="hidden" name="prodNo" value="${dto.prodNo }"/>
<table border = 1>
	<tr><th>상품번호</th>
		<td>${dto.prodNo }</td></tr>
	<tr><th>이름</th>
		<td><input type="text" name="prodName" value="${dto.prodName }"></td></tr>
	<tr><th>가격</th>
		<td><input type="number" name="prodPrice" value="${dto.prodPrice }"
					min=0 step="1"></td></tr>
	<tr><th>설명</th>
		<td><textarea rows="6" cols="30" name="prodInfo">${dto.prodInfo }</textarea></td></tr>
	<tr><th colspan="2">
		<input type="submit" value="상품 정보 수정"/>
		<input type="button" value="상품 삭제"/>
		<input type="button" value="리스트로 돌아가기" onclick="javascript:history.back();"/>
		</th></tr>	
</table>
</form>
</body>
</html>