package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDTO;
import employee.EmployeeDAO;
import employee.EmployeeDTO;


@WebServlet("*.hr")
public class EmployeeController extends HttpServlet {
	RequestDispatcher rd;
	EmployeeDAO dao = new EmployeeDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getServletPath().equals("/list.hr")) {
			
			List<EmployeeDTO> list = dao.getList();
			System.out.println(list.size());
			req.setAttribute("list", list);
			rd = req.getRequestDispatcher("employee/list.jsp");
		}
	
	
	
		rd.forward(req, resp);

	
	
	
	}
}
