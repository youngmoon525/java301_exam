package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.StudentDAO;
import student.StudentDTO;

@WebServlet("*.st")// *<-전체를 받는 url패턴(맵핑)사용할때는 /<- 빼야됨 오류남
public class StudentCotroller extends HttpServlet {
	RequestDispatcher rd ;
	StudentDAO dao = new StudentDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rd = req.getRequestDispatcher("error/404.jsp"); // 나중에 추가 예정(2022.06.30 KYM)
		if(req.getServletPath().equals("/list.st")) {	
			//추후 DB에서 가져온 정보를 이용 =>지금은 ArrayList를 수동으로 만들기
			ArrayList<StudentDTO> list = dao.getManualLIst();
			req.setAttribute("list", list);
			// JSP 에 보내서 출력 해보기 
			rd = req.getRequestDispatcher("student/list.jsp");
		}else if (req.getServletPath().equals("/test.st")) {	//DB연결 테스트했음
		//	dao.selectOne();
//			dao.getList();
		}else if(req.getServletPath().equals("/detail.st")) {
			System.out.println("여기까지 옴 한명의 정보(상세정보)를 조회해야함");
			System.out.println(req.getParameter("student_no")); 
			System.out.println(req.getParameter("user_id")); 
			// detail.jsp <- 상세정보를 확인할 수 있는 (헤더, 푸터 ) 그대로 있고 내용만 바뀌게
			
			
			//DAO에 getStudentInfo 메소드를 만들기
			//DTO 데이터베이스 컬럼이랑 맞춰서 만들어놓은 클래스(필드==데이터베이스 컬럼)
//			dao.getStudentInfo((String)req.getParameter("user_id"),Integer.parseInt(req.getParameter("student_no")));
			StudentDTO dto = dao.getStudentInfo( req.getParameter("user_id"), req.getParameter("student_no"));
			req.setAttribute("dto", dto);
			rd = req.getRequestDispatcher("student/detail.jsp");
		}else if(req.getServletPath().equals("/update.st")) {
			req.setAttribute("dto", req.getAttribute("dto"));
			rd = req.getRequestDispatcher("student/update.jsp");
		}else if(req.getServletPath().equals("/modify.st")) {
//			dao.updateInfo(req.getParameter("student_name"),req.getParameter("first_name"),req.getParameter("last_name"),req.getParameter("user_id"),Integer.parseInt(req.getParameter("student_no")));
			//UPDATE 쿼리를 실행하고나서 0보다 큰 숫자가 return되는지를 체크해보기.
			  dao.modifyInfo(req.getParameter("first_name"),req.getParameter("last_name"),req.getParameter("user_id"), req.getParameter("student_no"));
			  resp.sendRedirect("list.st");
				return;
//			rd= req.getRequestDispatcher("student/modify.jsp");
		}else if(req.getServletPath().equals("/delete.st")) {
			dao.deleteInfo(req.getParameter("user_id"),req.getParameter("student_no"));
			resp.sendRedirect("list.st");
			return;
		}
		rd.forward(req, resp);
	}
}
