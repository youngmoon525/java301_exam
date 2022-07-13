package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import customer.CustomerDTO;
import student.StudentDTO;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {

	RequestDispatcher rd;
	CustomerDAO dao = new CustomerDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		if (req.getServletPath().equals("/list.cu")) {
			dao.test();
			req.setAttribute("list", dao.getList());
			rd = req.getRequestDispatcher("customer/listjstl.jsp");
		} else if (req.getServletPath().equals("/insert.cu")) {
			CustomerDTO dto = new CustomerDTO();
			dto.setName(req.getParameter("name"));
			dto.setGender(req.getParameter("gender"));
			dto.setPhone(req.getParameter("phone"));
			dto.setEmail(req.getParameter("email"));
			int result = dao.insert(dto);
			String name = req.getParameter("name");
			System.out.println(req.getParameter("name"));
			return;
		}else if(req.getServletPath().equals("/update.cu")) {
			CustomerDTO dto = new CustomerDTO();
			dto.setName(req.getParameter("name"));
			dto.setEmail(req.getParameter("email"));
			dto.setPhone(req.getParameter("phone"));
			dto.setGender(req.getParameter("gender"));
			dto.setId(Integer.parseInt(req.getParameter("id")));
			int result = dao.update(dto);
			PrintWriter out = resp.getWriter(); //응답
			out.println(result);
			return;
		}
		rd.forward(req, resp);
	}
}
