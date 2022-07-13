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
