package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import customer.CustomerDTO;

@WebServlet("*.tt")
public class jstlController extends HttpServlet {
	//①보낼곳 정해주는 RequestDispatcher 선언
	RequestDispatcher rd;
	CustomerDAO dao = new CustomerDAO();
	//②서비스 메소드 생성
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getServletPath().equals("/list.js")) {
//			req.setAttribute("list", dao.getList());
			System.out.println("왓니?");
			rd = req.getRequestDispatcher("jstl/list.jsp");
			
		}else if(req.getServletPath().equals("/listfmt.js")) {
			rd = req.getRequestDispatcher("jstl/listfmt.jsp");
		}else if(req.getServletPath().equals("/listfn.js")) {
			rd = req.getRequestDispatcher("jstl/listfn.jsp");
		}
		rd.forward(req, resp);
	}
	

}
