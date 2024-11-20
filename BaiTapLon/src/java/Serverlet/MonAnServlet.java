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
import Model.MonAn;
import DAO.MonAnDAO;
import java.util.List;
/**
 *
 * @author xuant
 */
@WebServlet("/MonAnServlet")
public class MonAnServlet extends HttpServlet {
    private MonAnDAO monAnDAO = new MonAnDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if (action == null) {
                listMonAn(request, response); // Hiển thị danh sách món ăn
            } else {
                switch (action) {
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        deleteMonAn(request, response);
                        break;
                    default:
                        listMonAn(request, response);
                        break;
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
          
                switch (action) {
                    case "add":
                        addMonAn(request, response);
                        break;
                    case "update":
                        updateMonAn(request, response);
                        break;
                   
                  
                }
            
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // 1. Hiển thị danh sách món ăn
    private void listMonAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MonAn> listMonAn = monAnDAO.getAllMonAn();
        request.setAttribute("listMonAn", listMonAn);
        request.getRequestDispatcher("listMonAn.jsp").forward(request, response);
        
    }

    // 2. Hiển thị form sửa món ăn
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maMonAn = Integer.parseInt(request.getParameter("MaMonAn"));
        MonAn existingMonAn = monAnDAO.getMonAnById(maMonAn);
        request.setAttribute("monAn", existingMonAn);
        request.getRequestDispatcher("editMonAn.jsp").forward(request, response);
    }

    // 3. Thêm món ăn
    private void addMonAn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tenMonAn = request.getParameter("tenMonAn");
        double gia = Double.parseDouble(request.getParameter("gia"));
        String moTa = request.getParameter("moTa");

        MonAn monAn = new MonAn(0, tenMonAn, gia, moTa);
        monAnDAO.addMonAn(monAn);
        response.sendRedirect("MonAnServlet");
    }

    // 4. Cập nhật món ăn
    private void updateMonAn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maMonAn = Integer.parseInt(request.getParameter("maMonAn"));
        String tenMonAn = request.getParameter("tenMonAn");
        double gia = Double.parseDouble(request.getParameter("gia"));
        String moTa = request.getParameter("moTa");

        MonAn monAn = new MonAn(maMonAn, tenMonAn, gia, moTa);
        monAnDAO.updateMonAn(monAn);
        response.sendRedirect("MonAnServlet");
    }

    // 5. Xóa món ăn
    private void deleteMonAn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maMonAn = Integer.parseInt(request.getParameter("MaMonAn"));
        monAnDAO.deleteMonAn(maMonAn);
        response.sendRedirect("listMonAn");
    }
}
