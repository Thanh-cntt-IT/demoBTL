<%-- 
    Document   : editNhanVien
    Created on : Nov 14, 2024, 2:30:26 PM
    Author     : xuant
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.NhanVien" %> <!-- Thay "yourpackage" bằng tên package thực tế -->
<html>
<head>
    <title>Chỉnh Sửa Nhân Viên</title>
</head>
<body>
    <h1>Chỉnh Sửa Thông Tin Nhân Viên</h1>
    
    <%
        NhanVien nhanVien = (NhanVien) request.getAttribute("nhanVien");
        if (nhanVien == null) {
            out.println("Không tìm thấy thông tin nhân viên.");
        } else {
    %>
    <form action="updateNhanVien" method="post">
        <input type="hidden" name="maNhanVien" value="<%= nhanVien.getMaNhanVien() %>">
        
        Họ Tên: <input type="text" name="hoTen" value="<%= nhanVien.getHoTen() %>" required><br>
        Ngày Sinh: <input type="date" name="ngaySinh" value="<%= nhanVien.getNgaySinh() %>" required><br>
        Địa Chỉ: <input type="text" name="diaChi" value="<%= nhanVien.getDiaChi() %>" required><br>
        Trình Độ Chuyên Môn: <input type="text" name="trinhDoChuyenMon" value="<%= nhanVien.getTrinhDoChuyenMon() %>" required><br>
        Mã Khoa: <input type="number" name="maKhoa" value="<%= nhanVien.getMaKhoa() %>" required><br>
        Chức Vụ: <input type="text" name="chucVu" value="<%= nhanVien.getChucVu() %>" required><br>
        
        <input type="submit" value="Lưu Thay Đổi">
    </form>
    <%
        }
    %>
</body>
</html>

