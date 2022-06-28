public class NoticeDTO extends UserDTO {
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private String bdate;
	private int bhit;
	
	public NoticeDTO(int student_no, String user_id, String user_pw, String first_name, String last_name,
			String create_ymd, String update_ymd, String admin_yn, int bid, String bname, String btitle,
			String bcontent, String  bdate, int bhit) {
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;
	}

	public NoticeDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBhit() {
		return bhit;
	}

	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	
	
	
}
