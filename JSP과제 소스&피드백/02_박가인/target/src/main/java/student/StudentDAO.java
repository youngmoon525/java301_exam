package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

public class StudentDAO {
	StudentDTO dto = new StudentDTO();
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	// ArrayList<StudentDTO>를 10건 리턴하는 메소드 작성
	public ArrayList<StudentDTO> getManualList() {
		ArrayList<StudentDTO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new StudentDTO("a", "b", "c", "d", "e", i));
		}

		return list;
	}

	// 데이터베이스 연결
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn Error !");
		}

		return conn;
	}// getConn

	// 데이터베이스 접속 끊기
	public void dbClose() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}// dbClose

	public void selectOne() {
		getConn();
		String sql = "SELECT 1 as num1 FROM dual";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("num1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

	}

	public ArrayList<StudentDTO> getList(){
		getConn();
		ArrayList<StudentDTO> list = new ArrayList<>();
	
		String sql = "SELECT u.*,s.student_name"
						+ " FROM student s LEFT OUTER JOIN user_info u"
						+ " ON s.student_no = u.student_no";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new StudentDTO(rs.getString("user_id"), rs.getString("user_pw"), rs.getString("first_name"),rs.getString("last_name") ,
						rs.getString("student_name"), rs.getInt("student_no")));
			}
			System.out.println(list.size());
		/*	for (int i=0; i<list.size();) {
				list.get(0).getStudent_name()
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return list;
	}
	
	public StudentDTO getStudentInfo(String student_no, String user_id) {
		StudentDTO dto = null;
		getConn();
		String sql = "SELECT u.*,s.student_name "
				+ " FROM user_info u left outer join student s "
				+ " On u.student_no =s.student_no "
				+ " WHERE u.student_no = ? AND u.user_id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,student_no);
			ps.setString(2,user_id);
			rs = ps.executeQuery();
			while(rs.next()) {		
				dto =new StudentDTO(rs.getString("user_id"), rs.getString("user_pw"),rs.getString("first_name"),rs.getString("last_name"), rs.getString("student_name"), rs.getInt("student_no"));
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return dto; 
	}

}
