package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employees.EmployeesDAO;
import employees.EmployeesDTO;

@WebServlet("*.hr")
public class EmployeesController extends HttpServlet {
	RequestDispatcher rd;
	EmployeesDAO dao = new EmployeesDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("직원");
		rd = req.getRequestDispatcher("error/404.jsp"); // 나중에 추가 예정(2022.06.30 KYM)
		if (req.getServletPath().equals("/list.hr")) {
			req.setAttribute("list", dao.getList());
			rd = req.getRequestDispatcher("employees/list.jsp");
		}
		rd.forward(req, resp);
	}

}
