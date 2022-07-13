import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs ;
	UserDTO dto = new UserDTO();
	
	//데이터베이스 연결
	public Connection getConn() {
		String url="jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user="hanul";
		String password="0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn Error !");
		}

		return conn;
	}//getConn
	
	//데이터베이스 접속 끊기
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

	}//dbClose
	
	//로그인메소드
	public boolean userLogin(String id,String pw) {
		//NoticeDTO noticeDto = new NoticeDTO();
		conn = getConn();//db연결
		String sql = " select * from USER_INFO WHERE user_id = ? and user_pw = ? "; //sqㅣ문
					try {
						ps = conn.prepareStatement(sql); //sql문을 db에 전송
						ps.setString(1, id); //전송객체에다가 id입력
						ps.setString(2, pw);  
						rs = ps.executeQuery();//응답받기 ,select는 executeQuery이고 나머지 delete, insert는 executeUpdate
						while(rs.next()) {
							rs.getString("user_id");
							rs.getString("user_pw");
							return true;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						dbClose();
					}
					return false;
	}//userLogin
	
	//
	
	//회원가입메소드
	public int userJoin(UserDTO dto) {
		conn =getConn();
		String sql= " INSERT INTO USER_INFO VALUES (?, ?, ?, ?, ?, sysdate, sysdate,'N','0')";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,dto.getStudent_no());
			ps.setString(2, dto.getUser_id());
			ps.setString(3, dto.getUser_pw());
			ps.setString(4, dto.getFirst_name());
			ps.setString(5, dto.getLast_name());
			int result = ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return -1;
	}//userJoin
	
}