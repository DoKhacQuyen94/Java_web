<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Phải import JSTL core taglib để sử dụng các thẻ <c:...> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%-- Đã thay thế HTML Comment bằng JSP Comment để không bị lộ mã nguồn xuống client --%>
    <%-- Tiêu đề trang báo cáo --%>
    <title>${reportTitle}</title>
</head>
<body>

<%-- Sử dụng EL để in dữ liệu trực tiếp từ Model --%>
<h1>${reportTitle}</h1>

<%-- Đã xóa hoàn toàn phần hiển thị và khai báo requestCounter vì View không nên giữ state --%>

<table border="1">
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
    </tr>

    <%-- Thay thế vòng lặp Java for bằng thẻ <c:forEach> của JSTL --%>
    <%-- varStatus="status" dùng để lấy index đếm số thứ tự --%>
    <c:forEach var="sv" items="${studentList}" varStatus="status">
        <tr>
                <%-- status.count đếm từ 1 (khác với status.index đếm từ 0) --%>
            <td>${status.count}</td>

                <%-- Dùng <c:out> để in chuỗi có nguy cơ dính XSS (tên người dùng) --%>
            <td><c:out value="${sv.name}" /></td>

                <%-- Dùng EL thuần túy cho số liệu, đã bỏ dấu ; thừa --%>
            <td>${sv.score}</td>

                <%-- Thay thế khối logic if/else phức tạp bằng <c:choose> --%>
            <td>
                <c:choose>
                    <c:when test="${sv.score >= 90}">Xuất sắc</c:when>
                    <c:when test="${sv.score >= 80}">Giỏi</c:when>
                    <c:when test="${sv.score >= 70}">Khá</c:when>
                    <c:when test="${sv.score >= 60}">Trung bình khá</c:when>
                    <c:when test="${sv.score >= 50}">Trung bình</c:when>
                    <c:otherwise>Yếu</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>