package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employees.EmpDAO;


@WebServlet("*.hr")
public class EmpController extends HttpServlet {
	RequestDispatcher rd;
	EmpDAO dao = new EmpDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rd = req.getRequestDispatcher("error/404.jsp"); // 나중에 추가 예정(2022.06.30 HAI)
		if( req.getServletPath().equals("/list.hr")) {
			req.setAttribute("empList", dao.getEmpList());
			rd = req.getRequestDispatcher("employees/empList.jsp");//이동 확인 완료 220710
		}
		rd.forward(req, resp);
	}
	
}
