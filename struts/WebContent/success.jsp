<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<!-- 第一行表示上传后被放在tomcat的work目录下，并且以.tmp命名
	第二行是上传文件本来的名字
	第三行是上传文件的mime type  
-->

uploaded success
 
${doc}
<br/>
${docFileName}
<br/>
${docContentType}
<br/>
</body>
</html>