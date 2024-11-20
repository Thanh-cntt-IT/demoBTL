<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.NhanVien" %> <!-- Thay "yourpackage" bằng package thực tế của bạn -->
<html>
<head>
    <title>Quản Lý Nhân Viên</title>
</head>
<body>
    <h1>Danh sách Nhân Viên</h1>
    <a href="addNhanVien.jsp">Thêm Nhân Viên Mới</a>
    <table border="1">
        <tr>
            <th>Mã Nhân Viên</th>
            <th>Họ Tên</th>
            <th>Ngày Sinh</th>
            <th>Địa Chỉ</th>
            <th>Trình Độ Chuyên Môn</th>
            <th>Mã Khoa</th>
            <th>Chức Vụ</th>        
        </tr>
        <%
            List<NhanVien> nhanVienList = (List<NhanVien>) request.getAttribute("nhanVienList");
            if (nhanVienList != null) {
                for (NhanVien nv : nhanVienList) {
        %>
        <tr>
            <td><%= nv.getMaNhanVien() %></td>
            <td><%= nv.getHoTen() %></td>
            <td><%= nv.getNgaySinh() %></td>
            <td><%= nv.getDiaChi() %></td>
            <td><%= nv.getTrinhDoChuyenMon() %></td>
            <td><%= nv.getMaKhoa() %></td>
            <td><%= nv.getChucVu() %></td>
            <td>
                <a href="editNhanVien.jsp?maNhanVien=<%= nv.getMaNhanVien() %>">Chỉnh Sửa</a> |
               <a href="deleteNhanVien?maNhanVien=<%= nv.getMaNhanVien() %>" onclick="return confirm('Bạn có chắc muốn xóa nhân viên này không?');">Xóa</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
