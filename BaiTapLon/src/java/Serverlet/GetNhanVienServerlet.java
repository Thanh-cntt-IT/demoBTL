import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import Model.NhanVien;
import DAO.NhanVienDAO;

@WebServlet("/getNhanVien")
public class GetNhanVienServerlet extends HttpServlet {
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy mã nhân viên từ tham số yêu cầu
        int maNhanVien = Integer.parseInt(request.getParameter("maNhanVien"));
        
        // Sử dụng NhanVienDAO để lấy dữ liệu của nhân viên dựa trên mã nhân viên
        NhanVien nhanVien = nhanVienDAO.getEmployeeById(maNhanVien);
        
        // Kiểm tra xem nhân viên có tồn tại không
        if (nhanVien != null) {
            // Đặt thuộc tính để chuyển đến JSP
            request.setAttribute("nhanVien", nhanVien);
            // Chuyển tiếp đến trang JSP để hiển thị thông tin chi tiết nhân viên (ví dụ: editNhanVien.jsp)
            request.getRequestDispatcher("editNhanVien.jsp").forward(request, response);
             request.getRequestDispatcher("deleteNhanVien.jsp").forward(request, response);
        } else {
            // Nếu không tìm thấy nhân viên, chuyển hướng đến danh sách nhân viên với thông báo lỗi
            response.sendRedirect("listNhanVien?error=NhanVienNotFound");
        }
    }
}
