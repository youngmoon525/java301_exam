

public class UserDTO {
	private int student_no; 
	private String user_id, user_pw, first_name, last_name, create_ymd, update_ymd, money,admin_yn;
	
	

	//빈깡통하나 만들기 (밑에 생성자가 너무 길어서 짤막한거 하나 만드려고 빈깡통 만들었다)
	public UserDTO() {}
	
	//생성자메소드
	public UserDTO(int student_no, String user_id, String user_pw, String first_name, String last_name,
			String create_ymd, String update_ymd) {
		super();
		this.student_no = student_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.first_name = first_name;
		this.last_name = last_name;
		this.create_ymd = create_ymd;
		this.update_ymd = update_ymd;
	}
	
	//getter setter
	public String getAdmin_yn() {
		return admin_yn;
	}

	public void setAdmin_yn(String admin_yn) {
		this.admin_yn = admin_yn;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public int getStudent_no() {
		return student_no;
	}
	public void setStudent_no(int student_no) {
		this.student_no = student_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getCreate_ymd() {
		return create_ymd;
	}
	public void setCreate_ymd(String create_ymd) {
		this.create_ymd = create_ymd;
	}
	public String getUpdate_ymd() {
		return update_ymd;
	}
	public void setUpdate_ymd(String update_ymd) {
		this.update_ymd = update_ymd;
	}
	
	

	
	
	
}//class
