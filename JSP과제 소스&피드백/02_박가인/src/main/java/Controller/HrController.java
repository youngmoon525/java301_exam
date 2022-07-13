package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.HrDAO;

@WebServlet("*.hr")
public class HrController extends HttpServlet {
	RequestDispatcher rd;
	HrDAO dao = new HrDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사원목록조회 ");
		rd = req.getRequestDispatcher("error/404.jsp"); 
		if (req.getServletPath().equals("/list.hr")) {
			req.setAttribute("list", dao.getList());
			rd = req.getRequestDispatcher("hr/list.jsp");
		}
		rd.forward(req, resp);
	}

}
