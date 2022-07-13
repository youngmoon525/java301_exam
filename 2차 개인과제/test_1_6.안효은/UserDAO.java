package test_1_6;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class UserDAO {
	
	Scanner sc = new Scanner(System.in);
	
	//1. 로그인
	//DB에 저장된 ID와 Password가 사용자가 콘솔에 입력한 것과 일치한 경우 TRUE,
	//그 외에는 FALSE를 리턴하는 메소드를 만들어서 기능 구현하기
	//로그인 완료시 다시 메뉴가 보여지게 만들기
	//→ 회원 정보 수정 - UPDATE, 회원 탈퇴 - DELETE, 공지사항 보기 - NOTICE 테이블에 저장된 글의 정보 출력
	//2. 회원가입
	//USER 테이블에 INSERT 수행
	//3. 로그아웃
	//로그인 된 상태라면 메뉴 보여주며 프로그램 종료
	//4. 프로그램 종료
	//루프를 끝내고 프로그램을 종료
	
	
	//====================기본사항====================//
	
	//오라클과 연결 준비
	Connection conn;		//연결객체
	PreparedStatement ps;	//전송객체
	ResultSet rs;			//결과객체
	
	//Connection 만들기 - 연결
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
		}//try
		return conn;
	}//Connection getConn()
	
	//연결된 데이터베이스 닫아주기
	public void dbClose() {
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
			e.printStackTrace();
			System.out.println("error");
		}//try
	}//dbClose()
	
	//프로그램 종료
	public void exit() {
		System.out.println("프로그램을 종료합니다 bye");
		dbClose();
	}//exit()
	
	//오타
	public void error() {
		System.out.println("잘못 입력하셨습니다.");
	}//error()
	
	//사용자에게 어떤 메세지를 보여줌과 동시에 스캐너로 값을 입력받음.
	public String rtnStrMsg(Scanner sc, String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}//rtnStrMsg()
	
	
	//====================USER_INFO====================//
	
	//조회하고 DTO에 자료 집어넣기, 마지막에 DB 닫기
	public ArrayList<UserDTO> getUserList(){
		conn = getConn();
		
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		
		String sql = "SELECT * FROM user_info";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				UserDTO dto = new UserDTO(
						rs.getInt("STUDENT_NO"),
						rs.getString("USER_ID"),
						rs.getString("USER_PW"),
						rs.getString("FIRST_NAME"),
						rs.getString("LAST_NAME"),
						rs.getString("CREATE_YMD"),
						rs.getString("UPDATE_YMD"),
						rs.getString("ADMIN_YN"));
				list.add(dto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}finally {
			dbClose();
		}//try
		return list;
	}//getUserList()
	
	//id자료만 확인하기
	public boolean checkId(String id) {
		conn = getConn();
		String sql = "SELECT COUNT (*) CNT FROM user_info WHERE user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt("CNT") == 1) {
					return true;
				}//if
			}//while
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}finally {
			dbClose();
		}//try		
		return false;
	}//checkId()
	
	//사랑님이 하신 id 중복 확인
	public boolean check(String id) {
		conn = getConn();
		String sql = "SELECT user_id FROM user_info ";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("user_id").equals(id)) {
					//System.out.println("중복된 아이디입니다");
					return true;
				}//if
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}//try
		return false;
	}//check()
	
	//로그인
	public UserDTO login(String id , String pw) { // 네이버 : 아이디 입력 , 비밀번호 입력
		//연결 -> 전송 -> 결과
		UserDTO dto = new UserDTO();
		conn = getConn();
		String sql = " select * from USER_INFO WHERE user_id = ? AND user_pw = ? ";
		// 물음표 갯수 <=> ps.set갯수 맞춰줌
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id); // 왼쪽을기준으로 첫번째 물음표를 찾고 그물음표에 어떤값을넣음
			ps.setString(2, pw); //
			rs = ps.executeQuery();
			while(rs.next()) {
				dto.setStudent_no(rs.getInt("student_no"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pw(rs.getString("user_pw"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return dto;
	}//login()
	
	public boolean login1(UserDTO dto) {
		 
		conn = getConn();
		String sql = " select * from USER_INFO WHERE user_id = ? and user_pw = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id()); // 왼쪽을기준으로 첫번째 물음표를 찾고 그물음표에 어떤값을넣음
			ps.setString(2, dto.getUser_pw()); //
			rs = ps.executeQuery();
			while(rs.next()) {
				dto.setStudent_no(rs.getInt("student_no"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pw(rs.getString("user_pw"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;
	}//login1
	
	//사랑님이 하신 로그인 확인
	public boolean loginUser1(UserDTO dto) {
		 
		conn = getConn();
		String sql = " select * from USER_INFO WHERE user_id = ? and user_pw = ? ";
		try {
		for (int i = 0; i < 3; i++) {
			System.out.print("아이디를 입력해주세요 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호를 입력해주세요 : ");
			String pw = sc.nextLine();
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
				}else {
					System.out.println("로그인 실패");
				}
			}//for
			System.out.println("로그인 3회 실패로 인해 종료합니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				dbClose();
			}
		return false;
	}//loginUser1

	
	//회원 가입
	public boolean join(UserDTO dto) {
		conn = getConn();
		
		String sql = "INSERT INTO user_info values(6,?,?,?,?,sysdate,sysdate,'N',0)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getUser_pw());
			ps.setString(3, dto.getFirst_name());
			ps.setString(4, dto.getLast_name());
			System.out.println(ps.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}	
		return false;
	}//join()
	
	//회원정보보기
	public void viewList(UserDTO dto) {
		System.out.println("학생번호 : " + dto.getStudent_no());
		System.out.println("아이디 : " + dto.getUser_id());
		System.out.println("비밀번호 : " + dto.getUser_pw());
		System.out.println("이름 : " + dto.getFirst_name());
		System.out.println("성 : " + dto.getLast_name());
	}//viewList()
	
	//회원정보수정 - 키 값은 수정 되면 안됨
	public void userUpdate(UserDTO joinDto) {
		conn = getConn();//커넥션 객체 초기화(연결)
		String sql = "UPDATE user_info SET user_pw = ?, first_name = ?, last_name = ?, update_ymd = sysdate WHERE user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, joinDto.getUser_pw());
			ps.setString(2, joinDto.getFirst_name());
			ps.setString(3, joinDto.getLast_name());
			ps.setString(4, joinDto.getUser_id());
			System.out.println(ps.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
	}//userUpdate()
	
	//회원 탈퇴
	public void userDelete(UserDTO dto) {
		conn = getConn();
		String sql = "DELETE user_info WHERE user_id = ? AND user_pw = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getUser_pw());
			System.out.println(ps.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
	}//userDelete()
		
}//class
