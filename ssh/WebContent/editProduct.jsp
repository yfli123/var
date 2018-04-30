<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin:0px auto; width:500px">


<form action="updateProduct" method="post">

name: <input name="product.name" value="${product.name}"> <br>

<input name="product.id" type="hidden" value="${product.id}"> 
<button type="submit">提交</button>

</form>
</div>
</body>
</html>