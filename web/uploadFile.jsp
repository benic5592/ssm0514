<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/22
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

<fieldset>
    <legend>单文件上传</legend>
    <form action="uploadFile" method="post"
          id="form1" enctype="multipart/form-data">
        <input type="text" name="username">
        <input type="file" name="file">
        <input type="submit" value="表单上传">
        <input type="button" value="ajax上传" id="btnUploadFile">

    </form>
</fieldset>

<script src="js/jquery-1.11.3.js"></script>
<script>
    $(function () {

        $("#btnUploadFile").click(function () {

            var dataForm = new FormData($('#form1')[0]);

            $.ajax({
                url:'uploadFile',
                data:dataForm,
                contentType:false,
                processData:false,
                type:'post',
                dataType:'text',
                success:function (data) {
                    alert('成功');
                },
                error: function () {

                    alert('失败');
                }



            })


        })

    })




</script>
</body>
</html>
