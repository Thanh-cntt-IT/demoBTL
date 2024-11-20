/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Model.NhanVien;
import DAO.NhanVienDAO;

@WebServlet("/updateNhanVien")
public class EditNhanVienServlet extends HttpServlet {
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Lấy dữ liệu từ form
            int maNhanVien = Integer.parseInt(request.getParameter("MaNhanVien"));
            String hoTen = request.getParameter("hoTen");
            String ngaySinhStr = request.getParameter("ngaySinh");
            String diaChi = request.getParameter("diaChi");
            String trinhDoChuyenMon = request.getParameter("trinhDoChuyenMon");
            int maKhoa = Integer.parseInt(request.getParameter("maKhoa"));
            String chucVu = request.getParameter("chucVu");

            // Chuyển chuỗi ngày sinh thành đối tượng Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date ngaySinh = dateFormat.parse(ngaySinhStr);

            // Tạo đối tượng NhanVien với dữ liệu mới
            NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, ngaySinh, diaChi, trinhDoChuyenMon, maKhoa, chucVu);

            // Gọi phương thức DAO để cập nhật thông tin nhân viên
            nhanVienDAO.updateEmployee(nhanVien);

            // Chuyển hướng về trang danh sách nhân viên
            response.sendRedirect("listNhanVien");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("editNhanVien.jsp?error=UpdateFailed");
        }
    }
}

