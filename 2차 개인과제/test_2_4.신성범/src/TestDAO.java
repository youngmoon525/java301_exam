import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	// 오라클 연결 메소드
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
	}

	// 닫는 메소드
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

	}

	// 로그인
	public TestDTO loginUser(Scanner sc) {
		TestDTO dto = new TestDTO();
		conn = getConn();
		String sql = " select * from USER_INFO WHERE user_id = ? and user_pw = ? ";
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 3; i >= 1; i--) {
				System.out.println("로그인");
				System.out.println("아이디를 입력해주세요.");
				String id = sc.nextLine();
				System.out.println("패스워드를 입력해주세요.");
				String pw = sc.nextLine();
				ps.setString(1, id);
				ps.setString(2, pw);
				rs = ps.executeQuery();
				if (rs.next()) {
					dto.setUser_id(rs.getString("user_id"));
					dto.setUser_pw(rs.getString("user_pw"));
					dto.setFirst_name(rs.getString("first_name"));
					dto.setLast_name(rs.getString("last_name"));
					System.out.println("로그인 성공");
					break;
				}
				System.out.println("기회가" + i + "번 남았습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return dto;
	}

	// 회원가입
	public boolean joinUser(TestDTO dto) {
		if (!doublecheck(dto.getUser_id())) {
			conn = getConn();
			String sql = " INSERT INTO USER_INFO VALUES (4, ?, ?, ?, ?, sysdate, sysdate, 'N', 100000000) ";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getUser_id());
				ps.setString(2, dto.getUser_pw());
				ps.setString(3, dto.getFirst_name());
				ps.setString(4, dto.getLast_name());

				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
		} else {
			System.out.println("중복된 아이디입니다.");
		}

		return false;
	}

	// 스캐너와 문자출력 메소드
	public String rtnStrMsg(Scanner sc, String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}

	// 패스워드 및 이름 수정 메소드
	public boolean UpdateUser(TestDTO dto) {
		conn = getConn();
		Scanner sc = new Scanner(System.in);
		String change = "";
		System.out.println("1.비밀번호 수정\t2.이름수정");
		String ch = sc.nextLine();
		if (ch.equals("1")) {
			dto.setUser_pw(rtnStrMsg(sc, "변경할 비밀번호를 입력하세요"));
			change = "user_pw";
		} else if (ch.equals("2")) {
			dto.setFirst_name(rtnStrMsg(sc, "변경할 이름을 입력하세요"));
			change = "first_name";
		}

		String sql = "UPDATE  USER_INFO " + " SET     " + change + " = ? " + " WHERE  USER_id = ? ";
		try {
			String update = "";
			if (ch.equals("1")) {
				update = dto.getUser_pw();
			} else if (ch.equals("2")) {
				update = dto.getFirst_name();
			}

			ps = conn.prepareStatement(sql);
			ps.setString(1, update);
			ps.setString(2, dto.getUser_id());
			ps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;

	}

	// 회원 탈퇴
	public boolean deleteUser(TestDTO dto, Scanner sc) {
		String iidd = rtnStrMsg(sc, "아이디를 입력해주세요");
		if (iidd.equals(dto.getUser_id())) {
			String ppww = rtnStrMsg(sc, "비밀번호를 입력해주세요");
			if (ppww.equals(dto.getUser_pw())) {
				conn = getConn();
				String sql = " DELETE FROM USER_INFO WHERE USER_ID = ? ";
				try {
					ps = conn.prepareStatement(sql);
					ps.setString(1, dto.getUser_id());
					ps.executeUpdate();
					System.out.println("아이디가 삭제 되었습니다");
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					dbClose();
				}
			} else {
				System.out.println("비밀번호가 틀립니다");
			}
		} else {
			System.out.println("아이디가 틀렸습니다");
		}
		return false;
	}

	// 아이디 중복확인 메소드
	public boolean doublecheck(String user_id) {
		conn = getConn();
		String sql = "SELECT      *  FROM        USER_INFO";
		ArrayList<TestDTO> list = new ArrayList<TestDTO>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				TestDTO testdto = new TestDTO();
				testdto.setStudent_no(rs.getInt("student_no"));
				testdto.setUser_id(rs.getString("user_id"));
				testdto.setUser_pw(rs.getString("user_pw"));
				testdto.setFirst_name(rs.getString("first_name"));
				testdto.setLast_name(rs.getString("last_name"));
				testdto.setCreate_ymd(rs.getString("create_ymd"));
				testdto.setUpdate_ymd(rs.getString("update_ymd"));
				testdto.setAdmin_yn(rs.getString("admin_yn"));
				testdto.setMoney(rs.getInt("money"));
				list.add(testdto);
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getUser_id().equals(user_id)) {
					return true;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;
	}

	// 공지사항 메소드
	public ArrayList<NotDTO> Notice() {
		conn = getConn();
		String sql = "SELECT      *  FROM        notice_six";
		ArrayList<NotDTO> list = new ArrayList<NotDTO>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				NotDTO dto = new NotDTO(rs.getInt("page"), rs.getString("subject"), rs.getString("memo"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// 공지사항 목록이 콘솔에 보이기 위한 메소드
	public void viewList(ArrayList<NotDTO> list) {
		if (list == null || list.size() == 0) {
			System.out.println("보여줄 목록이 없습니다.");
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getPage() + "\t");
			System.out.print(list.get(i).getSubject() + "\t");
			System.out.println(list.get(i).getMemo());
		} // for

	}// viewList()
}// class
