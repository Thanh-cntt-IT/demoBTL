<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.MonAn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lý Món Ăn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .action-buttons a {
            margin-right: 10px;
            text-decoration: none;
            color: white;
            padding: 5px 10px;
            background-color: #007BFF;
            border-radius: 3px;
        }
        .action-buttons a:hover {
            background-color: #0056b3;
        }
        .delete-button {
            background-color: #FF4C4C;
        }
        .delete-button:hover {
            background-color: #C30000;
        }
    </style>
</head>
<body>
    <h1>Quản Lý Món Ăn</h1>

    <!-- Hiển thị thông báo nếu có -->
    <%
        String message = request.getParameter("message");
        if (message != null) {
    %>
    <p style="color: green;"><%= message %></p>
    <%
        }
    %>

    <!-- Form thêm món ăn -->
    <h2>Thêm Món Ăn</h2>
    <form action="MonAnServlet" method="post">
        <input type="hidden" name="action" value="add">
        Tên Món Ăn: <input type="text" name="tenMonAn" required>
        Giá: <input type="number" name="gia" step="0.01" required>
        Danh Mục: <input type="text" name="moTa" required>
        <input type="submit" value="Thêm">
    </form>

    <!-- Danh sách món ăn -->
    <h2>Danh Sách Món Ăn</h2>
    <table>
        <tr>
            <th>Mã</th>
            <th>Tên Món Ăn</th>
            <th>Giá</th>
            <th>Danh Mục</th>
            <th>Hành Động</th>
        </tr>
        <%
            List<MonAn> listMonAn = (List<MonAn>) request.getAttribute("listMonAn");
            if (listMonAn != null) {
                for (MonAn monAn : listMonAn) {
        %>
        <tr>
            <td><%= monAn.getMaMonAn() %></td>
            <td><%= monAn.getTenMonAn() %></td>
            <td><%= monAn.getGia() %></td>
            <td><%= monAn.getDanhMuc() %></td>
            <td class="action-buttons">
                <a href="MonAnServlet?action=edit&maMonAn=<%= monAn.getMaMonAn() %>">Sửa</a>
                <a href="MonAnServlet?action=delete&maMonAn=<%= monAn.getMaMonAn() %>" class="delete-button"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa món ăn này?');">Xóa</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">Không có món ăn nào.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
