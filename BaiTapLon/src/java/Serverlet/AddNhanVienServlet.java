/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.NhanVienDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import Model.NhanVien;
/**
 *
 * @author xuant
 */
@WebServlet("/addNhanVien")
public class AddNhanVienServlet extends HttpServlet {
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoTen = request.getParameter("hoTen");
        String ngaySinhStr = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String trinhDoChuyenMon = request.getParameter("trinhDoChuyenMon");
        int maKhoa = Integer.parseInt(request.getParameter("maKhoa"));
        String chucVu = request.getParameter("chucVu");

        try {
            Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinhStr);
            NhanVien nhanVien = new NhanVien(0, hoTen, ngaySinh, diaChi, trinhDoChuyenMon, maKhoa, chucVu);
            nhanVienDAO.addEmployee(nhanVien);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("listNhanVien");
    }
}
