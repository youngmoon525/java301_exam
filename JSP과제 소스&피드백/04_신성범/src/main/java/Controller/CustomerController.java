package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import customer.CustomerDTO;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	RequestDispatcher rd;
	CustomerDAO dao = new CustomerDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if(req.getServletPath().equals("/list.cu")) {
		List<CustomerDTO> list = dao.getList();
		req.setAttribute("list", list);
		rd = req.getRequestDispatcher("customer/listjstl.jsp");
		
		
		
		
		}else if (req.getServletPath().equals("/insert.cu")) {
			CustomerDTO dto = new CustomerDTO();
			dto.setName(req.getParameter("name"));
			dto.setPhone(req.getParameter("phone"));
			dto.setEmail(req.getParameter("email"));
			dto.setGender(req.getParameter("gender"));
			int result = dao.insert(dto);
			return ;
		
		}else if (req.getServletPath().equals("/update.cu")) {
			CustomerDTO dto = new CustomerDTO();
			dto.setId(Integer.parseInt(req.getParameter("id")));
			dto.setName(req.getParameter("name"));
			dto.setPhone(req.getParameter("phone"));
			dto.setEmail(req.getParameter("email"));
			dto.setGender(req.getParameter("gender"));
			int result = dao.update(dto);
			PrintWriter out = resp.getWriter();
			out.println(result);
			return ;
		}
		rd.forward(req, resp);
	}

}
