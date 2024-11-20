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
import DAO.NhanVienDAO;
import Model.NhanVien;
@WebServlet("/deleteNhanVien")
public class DeleteNhanVienServlet extends HttpServlet {
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Lấy mã nhân viên từ tham số yêu cầu
            int maNhanVien = Integer.parseInt(request.getParameter("maNhanVien"));
            
            // Gọi phương thức DAO để xóa nhân viên theo mã
            nhanVienDAO.deleteEmployee(maNhanVien);
            
            // Chuyển hướng về trang danh sách nhân viên sau khi xóa thành công
            response.sendRedirect("listNhanVien");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("listNhanVien?error=DeleteFailed");
        }
    }
}

