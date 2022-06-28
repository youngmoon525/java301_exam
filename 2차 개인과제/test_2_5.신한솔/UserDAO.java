package test.last;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserDAO {
	public Connection conn;
	public PreparedStatement ps;	//전송객체
	public ResultSet rs;	//결과객체
	
	Scanner scn = new Scanner(System.in);
	UserDTO dto = new UserDTO();
	
	//스캐너입력
	public String scnMsg(Scanner scn, String msg) {
		System.out.print(msg);
		return scn.nextLine();
	}
	
	//오라클 연결
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn Error!!!!");
		}//try
		return conn;
	}//getConnection()
	
	//DB닫기
	public void dbClose() {
		try {
			if(rs != null) {
				rs.close();
			}//if
				
			if(ps != null) {
				ps.cancel();
			}//if
		
			if(conn != null) {
				conn.close();
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try
	}//dbClose()
	
	//로그인(true/false)
	public boolean login(UserDTO dto) {
		conn = getConnection();
		String sql = "SELECT *  FROM user_info  WHERE user_id = ?  AND user_pw = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getUser_pw());
			
			rs = ps.executeQuery();
			while(rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pw(rs.getString("user_pw"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				return true;
			}//while
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 오류");
		} finally {
			dbClose();
		}//try
		return false;
	}
	
	//로그인
	public UserDTO login_2(String id, String pw) {
		conn = getConnection();
		String sql = "SELECT *  FROM user_info  WHERE user_id = ?  AND user_pw = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pw(rs.getString("user_pw"));
				//dto.setFirst_name(rs.getString("first_name"));
				//dto.setLast_name(rs.getString("last_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 오류");
		} finally {
			dbClose();
		}//try
		return dto;
	}//login()
	
	//회원정보수정
	public UserDTO update(UserDTO dto) {
		conn = getConnection();
		String sql = "UPDATE user_info  SET last_name = ?, first_name = ?, UPDATE_YMD = sysdate  WHERE user_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getLast_name());
			ps.setString(2, dto.getFirst_name());
			ps.setString(3, dto.getUser_id());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		return dto;
	}//update()
		
	//회원탈퇴 
	public boolean quit(UserDTO dto) {
		conn = getConnection();
		String sql = "DELETE FROM user_info WHERE student_no = 5 AND user_id = ? AND user_pw = ?";
			
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getUser_pw());
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		return false;
	}//quit()
		
	//회원가입
	public UserDTO join(UserDTO dto) {
		conn = getConnection();
		String sql = "INSERT INTO user_info VALUES (5, ?, ?, ?, ?, sysdate, sysdate, 'N', 0)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getUser_pw());
			ps.setString(3, dto.getFirst_name());
			ps.setString(4, dto.getLast_name());
			ps.executeUpdate();
			System.out.println("회원가입이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		return dto;
	}//join()
	
	//아이디 값 비교
	public int eqauls(String id) {
		conn = getConnection();
		String sql = "SELECT count(*) FROM user_info WHERE student_no = 5 AND user_id = ?";
		int a = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				//rs.getString("user_id");
				a = rs.getInt("count(*)");
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		return a;
	}//equals()
	
}//class