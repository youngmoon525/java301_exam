package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.HrDAO;
import hr.HrDTO;

@WebServlet("*.hr")
public class HrController extends HttpServlet {
	RequestDispatcher rd;
	HrDAO dao = new HrDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getServletPath().equals("/list.hr")) {
			List<HrDTO> list = dao.getList();
			req.setAttribute("list", list);
			rd = req.getRequestDispatcher("hr/list.jsp");
		}else {
			System.out.println("접근 실패");
		}
		rd.forward(req, resp);
		
	}
}
