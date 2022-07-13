<<<<<<< HEAD
package pack01.ha;
import java.util.ArrayList;

public class NoticeDAO extends UserDAO {

	public ArrayList<NoticeDTO> getnotiList() {
		conn = getConn();
		String spl = "SELECT * FROM NOTICE_SIX ORDER BY PAGE ";
		ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
		
		try {
			ps = conn.prepareStatement(spl);
			rs = ps.executeQuery();
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO(rs.getInt("page"), rs.getString("subject"), rs.getString("memo"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	//게시판 출력
	public void viewList(ArrayList<NoticeDTO> list) {
		if(list == null || list.size() == 0) {
			System.out.println("공지사항 정보가 없습니다");
			return ;
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getPage() + "\n" + list.get(i).getSubject() + "\n" + list.get(i).getMemo());
		}
	}
	
}
=======
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
>>>>>>> fd36bfa93fd6d59b3ddd895450a80ec28178a9b0
