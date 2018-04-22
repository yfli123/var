<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 使用struts标签库 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%-- <form action="addProduct" method="post">
 <input type="text" name="product.name" value="${param.name}">
    <br/>
 <input type="submit" value="submit">
</form> --%>
<s:form action="addProduct">
  <s:textfield name="product.name" label="product name"/>
  <s:submit value="Submit" />
</s:form>

</body>
</html>