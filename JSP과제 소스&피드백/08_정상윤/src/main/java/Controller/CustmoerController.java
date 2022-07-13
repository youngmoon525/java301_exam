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
public class CustmoerController extends HttpServlet {
	//①보낼곳 정해주는 RequestDispatcher 선언
	RequestDispatcher rd;
	CustomerDAO dao = new CustomerDAO();
	//②서비스 메소드 생성
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getServletPath().equals("/list.cu")) {
			System.out.println("고객관리 눌림");
//			dao.test();
			req.setAttribute("list", dao.getList());
//			rd = req.getRequestDispatcher("customer/list.jsp");
			req.setAttribute("list1", "방구야");
			rd = req.getRequestDispatcher("customer/listjstl.jsp");
			
			
		}else if(req.getServletPath().equals("/insert.cu")) {
			CustomerDTO dto = new CustomerDTO();
			dto.setName(req.getParameter("name"));
			dto.setPhone(req.getParameter("phone"));
			dto.setEmail(req.getParameter("email"));
			dto.setGender(req.getParameter("gender"));
			int result = dao.insert(dto);
			
			return;
		}else if(req.getServletPath().equals("/update.cu")) {
			CustomerDTO dto = new CustomerDTO();
			dto.setId(req.getParameter("id"));
			dto.setName(req.getParameter("name"));
			dto.setPhone(req.getParameter("phone"));
			dto.setEmail(req.getParameter("email"));
			dto.setGender(req.getParameter("gender"));
			int result = dao.update(dto);
			
			//out.println <= ajax나 다른 플랫폼에서 요청했을때 return하기 위해서 많이 쓴다.
			PrintWriter out = resp.getWriter();	//응답
			out.println(result);	//정보수정 성공시 1 리턴
			
			return;
			
		}
		rd.forward(req, resp);
	}
	

}
