<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head><title>Đăng nhập hệ thống</title></head>
<body>
<h2>Đăng nhập</h2>

<%-- Hiển thị lỗi từ Request Scope --%>
<c:if test="${not empty errorMsg}">
  <p style="color: red;">${errorMsg}</p>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">
  Username: <input type="text" name="username" required /><br/>
  Password: <input type="password" name="password" required /><br/>
  <button type="submit">Login</button>
</form>
</body>
</html>