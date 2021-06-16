<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function delOk(){
		if(confirm("탈퇴하시겠습니까?")){
			document.frm.submit();
			return false;
		}
	}
</script>
</head>
<body>
<form action="memDeleteOk" method="post" name="frm" onsubmit="return delOk();">
<table border = 1>
	<tr><td colspan="2">비밀번호 입력</td></tr>
	<tr><td>비밀번호</td>
		<td><input type="password" name="membPw"/></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="탈퇴"/></td></tr>
</table>
</form>
</body>
</html>