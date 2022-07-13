package pack01.ha;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	
	//연결
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		// ※
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn Error !");
		}
		return conn;
	}
	
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//로그인1
	public boolean loginUser1(UserDTO dto) {
		conn = getConn();
		String sql = " select * from USER_INFO WHERE user_id = ? and user_pw = ? ";
		try {
			String id = "";
			String pw = "";
		for (int i = 0; i < 3; i++) {
			System.out.print("아이디를 입력해주세요 : ");
			id = sc.nextLine();
			System.out.print("비밀번호를 입력해주세요 : ");
			pw = sc.nextLine();
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pw);
				rs = ps.executeQuery();
				if(rs.next()) {
					dto.setUser_id(rs.getString("user_id"));
					dto.setUser_pw(rs.getString("user_pw"));
					dto.setFirst_name(rs.getString("first_name"));
					dto.setLast_name(rs.getString("last_name"));
					
					
					return true;
				}//if
				System.out.println("로그인 실패");
			}//for
			System.out.println("로그인 3회 실패로 인해 종료합니다.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				dbClose();
			}
		
		return false;
		
	}//loginUser1
	
	
	
	//로그인
	public UserDTO loginUser(String id, String pw) {
		UserDTO dto = new UserDTO();
		conn = getConn();
		String sql = " select * from USER_INFO WHERE user_id = ? and user_pw = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pw(rs.getString("user_pw"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return dto;
	}

	//회원가입
	public boolean joinUser(UserDTO dto) {
		conn = getConn();
		String sql = "INSERT INTO USER_INFO " + 
					" VALUES(9, ?, ?, ?, ?, SYSDATE, SYSDATE, 'N', 0)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getUser_pw());
			ps.setString(3, dto.getFirst_name());
			ps.setString(4, dto.getLast_name());
			ps.executeUpdate();
			System.out.println("회원가입이 완료되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return false;
	}
	
	//아이디 중복확인
	public boolean check(String id) {
		conn = getConn();
		String sql = "SELECT user_id FROM user_info ";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("user_id").equals(id)) {
					System.out.println("중복된 아이디입니다");
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//회원정보 수정
	public void update(UserDTO dto) {
		//String spl = "UPDATE USER_INFO " + " SET user_pw = ? WHERE user_id = ?";
		String spl =  "UPDATE USER_INFO " + " SET user_pw = ?, first_name = ?, last_name = ?, UPDATE_YMD = sysdate  WHERE user_id = ?";
		
		System.out.print("정보수정 위해 현재 비밀번호를 입력하세요 : ");
		String input = sc.nextLine();
		while(true) {
			if(input.equals(dto.getUser_pw()) ) {
		
			}else {
				System.out.print("다시 입력해주세요 : ");
				input = sc.nextLine();
			}
			try {
				System.out.println("변경하실 정보를 선택하세요 1.비밀번호 2.이름 3.성");
				int ch = Integer.parseInt(sc.nextLine());
				if(ch == 1) {
					System.out.print("변경하실 비밀번호를 입력하세요 : ");
					dto.setUser_pw(sc.nextLine());
					if(input.equals(dto.getUser_pw()) ) {
						System.out.println("현재 비밀번호와 다르게 입력해주세요");
						continue; 
					}
				}else if(ch == 2) {
					System.out.print("변경하실 이름을 입력하세요 : ");
					dto.setFirst_name(sc.nextLine());
					if(input.equals(dto.getFirst_name()) ) {
						System.out.println("현재 이름과 다르게 입력해주세요");
						continue; 
					}
				}else if(ch == 3) {
					System.out.print("변경하실 성을 입력하세요 : ");
					dto.setLast_name(sc.nextLine());
					if(input.equals(dto.getLast_name()) ) {
						System.out.println("현재 성과 다르게 입력해주세요");
						continue; 
					}
				}else {
					System.out.println("잘못입력하셨습니다");
					break;
				}
				
				conn = getConn();
				ps = conn.prepareStatement(spl);
				ps.setString(1, dto.getUser_pw());
				ps.setString(2, dto.getFirst_name());
				ps.setString(3, dto.getLast_name());
				ps.setString(4, dto.getUser_id());
				ps.executeUpdate();
				System.out.println("변경이 완료되었습니다.");
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				dbClose();
			}//try
		}
	}

	//회원탈퇴
	public boolean delete(UserDTO dto) {
		conn = getConn();
		String sql = "DELETE FROM USER_INFO "
				+ " WHERE user_id = ? ";
		try {
			System.out.print("정말 회원정보를 삭제하시겠습니까? ▶ 삭제 : Y / 취소 : 그 외 입력 ");
			String de = sc.nextLine();
			if(de.toUpperCase().equals("Y")) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			System.out.println("삭제합니다!");
			ps.executeUpdate();
			return true;
			}else {
				System.out.println("회원정보를 삭제하지 않습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return false;
	}
	
	
	
	
	
}//class
