<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật</title>
</head>
<body>
<h2>Chỉnh sửa sách</h2>
<form action="books?action=update" method="post">
    <input type="hidden" name="bookCode" value="${book.bookCode}"/>
    Tiêu đề: <input name="title" value="${book.title}" required><br/>
    Tác giả: <input name="author" value="${book.author}" required><br/>
    Thể loại: <input name="genre" value="${book.genre}" required><br/>
    Số lượng: <input name="quantity" value="${book.quantity}" type="number" required><br/>
    <button type="submit">Cập nhật</button>
</form>

</body>
</html>
