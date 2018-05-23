<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/22
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<spring:message code="se" var="btnSelect"></spring:message>

<form action="member/testLanguage" method="post">
    <input type="text" name="username"><br>
    <input type="radio" value="en_US" name="locale">en_US
    <input type="radio" value="zh_CN" name="locale">zh_CN
    <input type="submit" value="${btnSelect}">


</form>
<br>
<button><spring:message code="se"></spring:message> </button><br>
<a href="/ssm0514/member/changeLanguage?locale=zh_CN">中文</a>
<a href="/ssm0514/member/changeLanguage?locale=en_US">English</a>


</body>
</html>
