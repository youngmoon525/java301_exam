package Last_Project_11;

import java.util.ArrayList;

public class NoticeDAO extends UserDAO{
	
	public ArrayList<NoticeDTO> noticeList() {
		conn = getConn();
		String sql = " SELECT * FROM NOTICE_SIX ORDER BY PAGE";
		ArrayList<NoticeDTO> list = new ArrayList<>();
		NoticeDTO dto = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				dto = new NoticeDTO(rs.getInt("page"), rs.getString("subject"), rs.getString("memo"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("notice Error!");
			System.out.println("일시적 오류로 인한 불편을 드려 죄송합니다. " + "조금만 기다리시면 빠르게 복구하도록 하겠습니다. 이용해주셔서 감사합니다.");
		} finally {
			dbClose();
		}

		return list;
	}
	
	public void viewList(ArrayList<NoticeDTO> list) {
		if (list == null || list.size() == 0) {
			System.out.println("보여줄 목록이 없습니다.");
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getPage() + list.get(i).getSubject() + list.get(i).getMemo());
		}

	}
	
	
}//c
