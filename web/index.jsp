<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/14
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="index.jsp?locale=zh_CN">中文</a>,
  <a href="member/selectById?locale=en_US">English</a>
<br>
  spring:message <spring:message code="se" />

  <fmt:setBundle basename="messages" var="lang"/>
  fmt:message <fmt:message key="se" bundle="${lang}"/>
  <fieldset>
    <legend>springmvc使用变量接收</legend>

    <form action="member/selectById" method="post">
      <input type="text" name="id">
      <input type="submit" value="<spring:message code="se" />">
    </form>
  </fieldset>
  <fieldset>
    <legend>springmvc使用对象接收</legend>
  <form action="member/selectByMember" method="post">
    <input type="text" name="id">
    <input type="submit" value="查询">
  </form>
  </fieldset>
  <fieldset>
    <legend>springmvc 直接跳转页面</legend>
  <form action="member/toResult" method="post">
    <input type="submit" value="跳转">
  </form>

  </fieldset>
  <fieldset>
    <legend>springmvc 接收ajax</legend>
    <input type="text" name="id" id="memId">
    <button id="btnSelect">查询</button>
    <button id="btnSelectBetter">更好的查询</button>

  </fieldset>

  <fieldset>
    <legend>mybatis动态查询</legend>
    <form action="member/selectMembers" method="post">
      <input type="text" name="id" placeholder="id">
      <input type="text" name="username" placeholder="name">
      <input type="submit" value="查询">
    </form>
  </fieldset>

  <fieldset>
    <legend>多条id范围查询</legend>
    <form action="member/selectByIds" method="post">
      <input type="text" name="id" placeholder="id1">
      <input type="text" name="id" placeholder="id2">
      <input type="text" name="id" placeholder="id3">
      <input type="submit" value="查询">
    </form>
  </fieldset>
  <fieldset>
    <legend>springmvc 接收ajax的数组</legend>
    <button id="btnArray">查询</button>

  </fieldset>
  <script src="js/jquery-1.11.3.js"></script>
  <script src="js/index.js?version=20180517"></script>
  <script>
    $(function () {
        $('#btnSelect').click(function () {
            $.ajax({
                url:'member/selectByAjax',
                data:{id:$('#memId').val()},
                type:'post',
                dataType:'json',
                success:function (data) {
                    console.log(data);
                },
                error:function () {
                    console.log('失败')
                }
            })
        });

        $('#btnSelectBetter').click(function () {
            $.ajax({
                url:'member/selectByAjaxBetter',
                data:{id:$('#memId').val()},
                type:'post',
                dataType:'json',
                success:function (data) {
                    console.log(data.member);
                },
                error:function () {
                    console.log('失败')
                }
            })
        });

        $('#btnArray').click(function () {

            var ids = [];
            ids.push('1');
            ids.push('2');
            ids.push('3');
            $.ajax({
                url:'member/selectByIdsAjax',
                data:{id:ids},
                type:'post',
                dataType:'json',
                success:function (data) {
                    console.log(data);
                },
                error:function () {
                    console.log('失败')
                }
            })
        });
    })


  </script>
  </body>
</html>
