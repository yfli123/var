<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<style>
table {
    border-collapse: collapse;
}
 
td {
    border: 1px solid gray;
}
</style>

<!-- 使用s:iterator标签进行遍历
	value 表示集合
	var 表示遍历出来的元素
	st 表示遍历出来的元素状态
	st.index 当前行号 基0
	st.count 当前行号 基1
	st.first 是否是第一个元素
	st.last 是否是最后一个元素
	st.odd 是否是奇数
	st.even 是否是偶数  -->

<%-- <table align="center">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>st.index</td>
        <td>st.count</td>
        <td>st.first</td>
        <td>st.last</td>
        <td>st.odd</td>
        <td>st.even</td>
 
    </tr>
 
    <s:iterator value="products" var="p" status="st">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${st.index}</td>
            <td>${st.count}</td>
            <td>${st.first}</td>
            <td>${st.last}</td>
            <td>${st.odd}</td>
            <td>${st.even}</td>
        </tr>
    </s:iterator> --%>
    
    <!-- 使用s:checkboxlist标签
		value：哪些被选中
		name：提交到服务端用的名称
		list:用于遍历的集合
		listValue:显示的checkbox的名称
		listKey:checkbox的value 
		-->
    
    <!-- <s:checkboxlist value="selectedProducts" name="product.id"
    list="products" listValue="name" listKey="id" /> -->
    
    <!-- 在前例checkbox标签的基础上增加s:radio标签
		value表示：哪项被选中
		name表示：提交到服务端用的名称
		list:用于遍历的集合
		listValue:显示的radio的名称
		listKey:radio的value 
		-->
    
    
    <%-- <s:radio name="product.id" value="2" list="products" listValue="name"
    listKey="id" /> --%>
    
    <!-- 
		使用s:select标签
		name表示：提交到服务端用的名称
		list:用于遍历的集合
		listKey:每个option的value
		listValue:显示的名称
		multiple:true表示可以选中多行
		size="3"表示默认显示3行
		value表示：哪些被选中

		注: 可以增加一个属性 theme="simple" 使得最后生成的最简单的风格的html，否则就会有一些奇奇怪怪的tr td
		或者直接在struts.xml中加一句 Servlet下载文件
		<constant name="struts.ui.theme" value="simple"/>
		注: 如果要增加class，需要使用属性: cssClass 
     -->
    
    <%-- <s:select label="products"
       name="product.id"
       list="products"
       listKey="id"
       listValue="name"
       multiple="true"
       size="3"
       value="selectedProducts"
	/> --%>
	
	${date}
	
	<table border="1" cellspacing="0">
 
    <tr>
        <td>id</td>
        <td>name</td>
        <td>products</td>
    </tr>
     
    <s:iterator value="categories" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>
                <s:iterator value="#c.products" var="p">
                    ${p.name}<br/>
                </s:iterator>        
            </td>
        </tr>
    </s:iterator>
 
</table>
 
<s:debug/>
</body>
</html>