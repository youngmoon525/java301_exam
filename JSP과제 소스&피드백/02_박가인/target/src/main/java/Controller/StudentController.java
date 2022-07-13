package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.StudentDAO;
import student.StudentDTO;

@WebServlet("*.st")
public class StudentController extends HttpServlet {
	RequestDispatcher rd;
	StudentDAO dao = new StudentDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rd= req.getRequestDispatcher("error/404.jsp");// 나중에 추가 예정 (2022.06.30. PGI)	
		
		if(req.getServletPath().equals("/list.st")){
			ArrayList<StudentDTO> list =dao.getList();
			for (int i = 0; i <list.size(); i++) {
				System.out.println(list.get(i));
			}
			Object oList = dao.getManualList();
			req.setAttribute("list", list);
		rd= req.getRequestDispatcher("student/list.jsp");
		
		}else if(req.getServletPath().equals("/test.st")) {
			System.out.println("여기까지 옴 ");
			System.out.println(req.getParameter("studentno")); 
			System.out.println(req.getParameter("user_id")); 
		
			
		}else if(req.getServletPath().equals("/detail.st")) {
			StudentDTO dto = dao.getStudentInfo(req.getParameter("studentno"),req.getParameter("user_id"));
			System.out.println("여기까지 옴 ");
			System.out.println(req.getParameter("studentno")); //클라이언트로부터 전달된 파라미터 값을 가져올 때 request.getParameter() 메소드 사용!!!
			System.out.println(req.getParameter("user_id")); 
			req.setAttribute("dto",dto);
			rd= req.getRequestDispatcher("student/detail.jsp");
		}else if(req.getServletPath().equals("/update.st")) {

			StudentDTO dto = dao.getStudentInfo(req.getParameter("student_no"),req.getParameter("user_id"));
			req.setAttribute("dto",dto);
			rd= req.getRequestDispatcher("student/update.jsp");
		}
		
		rd.forward(req, resp);
	}
}