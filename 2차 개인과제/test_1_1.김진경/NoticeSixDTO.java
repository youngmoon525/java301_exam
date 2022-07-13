
public class NoticeSixDTO {
	
	protected int page;
	protected String subject, memo;
	
	//빈통
	public NoticeSixDTO() {}

	
	//생성자메소드
	public NoticeSixDTO(int page, String subject, String memo) {
		super();
		this.page = page;
		this.subject = subject;
		this.memo = memo;
	}

	
	//getter setter
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

	//생성자 메소드
	
	
	
	
}//class
