<%-- 
    Document   : deleteNhanVien
    Created on : Nov 14, 2024, 2:36:51 PM
    Author     : xuant
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.NhanVien" %> <!-- Thay "yourpackage" bằng tên package thực tế -->
<html>
<head>
    <title>Xóa Nhân Viên</title>
</head>
<body>
    <h1>Xác Nhận Xóa Nhân Viên</h1>
    
    <%
        NhanVien nhanVien = (NhanVien) request.getAttribute("nhanVien");
        if (nhanVien == null) {
            out.println("Không tìm thấy thông tin nhân viên.");
          
        } else {
    %>
    <p>Bạn có chắc chắn muốn xóa nhân viên sau?</p>
    <ul>
        <li><strong>Mã Nhân Viên:</strong> <%= nhanVien.getMaNhanVien() %></li>
        <li><strong>Họ Tên:</strong> <%= nhanVien.getHoTen() %></li>
    </ul>
    
    <form action="deleteNhanVien" method="get">
        <!-- Gửi mã nhân viên để thực hiện xóa -->
        <input type="hidden" name="maNhanVien" value="<%= nhanVien.getMaNhanVien() %>">
        
        <input type="submit" value="Xác Nhận Xóa">
        <a href="listNhanVien">Hủy Bỏ</a> <!-- Liên kết để quay lại trang danh sách nếu hủy bỏ -->
    </form>
    <%
        }
    %>
</body>
</html>

