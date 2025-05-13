<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>
<form action="login" method="post">
  Username: <input type="text" name="username" required /><br/>
  Password: <input type="password" name="password" required /><br/>
  <input type="submit" value="Login" />
</form>
<p><a href="register">Chưa có tài khoản? Đăng ký ngay</a></p>
<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>
</body>
</html>