package pack05.ojdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import oracle.jdbc.driver.OracleDriver;

public class StudentDAO {
	Connection conn;
	PreparedStatement ps; //질의문객체
	ResultSet rs ;
	

	public Connection getConn() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		// ※
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			//jdbc드라이버를 통해 커넥션 만드는 class(static객체생성필용x). get메서드로 사용
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn Error !");
		}

		return conn;
	}

	public void dbClose() {
		// 어떤 순서대로 닫아야할까? 열때 통신연결로를 열고 전송객체를 보내고 결과 객체 받음.
		// 통신을 열때랑 역순으로 닫아주면 된다. 
		try { // == < 참조를 시작했는지를 알수있는
			if (rs != null) {
				rs.close();// 3 ?
			}
			if (ps != null) {
				ps.close();// 2
			}
			if (conn != null) {
				conn.close();// 1
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	
	public ArrayList<StudentDTO> getStudentList(){
		conn = getConn();
		String sql = " select * from student ";
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		try {
			ps = conn.prepareStatement(sql);//반복되는 질의문정리할떄사용 객체 -인수값공간확보
			rs = ps.executeQuery();			//질의문 실행 메소드
			while(rs.next()) {
				//확인용 System.out.println(rs.getInt("student_no") + "  " +rs.getString("student_name"));
				StudentDTO dto = new StudentDTO(rs.getInt("student_no"), rs.getString("student_name"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		// Connection객체 등등을 이용해서 DB에서 정보를 가지고옴 그결과를 리턴
		// 출력은 메인클래스 또는 DAO에 viewList라는 메소드를 통해서 작업 
		return list;
	}
	
	// viewList 라는 메소드는 조회 된 결과를 전체 콘솔창에 출력하는 메소드임.
	public void viewList(ArrayList<StudentDTO> list) { // <=
		if(list == null || list.size() == 0) {
			System.out.println("보여줄 목록이 없습니다.");
			return ;
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getStudent_no() + "." + list.get(i).getStudent_name());
		}
	}

	public boolean loginUser(UserInfoDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
