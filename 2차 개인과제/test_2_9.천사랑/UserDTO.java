package pack01.ha;

public class UserDTO {
	private int student_no;
	private String user_id;
	private String user_pw;
	private String first_name;
	private String last_name;
	private String creat_ymd;
	private String update_ymd;
	public UserDTO(int student_no, String user_id, String user_pw, String first_name, String last_name,
			String creat_ymd, String update_ymd) {
		super();
		this.student_no = student_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.first_name = first_name;
		this.last_name = last_name;
		this.creat_ymd = creat_ymd;
		this.update_ymd = update_ymd;
	}
	public UserDTO() {
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
	public String getCreat_ymd() {
		return creat_ymd;
	}
	public void setCreat_ymd(String creat_ymd) {
		this.creat_ymd = creat_ymd;
	}
	public String getUpdate_ymd() {
		return update_ymd;
	}
	public void setUpdate_ymd(String update_ymd) {
		this.update_ymd = update_ymd;
	}
	
}
