package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class StudentDAO {
	//ArrayList<StudentDTO> 를 10건 리턴하는 메소드 작성
	// getManualList();
	// 접근제한자 리턴타입 메소드이름(){
	// }
	
	
	//필드
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList<StudentDTO> getManualLIst(){
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		for (int i = 0; i < 10; i++) {
			list.add(new StudentDTO("a", "b", "c", "d", "e", i+""));
		}
		return list;
	}
	
	
	//DB연결
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			System.out.println("getConn Error !");
		}
		return conn;
	}	
		
	//DB연결종료
	public void dbClose() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
				
			}
		} catch (Exception e) {
		}
	}
	
	//1을 조회하는 메소드
	public void selectOne() {
		conn = getConn();
		String sql = "select 1 as num1 from dual";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("num1"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
	}
	
	public ArrayList<StudentDTO> getList(){
		conn= getConn();
		String sql = "select s.student_name, u.user_id,  u.user_pw,  u.first_name,  u.last_name, u.student_no from USER_INFO u LEFT OUTER JOIN STUDENT s"
				+ " ON u.STUDENT_NO = s.STUDENT_NO";
		ArrayList<StudentDTO> list = new ArrayList<>();
		try {
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new StudentDTO(rs.getString("student_name"), rs.getString("user_id"), rs.getString("user_pw"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("student_no")));
			}
//			for (StudentDTO studentDTO : list) {
//				System.out.println(studentDTO.getStudent_name());
//				System.out.println(studentDTO.getUser_id());
//				System.out.println(studentDTO.getUser_pw());
//				System.out.println(studentDTO.getFirst_name());
//				System.out.println(studentDTO.getLast_name());
//				System.out.println(studentDTO.getStudent_no());
//			}
			System.out.println(list.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	
	//학생 한명의 상태정보 담는 DTO
	
	public StudentDTO getStudentInfo(String user_id, String student_no) {
		StudentDTO dto = new StudentDTO();
		conn = getConn();
		String sql = " select s.student_name, u.* "
				+ " from USER_INFO u LEFT OUTER JOIN STUDENT s ON u.STUDENT_NO = s.STUDENT_NO WHERE u.user_id = ? AND u.student_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, student_no);
			rs = ps.executeQuery();
			while(rs.next()) {
			
					dto.setStudent_name(rs.getString("student_name"));
					dto.setUser_id(rs.getString("user_id"));
					dto.setUser_pw(rs.getString("user_pw"));
					dto.setFirst_name(rs.getString("first_name"));
					dto.setLast_name(rs.getString("last_name"));
					dto.setStudent_no(rs.getString("student_no"));
					dto.setAdmin_yn(rs.getString("admin_yn"));
					dto.setMoney(rs.getString("money"));
					dto.setCreate_ymd(rs.getString("create_ymd"));
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
//		ArrayList<StudentDTO> list = getList();
//		StudentDTO dto = new StudentDTO();
//		for (StudentDTO studentDTO : list) {
//			if(studentDTO.getUser_id().equals(user_id)) {
//				dto.setStudent_name(studentDTO.getStudent_name());
//				dto.setUser_id(studentDTO.getUser_id());
//				dto.setUser_pw(studentDTO.getUser_pw());
//				dto.setFirst_name(studentDTO.getFirst_name());
//				dto.setLast_name(studentDTO.getLast_name());
//				dto.setStudent_no(studentDTO.getStudent_no());
//			}
//		}
		return dto;
	}
	
//	public StudentDTO getStudentInfo(HttpServletRequest req) {
//		StudentDTO dto = null;
//		conn = getConn();
//		String sql = "select s.student_name, u.user_id,  u.user_pw,  u.first_name,  u.last_name, u.student_no from USER_INFO u LEFT OUTER JOIN STUDENT ON u.STUDENT_NO = s.STUDENT_NO WHERE u.user_id = ? AND u.student_no = ?";
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, req.getParameter("user_id"));
//			ps.setString(2, req.getParameter("student_no"));
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				System.out.println(rs.getString("student_no"));
//				
//			}
//			
//		} catch (Exception e) {
//		}
//		return null;
//	}
	
	
	//수정하기 메소드
	public void updateInfo(String student_name, String first_name, String last_name, String user_id, int student_no) {
		conn = getConn();
		String sql = "update user_info set first_name =?, last_name =?  where user_id = ? AND student_no = ? ";
		String sql1 = "update student set student_name = ? where student_no = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setString(3, user_id);
			ps.setInt(4, student_no);
			
			int rs;
			rs= ps.executeUpdate(); 
			dbClose();
			ps = conn.prepareStatement(sql1);
			ps.setString(1, student_name);
			ps.setInt(2, student_no);
			rs = ps.executeUpdate();
			
			if(rs != -1) {
				System.out.println("수정완료");
			}else {
				System.out.println("수정실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dbClose();
		}
	}
	
	public void modifyInfo(String first_name, String last_name, String user_id , String student_no) {
		conn = getConn();
		String sql = "update user_info set first_name=?, last_name = ? where user_id = ? AND student_no = ?";
		int rs = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setString(3, user_id);
			ps.setString(4, student_no);
			
			
			rs = ps.executeUpdate();
			if(rs != -1) {
				System.out.println("됨");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
	}


	public void deleteInfo(String user_id , String student_no) {
		conn = getConn();
		String sql = "delete from user_info  where user_id = ? AND student_no = ?";
		int rs = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, student_no);
			rs = ps.executeUpdate();
			if(rs != -1) {
				System.out.println("됨");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	
	
	
	
	
	
	
	
	
}

