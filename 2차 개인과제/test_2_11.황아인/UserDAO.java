package Last_Project_11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import pack05.ojdbc2.UserInfoDTO;

public class UserDAO {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	UserDTO dto = new UserDTO();// updateUser() return dto; 에 대한 임시 인스턴스변수
	String id = "";
	String pw = "";

	protected String login, update, delete, notice, info;

	public Connection getConn() {// 연결
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		// oracle.jdbc.driver.OracleDriver ※이거 꼭!! 확인 하기!!
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {// 전체 Exception으로 바꿔주기
			e.printStackTrace();
			System.out.println("getConn Error!");
			System.out.println("일시적 오류로 인한 불편을 드려 죄송합니다. " + "조금만 기다리시면 빠르게 복구하도록 하겠습니다.");
		} // try
		return conn;
	}// getConn()

	public void dbClose() {// 콘솔닫
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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dbClose Error!");
			System.out.println("일시적 오류로 인한 불편을 드려 죄송합니다. " + "조금만 기다리시면 빠르게 복구하도록 하겠습니다.");
		}

	}// dbClose()

	public String rtnStrMsg(Scanner sc, String mag) {// 입력 + 메세지 출력
		System.out.print(mag + " ");
		return sc.nextLine();
	}


	// SELECT user_id, user_pw, last_name||first_name FROM user_info WHERE user_id =
	// 'HAI' AND user_pw = '1234';
	public boolean loginUser(String id, String pw) {// 로그인

		conn = getConn();
		String sql = " SELECT student_no, user_id, user_pw, first_name, last_name FROM user_info WHERE user_id = ? AND user_pw = ? ";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while (rs.next()) {
				dto.setStudent_no(rs.getInt("student_no"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pw(rs.getString("user_pw"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));

				System.out.println("어서오세요 " + rs.getString("last_name") + rs.getString("First_name") + "님 반갑습니다!!");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loginUser Error!");
			System.out.println("일시적 오류로 인한 불편을 드려 죄송합니다. " + "조금만 기다리시면 빠르게 복구하도록 하겠습니다. 이용해주셔서 감사합니다.");
		} finally {
			dbClose();
		}
		return false;
	}// loginUser()

	public boolean updateCheck(String id, String pw) {
//		String sql = " SELECT user_id, user_pw, first_name, last_name, student_no FROM user_info WHERE  user_id = ? AND user_pw = ? ";

		conn = getConn();
		String sql = " SELECT user_id, user_pw, first_name, last_name FROM user_info WHERE  user_id = ? AND user_pw = ? ";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while (rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pw(rs.getString("user_pw"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("userInfo Error!");
			System.out.println("일시적 오류로 인한 불편을 드려 죄송합니다. " + "조금만 기다리시면 빠르게 복구하도록 하겠습니다. 이용해주셔서 감사합니다.");
		} finally {
			dbClose();
		} // try
		return false;
	}

	public void updateUser(UserDTO dto) {
		conn = getConn();
		// UPDATE user_info SET user_pw = '5678', first_name = 'TJ', last_name = 'H'
		// WHERE user_id = 'HAI' AND student_no = '11';
		// UPDATE user_info SET user_pw = ?, first_name = ?, last_name = ? WHERE user_id
		// = ? AND student_no = ?
		String sql = " UPDATE user_info SET user_pw = ?, first_name = ?, last_name = ? WHERE user_id = ? AND student_no = 11 ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_pw());
			ps.setString(2, dto.getFirst_name());
			ps.setString(3, dto.getLast_name());
			ps.setString(4, dto.getUser_id());
			ps.executeUpdate();//수정

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateUser Error!");
			System.out.println("일시적 오류로 인한 불편을 드려 죄송합니다. " + "조금만 기다리시면 빠르게 복구하도록 하겠습니다. 이용해주셔서 감사합니다.");
		} finally {
			dbClose();
		} // try

	}

	public boolean deleteUser(String id) {// 탈퇴
		conn = getConn();
		try {
			String sql = " DELETE FROM user_info WHERE user_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate(); // 수정 
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deleteUser Error!");
			System.out.println("일시적 오류로 인한 불편을 드려 죄송합니다. " + "조금만 기다리시면 빠르게 복구하도록 하겠습니다. 이용해주셔서 감사합니다.");
		} finally {
			dbClose();
		} // try
		return false;
	}// deleteUser()

	public UserDTO joinUser(UserDTO dto) {// 회원가입
		conn = getConn();
		String sql = "INSERT INTO user_info VALUES ( 11, ?, ?, ?, ?, SYSDATE, SYSDATE, 'N', 50000 )";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getUser_pw());
			ps.setString(3, dto.getFirst_name());
			ps.setString(4, dto.getLast_name());
			ps.executeUpdate(); // UPDATE!!!
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("joinUser Error!");
			System.out.println("일시적 오류로 인한 불편을 드려 죄송합니다. " + "조금만 기다리시면 빠르게 복구하도록 하겠습니다. 이용해주셔서 감사합니다.");
		} finally {
			dbClose();
		} // try
		return dto;
	}

	
	
}// c
