<%-- 
    Document   : addNhanVien
    Created on : Nov 14, 2024, 2:16:14 PM
    Author     : xuant
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Nhân Viên</title>
</head>
<body>
    <h1>Thêm Nhân Viên Mới</h1>
    <form action="addNhanVien" method="post">
        Họ Tên: <input type="text" name="hoTen" required><br>
        Ngày Sinh: <input type="date" name="ngaySinh" required><br>
        Địa Chỉ: <input type="text" name="diaChi" required><br>
        Trình Độ Chuyên Môn: <input type="text" name="trinhDoChuyenMon" required><br>
        Mã Khoa: <input type="number" name="maKhoa" required><br>
        Chức Vụ: <input type="text" name="chucVu" required><br>
        <input type="submit" value="Thêm Nhân Viên">
    </form>
</body>
</html>

