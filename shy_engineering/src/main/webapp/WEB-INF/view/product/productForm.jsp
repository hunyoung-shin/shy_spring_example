<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productForm.jsp</title>
</head>
<body>
상품등록 페이지입니다.
<!-- 파일이 있으므로 post형태, image는 binary 형태로 보내야 하므로 enctype 수정 -->
<form action="prodJoinOk" method="post" enctype="multipart/form-data">
<table border = 1>
	<tr><th>상품번호</th>
		<td><input type="text" name="prodNo" value="${autoNum }"></td></tr>
	<tr><th>카테고리</th>
		<td>
			<select name="catNum">
				<c:forEach items="${lists }" var="dto">
					<option value="${dto.catNum }">${dto.catName }</option>
				</c:forEach>
			</select>
		</td></tr>
	<tr><th>이름</th>
		<td><input type="text" name="prodName"></td></tr>
	<tr><th>가격</th>
		<td><input type="number" name="prodPrice"
					min=0 step="1" value="0"></td></tr>
	<tr><th>설명</th>
		<td><textarea rows="6" cols="30" name="prodInfo"></textarea></td></tr>
	<tr><th>이미지</th>
		<td><input type="file" name="prodImage" multiple="multiple"/></td></tr>
	<tr><th colspan="2">
		<input type="submit" value="상품등록"/>
		<input type="reset" value="취소"/>
		<input type="button" value="리스트로 돌아가기" onclick="javascript:history.back();"/>
		</th></tr>	
</table>
</form>
</body>
</html>