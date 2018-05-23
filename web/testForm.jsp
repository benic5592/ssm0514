<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/17
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="form1" >
    <input type="text" name="id">
    <input type="text" name="name">
    <input type="text" name="sex">
    <input type="button" id="btnSubmit" value="查询">

</form>

<script src="js/jquery-1.11.3.js"></script>
<script>
    $(function () {
        $('#btnSubmit').click(function () {
            var form1 = $('#form1').serialize();
            // var form1 = new FormData($('#form1')[0]);
            $.ajax({
                url:'member/selectByMemberAjax',
                data:form1,
                // contentType: false,
                // processData: false,
                type:'post',
                dataType:'json',
                success : function (data) {

                    alert('成功');
                },
                error:function () {
                    alert('失败')
                }
            } )


        })
    })
</script>
</body>
</html>
