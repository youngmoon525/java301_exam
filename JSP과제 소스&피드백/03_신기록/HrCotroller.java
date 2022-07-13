package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import hr.HrDAO;

@WebServlet("*.hr")
public class HrCotroller extends HttpServlet {
	RequestDispatcher rd;
	HrDAO dao = new HrDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사원목록조회 ");
		rd = req.getRequestDispatcher("error/404.jsp"); // 나중에 추가 예정(2022.06.30 KYM)
		if (req.getServletPath().equals("/list.hr")) {
			req.setAttribute("list", dao.getList());// jsp에서 사용할수있게 담음(저장)
			rd = req.getRequestDispatcher("hr/list.jsp");
		}
		rd.forward(req, resp);
	}

}