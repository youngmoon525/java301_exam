package pack05.ojdbc2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInfoDAO extends StudentDAO {
	Scanner sc = new Scanner(System.in);

	public boolean loginUser(UserInfoDTO dto) {  
		conn = getConn();
		String sql = " select * from USER_INFO WHERE user_id = ? and user_pw = ? ";
		try {
			int j = 3;
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < 3; i++) {
				j--;

				System.out.println("로그인");
				System.out.println("아이디를 입력해주세요.");// <=inputType
				String id = sc.nextLine();
				System.out.println("패스워드를 입력해주세요.");// <=input type='password'
				String pw = sc.nextLine();
				ps.setString(1, id); // 왼쪽을기준으로 첫번째 물음표를 찾고 그물음표에 어떤값을넣음
				ps.setString(2, pw); //
				rs = ps.executeQuery();

				if (rs.next()) {

					dto.setUser_id(rs.getString("user_id"));
					dto.setUser_pw(rs.getString("user_pw"));
					System.out.println("로그인");
					return true;
				}//if
				System.out.println("기회"+j+"회 남았습니ㅏ다");
				
			}//for

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return false;
		
		
	}

	public boolean joinUser(UserInfoDTO dto) {
		conn = getConn();// USER_ID, USER_PW, FIRST_NAME, LAST_NAME
		String sql = " INSERT INTO USER_INFO VALUES (1, ?, ?, ?, ?, sysdate, sysdate,'N',0) ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getUser_pw());
			ps.setString(3, dto.getFirst_name());
			ps.setString(4, dto.getLast_name());

			System.out.println(ps.executeUpdate());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
		}
		// 메인 회원정보를 입력받고 => 입력받은 결과로 회원가입처리.
		// 회원 가입 처리 ( CREATE_YMD , sysdate )
		return false;
	}

	// 사용자에게 어떤 메세지를 보여줌과 동시에 스캐너로 값을 입력받음.
	public String rtnStrMsg(Scanner sc, String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}

	public boolean upUser(UserInfoDTO dto) {
		conn = getConn();// USER_ID, USER_PW, FIRST_NAME, LAST_NAME
		String sql = " update USER_INFO SET USER_PW =? , FIRST_NAME=?, LAST_NAME=?  " + " WHERE USER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_pw());
			ps.setString(2, dto.getFirst_name());
			ps.setString(3, dto.getLast_name());
			ps.setString(4, dto.getUser_id());

			System.out.println(ps.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			dbClose();
		}

		// 메인 회원정보를 입력받고 => 입력받은 결과로 회원가입처리.
		// 회원 가입 처리 ( CREATE_YMD , sysdate )
		return false;
	}

	// 사용자에게 어떤 메세지를 보여줌과 동시에 스캐너로 값을 입력받음.

	public void deUser(UserInfoDTO dto) {
		// TODO Auto-generated method stub
		conn = getConn();// USER_ID, USER_PW, FIRST_NAME, LAST_NAME
		String sql = " delete from USER_INFO " + " WHERE USER_ID = ?  ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());

			System.out.println(ps.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			dbClose();
		}

	}

	public ArrayList<UserInfoDTO> notiUser() {

		conn = getConn();
		String sql = " select * from NOTICE_SIX ";
		ArrayList<UserInfoDTO> list = new ArrayList<UserInfoDTO>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				list.add(new UserInfoDTO(rs.getInt("page"), rs.getString("subject"), rs.getString("memo")));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			dbClose();
		}
		return list;
	}

//	----------------------------------------------------------------------
	public boolean checkUser(UserInfoDTO checkDto) {
		conn = getConn();
		String sql = "SELECT user_id FROM user_info ";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("user_id").equals(checkDto.getUser_id())) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
