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
import java.util.List;

@WebServlet("/listNhanVien")
public class NhanVienServerlet extends HttpServlet {
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> nhanVienList = nhanVienDAO.getAllEmployees();
        request.setAttribute("nhanVienList", nhanVienList);
        request.getRequestDispatcher("nhanvien.jsp").forward(request, response);
    }
}
