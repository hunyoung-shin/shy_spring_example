<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<table width="800" border="1">
	<c:set var="total" value="0" />
	<tr><td>이미지</td><td>상품명</td><td>수량</td><td>단가</td><td>적용금액</td></tr>
	<c:forEach items="${list}" var="productCartDTO" >
	<tr>
		<td>
			<img src="../product/upload/${productCartDTO.productDTO.prodImage.split(',')[0] }" />
		</td>
		<td>${productCartDTO.productDTO.prodName }</td>
		<td>${productCartDTO.cartDTO.cartQty }</td>
		<td>${productCartDTO.productDTO.prodPrice }</td>
		<td>${productCartDTO.cartDTO.cartPrice }</td>
	</tr>
	<c:set var="total" value="${total + productCartDTO.cartDTO.cartPrice }"/>
	</c:forEach>
	<tr><td colspan="5" align="right">
			상품수 : <span id="prodCnt">${list.size() }</span><br/>
			전체금액 : <span id="totalPrice">${total }</span><br/>
		</td>
	
	</tr>
</table>
</body>
</html>