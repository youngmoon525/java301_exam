import java.sql.SQLException;

public class NoticeDAO extends UserDAO {
	//회원정보수정
	public boolean updateUser(NoticeDTO dto) {
		conn = getConn();//USER_ID, USER_PW, FIRST_NAME, LAST_NAME
		String sql = "UPDATE  user_info SET user_pw = ?, first_name = ?, last_name= ?, update_ymd= sysdate WHERE user_id= ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_pw());
			ps.setString(2, dto.getFirst_name());
			ps.setString(3, dto.getLast_name());
			ps.setString(4, dto.getUser_id());
			
			System.out.println(ps.executeUpdate());
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	finally {
			dbClose();
		}
		
		return false;
	}//updateUser
	
	//회원탈퇴 = 정보 삭제
	public int delUser(UserDTO dto) {
		conn = getConn();
		String sql = "DELETE FROM user_info WHERE user_id= ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return -1;
	}//delUser
	
	//공지사항보기
	public void readBoard(){
		conn = getConn();
		String sql = "select bcontent from board";
		try {
			ps= conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				
			System.out.println(rs.getString("bcontent"));// 공지사항을 출력해줌!
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}

	}
}