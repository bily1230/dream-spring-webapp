<%--
  Created by IntelliJ IDEA.
  User: ning
  Date: 2017/8/31
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/fileUpload/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <button type="submit">提交</button>
    </form>
</body>
</html>
