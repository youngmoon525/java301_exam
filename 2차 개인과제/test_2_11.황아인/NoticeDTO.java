package Last_Project_11;

public class NoticeDTO {
	private int page; 
	private String subject, memo;
	
	public NoticeDTO() {}

	public NoticeDTO(int page, String subject, String memo) {
		this.page = page;
		this.subject = subject;
		this.memo = memo;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
}//c

