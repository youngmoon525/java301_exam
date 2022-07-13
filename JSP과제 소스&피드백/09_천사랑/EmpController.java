package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Emp.EmpDAO;

@WebServlet("*.hr")
public class EmpController extends HttpServlet {
	RequestDispatcher rd;
	EmpDAO dao = new EmpDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getServletPath().equals("/list.hr");
		req.setAttribute("list", dao.getList());
		rd = req.getRequestDispatcher("emp/list.jsp");
		rd.forward(req, resp);
	}
}























/*
	SELECT  e.employee_id 사번, e.last_name || ' ' || e.first_name 이름, e.email 이메일, NVL(TO_CHAR(e.department_id),'정보없음'),
        e.phone_number 휴대전화, NVL(TO_CHAR(d.department_name),'정보없음') 부서명, NVL( TO_CHAR(c.country_name || ' ' || l.state_province || ' ' ||
        l.city  || ' ' || l.street_address || ' ' || l.postal_code), '정보없음') 전체주소, NVL(TO_CHAR(m.부서최대급여),'정보없음') 부서최대급여,
        NVL(TO_CHAR(m.부서최소급여),'정보없음') 부서최소급여, NVL(TO_CHAR(ROUND(m.부서평균급여,2)),'정보없음')부서평균급여
	FROM    employees e left outer join departments d
	ON      e.department_id = d.department_id
	left outer join     locations l
	ON      d.location_id = l.location_id 
	left outer join countries c
	ON      l.country_id = c.country_id
	LEFT OUTER JOIN (SELECT department_id, MAX(salary) 부서최대급여 , MIN(salary) 부서최소급여 , AVG(salary) 부서평균급여 FROM employees GROUP BY department_id) m
	ON       e.department_id = m.department_id
*/