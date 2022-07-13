package test.last;

import java.util.ArrayList;

public class NoticeDAO extends UserDAO{
	//공지사항 보기, NoticeDTO 사용X
	public void notice() {
		conn = getConnection();
		String sql = "SELECT *  FROM notice_six ORDER BY page";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int page = rs.getInt("page");
				String subject = rs.getString("subject");
				String memo = rs.getString("memo");
				System.out.println(page + "\t" + subject + "\t" + memo);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		}//try
	}//notice
	
	//공지사항 보기, NoticeDTO 사용
	public ArrayList<NoticeDTO> notice_2ver() {
		conn = getConnection();
		String sql = "SELECT * FROM notice_six ORDER BY page";
		ArrayList<NoticeDTO> dto = new ArrayList<NoticeDTO>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("page") + "\t");
				System.out.print(rs.getString("subject") + "\t");
				System.out.print(rs.getString("memo") + "\t");
				System.out.println("");
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		
		return dto;
	}//최종_최종
	
}//class