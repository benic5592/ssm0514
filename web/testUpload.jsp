<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/17
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<fieldset>
    <legend>单文件上传下载</legend>
    <form  id ="form1" action="load/upload1" enctype="multipart/form-data" method="post">
        <input type = "file" name= 'file' />
        <input type="text" name="name" value="旅游美图"/>
        <input type="button" id = "button1" value="ajax上传" onclick="fileupload1()">
        <input type ="submit" value="直接上传">
    </form>
</fieldset>
<fieldset>
    <legend>文件下载</legend>
    <form action="load/down2" id = "form2" method="post">
        <input type = "submit" value="普通文件下载">
    </form>
</fieldset>

<fieldset>

    <legend>多文件上传</legend>
    <form  id ="form3" action="load/upload3" enctype="multipart/form-data" method="post">
        <input type = "file" name= 'file' />
        <input type = "file" name= 'file' />
        <input type = "file" name= 'file' />
        <input type="text" name="name" value="旅游美图"/>
        <input type="button" id = "button3" value="多文件ajax上传" onclick="fileupload3()">
        <input type ="submit" value="多文件直接上传">
    </form>
</fieldset>

<fieldset>
    <legend>多文件下载(一次性下载多个文件时我们把文件放到一个压缩包里去)</legend>
    <form action="load/down4" id = "form4" method="post">
        <input type = "submit" value="压缩文件下载">
    </form>
</fieldset>


<script src="js/jquery-1.11.3.js"></script>
<script>
    function fileupload1(){
        var formData = new FormData($("#form1")[0]);
        $.ajax({
            url:'load/upload1',
            type:'post',
            data:formData,
            //必须false才会自动加上正确的Content-Type
            contentType: false,
            //必须false才会避开jQuery对 formdata 的默认处理
            //XMLHttpRequest会对 formdata 进行正确的处理
            processData: false,
            success:function(data){
                alert(data);
            },
            error:function(data){
                alert(data);
                alert("后台发生异常");
            },
            cache:false,
            async:true
        });
    }

    function fileupload3(){
        var formData = new FormData($("#form3")[0]);
        $.ajax({
            url:'load/upload3',
            type:'post',
            data:formData,
            //必须false才会自动加上正确的Content-Type
            contentType: false,
            //必须false才会避开jQuery对 formdata 的默认处理
            //XMLHttpRequest会对 formdata 进行正确的处理
            processData: false,
            success:function(data){
                alert(data);
            },
            error:function(data){
                alert(data);
                alert("后台发生异常");
            },
            cache:false,
            async:true
        });
    }
</script>
</body>
</html>
