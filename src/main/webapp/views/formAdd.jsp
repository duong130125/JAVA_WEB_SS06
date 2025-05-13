<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới</title>
</head>
<body>
<h2>Thêm sách mới</h2>
<form action="books?action=create" method="post">
    Mã sách: <input name="bookCode" required><br/>
    Tiêu đề: <input name="title" required><br/>
    Tác giả: <input name="author" required><br/>
    Thể loại: <input name="genre" required><br/>
    Số lượng: <input name="quantity" type="number" required><br/>
    <button type="submit">Thêm</button>
</form>
</body>
</html>
