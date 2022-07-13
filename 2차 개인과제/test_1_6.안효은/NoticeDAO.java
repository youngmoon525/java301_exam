package test_1_6;
import java.util.ArrayList;

public class NoticeDAO extends UserDAO {
	
	//====================NOTICE_SIX====================//
	
	//조회하고 DTO에 자료 집어넣기, 마지막에 DB 닫기
	public ArrayList<NoticeDTO> noticeList(){
		
		//선언
		ArrayList<NoticeDTO> ntList = new ArrayList<NoticeDTO>();
		
		//명령넣기
		String sql = "SELECT * FROM notice_six ORDER BY page";
		
		//조회하고 집어넣기, 마지막에 db 닫기
		try {
			//connection 연결하기
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO(rs.getInt("PAGE"), rs.getString("SUBJECT"), rs.getString("MEMO")); 
				ntList.add(dto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}//try
		return ntList;
	}//noticeList()
	
	//공지사항보기
	public void notice(ArrayList<NoticeDTO> ntList) {
		if(ntList == null || ntList.size() == 0) {
			System.out.println("보여줄 목록이 없습니다.");
			return;
		}//if
		
		for(int i=0; i <ntList.size(); i++) {
			System.out.println(ntList.get(i).getPage() + "\t" + ntList.get(i).getSubject() + "\t" + ntList.get(i).getMemo());
		}//for
	}
	
	


}
