<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<html>
<head>
    <title>Tìm kiếm sự kiện</title>
    <style>
        .text-red { color: red; font-weight: bold; }
        .text-orange { color: orange; font-weight: bold; }
        .text-green { color: green; font-weight: bold; }
        .badge-free { background-color: #28a745; color: white; padding: 2px 6px; border-radius: 4px; }
        .disabled-link { color: gray; text-decoration: none; cursor: not-allowed; pointer-events: none; }
    </style>
</head>
<body>

<h2>
    Kết quả tìm kiếm cho:
    "<c:out value="${keyword}" />"
</h2>
<p>Tìm thấy <strong>${totalFound}</strong> sự kiện.</p>

<c:if test="${empty events}">
    <p class="text-red">Không tìm thấy sự kiện nào phù hợp.</p>
</c:if>

<c:if test="${not empty events}">
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày tổ chức</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="event" items="${events}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${event.name}" /></td>
                <td>${event.eventDate}</td>
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span class="badge-free">MIỄN PHÍ</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="number" groupingUsed="true" /> VNĐ
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span class="text-red">HẾT VÉ</span>
                        </c:when>
                        <c:when test="${event.remainingTickets < 10}">
                            <span class="text-orange">Sắp hết (còn ${event.remainingTickets} vé)</span>
                        </c:when>
                        <c:otherwise>
                            <span class="text-green">${event.remainingTickets}</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:url value="/events/${event.id}/book" var="bookUrl" />
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <a href="#" class="disabled-link">[ Hết chỗ ]</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${bookUrl}">Đặt vé</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<hr/>
<c:if test="${not empty events}">
    <p>Sự kiện nổi bật: <strong><c:out value="${fn:toUpperCase(events[0].name)}" /></strong></p>
</c:if>
<p><i>Độ dài từ khóa tìm kiếm: ${fn:length(keyword)} ký tự.</i></p>

</body>
</html>