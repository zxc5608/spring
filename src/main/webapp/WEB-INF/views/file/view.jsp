<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/mvc/fileupload/upload" method="post" enctype="multipart/form-data">
		userid:<input type="text" name="userid" value="brown"/><br>
		picture:<input type="file" name="picture"/><br>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>