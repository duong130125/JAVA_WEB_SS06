<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách sách</title></head>
<body>
<h2>Danh sách sách</h2>
<a href="books?action=add">Thêm sách mới</a>
<table border="1">
    <thead>
    <tr>
        <th>Mã</th><th>Tiêu đề</th><th>Tác giả</th><th>Thể loại</th><th>Số lượng</th><th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td><c:out value="${book.bookCode}" /></td>
            <td><c:out value="${book.title}" /></td>
            <td><c:out value="${book.author}" /></td>
            <td><c:out value="${book.category}" /></td>
            <td><c:out value="${book.quantity}" /></td>
            <td>
                <a href="books?action=edit&bookCode=${book.bookCode}">Sửa</a>
                <form action="books?action=delete&bookCode=${book.bookCode}" method="post" style="display:inline">
                    <button type="submit">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

