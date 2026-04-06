<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Khai báo thư viện JSTL chuẩn Jakarta EE --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<html>
<head><title>Quản lý đơn hàng</title></head>
<body>
<%-- Lấy dữ liệu từ Session Scope --%>
<h2>Xin chào, ${sessionScope.loggedUser}! Vai trò: ${sessionScope.role}</h2>

<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
<hr/>

<h3>Danh sách đơn hàng</h3>
<table border="1" cellpadding="8">
    <tr>
        <th>Mã đơn</th>
        <th>Tên sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>

    <%-- Lặp dữ liệu từ Request Scope --%>
    <c:forEach var="order" items="${orderList}">
        <tr>
            <td>${order.id}</td>
            <td><c:out value="${order.productName}" /></td>

                <%-- Format Tiền tệ VNĐ --%>
            <td>
                <fmt:formatNumber value="${order.totalAmount}" type="currency" currencySymbol="VNĐ" groupingUsed="true" maxFractionDigits="0"/>
            </td>

                <%-- Format Ngày tháng --%>
            <td>
                <fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy" />
            </td>
        </tr>
    </c:forEach>
</table>

<br/>
<%-- Lấy dữ liệu từ Application Scope --%>
<p><i>Tổng lượt xem đơn hàng toàn hệ thống: <b>${applicationScope.totalViewCount}</b></i></p>
</body>
</html>