<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateProduct" method="post">
<table align="center" border="1" cellspacing="0">
 <tr>
    <td>
        name:
    </td>
    <td>
        <input type="text" name="product.name" value="${product.name}">
    </td>
 </tr>
 <tr>
    <td>
        price:
    </td>
    <td>
        <input type="text" name="product.price" value="${product.price}">
    </td>
 </tr>
 <tr>
    <td colspan="2" align="center">
        <input type="hidden" name="product.id" value="${product.id}">
        <input type="submit" value="submit">
    </td>
 </tr>
</table>
 
</form>
</body>
</html>