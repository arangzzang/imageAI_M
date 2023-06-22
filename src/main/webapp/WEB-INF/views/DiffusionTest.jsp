<%--
  Created by IntelliJ IDEA.
  User: shy
  Date: 2023/06/10
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <h1>img2img & text2img</h1>
</head>
<body>
<div>
  <form action="/image/diffusionCall" method="post" enctype="multipart/form-data">
    <input type="file">
    <button type="submit">업로드</button>
  </form>
</div>

<div>
  <form action="/image/showImage" method="post" enctype="multipart/form-data">
    <input type="text" name="fileName">
    <button type="submit">showing</button>
  </form>
</div>

</body>
</html>
