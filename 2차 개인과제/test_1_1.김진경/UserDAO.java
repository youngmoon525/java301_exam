import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;




public class UserDAO {
	
	
	 protected Connection conn; 
	 protected PreparedStatement ps ; 
	 protected ResultSet rs; 
	 protected String Menu;
	 Scanner sc = new Scanner(System.in);
	 
	 
	 
	 //연결 메소드 ==================================================================
	public Connection getConn() { 
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password); //3번째 껄로 해주면 3개의 파라매터가 자동으로 넘어가
		} catch (Exception e) {  //전체 예외 잡아주게 바꿔줘
			e.printStackTrace();
			System.out.println("getConn Error !");
		}//try
		return conn;
	}//getConn
	

	//로그인=========================================================================
	public boolean getLogin(UserDTO dto) {
		//int cnt = 3;
		conn = getConn();
		String sql = " select * from USER_INFO WHERE user_id = ? and user_pw = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			System.out.println();
			int cnt = 3;
			for (int i = 3; i > 0; i--) {
				cnt--;
				System.out.print(" ◆아이디를 입력해주세요 : "); 
				String id = sc.nextLine(); 
				System.out.println();
				System.out.print(" ◆패스워드를 입력해주세요 : "); 
				String pw = sc.nextLine(); 
				System.out.println();
				ps.setString(1, id);
				ps.setString(2, pw);
				rs = ps.executeQuery();

				if(rs.next()) {
					dto.setUser_id(rs.getString("user_id"));
					dto.setUser_pw(rs.getString("user_pw"));
					System.out.println("\t\t◆ 로그인 성공 ◆ \n\n\t 　　[ " + id + " ]님 환영합니다!");
					return true;
				}//if
				System.out.println(" → 로그인 실패 - 시도 가능 횟수 " + cnt + "회 남았습니다." +"\n");
			}//for
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}//try
		return false;
	}//getLogin
	
	
	//회원 가입=========================================================================
	public String joinUser(UserDTO dto) { 
		// dto.setStudent_no(Integer.parseInt(sc.nextLine()));
	
		
		conn = getConn();
		String sql =  " INSERT INTO USER_INFO "
				+ " VALUES(1, ?, ?, ?, ?, sysdate, sysdate, 'n', 0) " ;
		String id = null;
		try {
			
			System.out.println("\t\t<회원가입 창입니다.>\n");
			while(true) {
				
			System.out.print("◆ 사용하실 ID 를 입력해주세요 :");
			id = sc.nextLine();
			
			if(joinCheck(id)){
			System.out.println("◆ 아이디 : " + id);
			System.out.print("◆ 비밀번호를 입력해주세요 : ");
			String pw = sc.nextLine();
			System.out.print("◆ First_name을 입력해주세요 :");
			String fn =sc.nextLine();
			System.out.print("◆ Last_name을 입력해주세요 : ");
			String ln = sc.nextLine();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, fn);
			ps.setString(4, ln);
			ps.executeUpdate(); //■ 쿼리가 아니라 update
			System.out.println();
			System.out.println("◆가입 완료 : [" + id + "]님 환영합니다!\n");
			dto.setUser_id(id);// 유저 아이디만 채워주면 해결되던것였다... 중복검사 거쳐서 ok이 떨어질때만 넘어가고. 아니면 안넘어가..! 
			break;
			}else {
				System.out.println();
				
			}
		}//while
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}//true
		return id;
	}//joinUser

	
	//중복확인 ==================================================================
	public boolean joinCheck(String id) {
		conn = getConn();
		String sql = "SELECT user_id"
				+ " FROM  user_info"
				+ " WHERE user_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			ArrayList<String> list = new ArrayList<String>();  
			
			while(rs.next()) {
				list.add(rs.getString("user_id"));
			}//while
			
			if(list.size()==0) {  //중복이 아니다! 없다!
				System.out.println("\n<사용가능한 아이디 입니다!>\n");
				return true;
			}else {
			System.out.println("\n<중복된 아이디 입니다!>\n");
			//joinUser();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		//	dbClose();  //여기 문닫아버리면 SQL예외뜸 ㅎㅎ.... 닫지말자 
		}
		return false;
	}//
	
	
	//회원정보 수정 =====================================================================
	 public boolean updateUser(UserDTO dto) {
		 System.out.println("\n============================================================\n");	
		 System.out.println("  　　　　< 어떤 정보를 수정할까요? >\n");
		 System.out.println("1. 비밀번호, 2. Firt_name(이름), 3. Last_name(성) \n");
		 System.out.println("\n============================================================\n");	
		 conn= getConn();
		 Menu = sc.nextLine();
		String sql;
		try {
			if(Menu.equals("1")) {
				int cnt = 3;
 				for(int i = 0; i < 3; i++) {
 					cnt--;
					System.out.print("◆ 다시 비밀번호를 입력해주세요 : ");
					String user_pw = sc.nextLine();
					
						if(user_pw.equals(dto.getUser_pw())) {
							System.out.print("\n◆ 비밀번호를 변경해주세요 : ");
							dto.setUser_pw(user_pw=sc.nextLine()); 
							
						    sql = " UPDATE user_info SET user_pw = ? WHERE user_id = ?";
							ps = conn.prepareStatement(sql);
							ps.setString(1, dto.getUser_pw());
							ps.setString(2, dto.getUser_id());
							
							ps.executeUpdate();
							
							System.out.println("\n◆ 비밀번호가 변경 되었습니다!\n");
							return true;
						}else {
							System.out.println("◆ 일치하지 않습니다!");
							System.out.println(" →시도 가능 횟수 " + cnt + "회 남았습니다.\n");
						//	continue;
							}//if
				}//for
				System.out.println("▶ 3회 입력 오류 - 메인으로 돌아갑니다!\n");
				
				
			}else if (Menu.equals("2")) {
				System.out.print("◆ First_name을 변경해주세요 : ");
	     		String first_name = sc.nextLine();
	     		
	     		dto.setFirst_name(first_name);
	     		
	     		sql = " UPDATE user_info SET FIRST_NAME = ? WHERE user_id = ?";
		     		ps = conn.prepareStatement(sql);
					ps.setString(1, dto.getFirst_name());
					ps.setString(2, dto.getUser_id());
					ps.executeUpdate();
				System.out.println("◆ First_name이 [ " + first_name + " ]로 변경 되었습니다!");
			}else {
				System.out.print("◆ Last_name을 변경해주세요 : ");
				String last_name = sc.nextLine();
				
				dto.setLast_name(last_name);
				
				sql = " UPDATE user_info SET Last_NAME = ? WHERE user_id = ?";
					ps = conn.prepareStatement(sql);
					ps.setString(1, dto.getLast_name());
					ps.setString(2, dto.getUser_id());
					ps.executeUpdate();
				System.out.println();
				System.out.println("◆ Last_name이 [ " + last_name + " ]로 변경 되었습니다!\n");
						
					}//if
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return false;
	 }//updateUser
	
	 
	 
	
	 //회원탈퇴 ============================================================================
	 public boolean userDelete(UserDTO dto) { 
		 System.out.println("\n============================================================\n");	
		 		 System.out.println("\t　　　　<정말 회원탈퇴 하시겠습니까?>\n");  
		 		 System.out.println("\t\t　　1.네, 2. 아니요");
		 		System.out.println("\n============================================================\n");	
		 		 
		 		 try {
	 			 conn = getConn();
//		 			conn = getConn();
	 			 String	sql = "SELECT  * FROM user_info WHERE user_pw = ?";
	 			 String menu = sc.nextLine();
		 			if(menu.equals("1")) {
		 				int cnt = 3;
		 				for(int i = 0; i < 3; i++) {
		 					cnt--;
		 					System.out.println("● 비밀번호를 다시 입력해주세요 : "); 
		 					String user_pw= sc.nextLine();
	 				
			 				if(user_pw.equals(dto.getUser_pw())) {
			 					
			 					sql =  "DELETE FROM user_info WHERE user_id = ? ";
			 					
			 					ps = conn.prepareStatement(sql);
			 					ps.setString(1, dto.getUser_id());
			 					ps.executeUpdate();
			 					
			 					System.out.println("　　　🛸　　\t　　\t🌎　°　\r\n"
			 							+ " 🌓　•　　.°•　🚀 ✯\r\n"
			 							+ "　　★　*　　　°　　　　🛰 　°·　 🪐\r\n"
			 							+ ".　　　•　° ★　• ☄\r\n"
			 							+ "▁▂▃▄▅▆▇▇▆▅▄▃▁\n");
			 					System.out.println("\t다음에 또 만나요!");			 			
			 					dto = null;
			 					return true;
//			 					break;
			 				}else {
			 				//	dto.setUser_pw(dto.getUser_pw());
			 					System.out.println("◆ 일치하지 않습니다!");
			 					System.out.println(" →기회가 " + cnt + "회 남았습니다.\n");//for문 밖으로 나가면 이게 도달이 안돼. 그니까 여기 넣어줘
			 					continue;
			 					
			 				}//if
		 					
		 				}//for
		 				System.out.println("▶ 3회 입력 오류로 페이지가 종료됩니다!");
		 				
		 				}else if(menu.equals("2")) {
		 				  System.out.println("다시 만나서 반가워요!\n");
		 				  
		 			}//if
		 		} catch (SQLException e) {
		 			e.printStackTrace();
		 		} finally {
		 			dbClose();
		 		}
		 		 return false;
		 	 }//userDelete
	 
    //notice_six(공지사항) 테이블 조회 +출력 =============================================================
	 public ArrayList<NoticeSixDTO> noticeSix() {
		 ArrayList<NoticeSixDTO> list = new ArrayList<NoticeSixDTO>();
		 
		 conn = getConn();
		 String sql  = "SELECT * FROM notice_six order by page ";
		 
		 try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//NoticeSixDTO dto = new NoticeSixDTO();
			//	dto = new NoticeSixDTO(rs.getInt("page"), rs.getString("subject"), rs.getString("memo"));
				list.add(new NoticeSixDTO(rs.getInt("page"), rs.getString("subject"), rs.getString("memo"))); //dto 를 넣는 대신 걍 때려넣기
				
			}//while
			System.out.println("< 공 지 사 항 >\n");
			System.out.println(" - 권한이 없어 조회만 가능합니다.\n");
			for (int i = 0; i < list.size(); i++) { //가져왔으니까 이제 콘솔에 출력! 보여주기while문에 넣어주면 반복되서 뒤죽박죽으로 나옴;;
				System.out.println(list.get(i).getPage() + "." + list.get(i).getSubject() + "." + list.get(i).getMemo()+ "\n");
			}//for
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}//try
		 return list;
	 }//notice
	
	 //종료 메소드 ==========================================================================
	 public boolean exit() {
		 System.out.println("\n============================================================\n");	
			System.out.println("\t　　　　<정말 종료하시겠습니까?>   \n");
			System.out.println("\t　　　　　　1.네, 2. 아니요");
			System.out.println("\n============================================================\n");	
			 Menu = sc.nextLine();
			if (Menu.equals("1")) {
//				String[] strs = {"🛸　　🌎　°　 🌓　•　　.°•　🚀 ✯\r\n","　　★　*　　　°　　　　🛰 　°·　 🪐\r\n", ".　　　•　° ★　• ☄\r\n","▁▂▃▄▅▆▇▇▆▅▄▃▁","\t다음에 또 만나요!"};
//				Sleep sl = new Sleep(strs);
//				sl.start();
				System.out.println("　　　🛸　　\t　　\t🌎　°　\r\n"
						+ " 🌓　•　　.°•　🚀 ✯\r\n"
						+ "　　★　*　　　°　　　　🛰 　°·　 🪐\r\n"
						+ ".　　　•　° ★　• ☄\r\n"
						+ "▁▂▃▄▅▆▇▇▆▅▄▃▁\n");
				System.out.println("\t다음에 또 만나요!");
				return true;
			} else {
				System.out.println("◆ 메인으로 돌아갑니다!");
				System.out.println();
				
			} // if
			return false;
	 }//exit
	 
	 
	//문자열 메소드 ========================================================================= 
	public String rtnStrMsg(Scanner sc, String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}//문자열
	
	
	//문닫아주는 메소드 ======================================================================
	public void dbClose() {
		try {
		 if(rs !=null) {
			rs.close();  
			}//if
		 if(ps !=null) {  
			ps.close();	
			}//if
		 if(conn != null) {
			conn.close();	
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try
}//dbClose()
	
//	public void dd(Scanner sc) {
//		StudentDAO dao = new StudentDAO();
//		StudentDTO dto = new StudentDTO();
//		ArrayList<StudentDTO> list = dao.getStudentList();
//		
//		System.out.println("번호입력");
//		int num = Integer.parseInt(sc.nextLine());
//		String name = null;
//		for (StudentDTO studentDTO : list) {
//			if(num==studentDTO.getStudent_no()) {
//				name = studentDTO.getStudent_name();
//			}
//		}
//		System.out.println(name +"님");
//		
//	}
	
	
}//class

