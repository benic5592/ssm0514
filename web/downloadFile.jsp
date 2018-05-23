<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/22
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<fieldset>
    <legend>单文件下载</legend>
    <form action="fileDownload" method="post">
        <input type="text" name="fileName" value="123.jpg">
        <input type="submit" value="文件下载">
    </form>
</fieldset>

</body>
</html>
