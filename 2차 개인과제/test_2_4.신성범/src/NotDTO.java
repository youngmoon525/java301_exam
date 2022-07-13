
public class NotDTO {
	private int page;
	private String subject;
	private String memo;
	public NotDTO(int page, String subject, String memo) {
		super();
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
	
	
	
}
