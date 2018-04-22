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
<table align="center" border="1" cellspacing="0" width="500px">
 
    <tr>
        <td>id</td>
        <td>name</td>
        <td>price</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
 
    <s:iterator value="products" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td><a href="editProduct?product.id=${p.id}">edit</a></td>
            <td><a href="deleteProduct?product.id=${p.id}">delete</a></td>
        </tr>
    </s:iterator>
</table>
 
<br/>
 
<form action="addProduct" method="post">
<table align="center" border="1" cellspacing="0">
 <tr>
    <td>
        name:
    </td>
    <td>
        <input type="text" name="product.name" value="">
    </td>
 </tr>
 <tr>
    <td>
        price:
    </td>
    <td>
        <input type="text" name="product.price" value="0">
    </td>
 </tr>
 <tr>
    <td colspan="2" align="center">
        <input type="submit" value="submit">
    </td>
 </tr>
</table>
 
</form>
</body>
</html>