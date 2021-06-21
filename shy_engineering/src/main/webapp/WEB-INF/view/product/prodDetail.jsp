<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function cartAdd(prodNo, prodPrice, catNum){
		if(${authInfo==null}){
			alert("로그인을 해주세요.");
			location.href="../";
			return false;
		}else{
			var qty=document.getElementById("qty").value;
			location.href="cartAdd?prodNo="+prodNo
									+"&cartQty="+qty
									+"&prodPrice="+prodPrice
									+"&catNum="+catNum;
		}
		
	}
</script>
</head>
<body>
제품 상세 페이지<br/>
<table align="center" width="800">
	<tr><td rowspan="4">
			<img width="300" src="../product/upload/${dto.prodImage.split(',')[0] }" />
		</td>
		<td align="center">
			${dto.prodName }
		</td></tr>
	<tr><td align="right">
			<fmt:formatNumber value="${dto.prodPrice }" pattern="#,###,###,###"/> 원</td></tr>
	<tr><td align="right">
			<input type="number" min="1" value="1" name="qty" id="qty"/> 개
		</td></tr>
	<tr><td>
			<input type="button" value="장바구니"
					onclick="cartAdd('${dto.prodNo }', '${dto.prodPrice }', '${dto.catNum }')"/>
			<input type="button" value="바로구매"/>
		</td></tr>
	<tr><td colspan="2">
			제품 상세설명<br/>
			${dto.prodInfo }<br/>
			<c:forTokens items="${dto.prodImage }" delims="," var="image">
				<img width="800" src="../product/upload/${image }"><br/>
			</c:forTokens>
		</td></tr>
</table>
</body>
</html>