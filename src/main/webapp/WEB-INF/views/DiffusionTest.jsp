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
  <form action="/Freek/Diffusion/showImage" method="get" enctype="multipart/form-data">
    <input type="file" name="paramF">
    <input type="text" name="paramT">
    <button type="submit">업로드</button>
  </form>
</div>
<div>
  <form action="/Freek/Diffusion/showImage2/{imagename}" method="get" enctype="multipart/form-data">
    <input type="file" name="paramF">
    <input type="text" name="imagename">
    <button type="submit">업로드</button>
  </form>
</div>
<div>
  <form action="/Freek/Diffusion/showImage3" method="post" enctype="multipart/form-data">
    <input type="file" name="paramF">
    <input type="text" name="paramT">
    <button type="submit">업로드</button>
  </form>
</div>
<div>
  <form action="Freek/Diffusion/showImage4" method="post" enctype="multipart/form-data">
    <input type="file" name="paramF">
    <input type="text" name="paramT">
    <button type="submit">업로드</button>
  </form>
</div>

</body>
</html>
