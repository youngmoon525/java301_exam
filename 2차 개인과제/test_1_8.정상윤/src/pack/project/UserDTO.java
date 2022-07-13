package pack.project;

public class UserDTO {
	String id, pw, name, admin , email ;
	long money;
	
	public UserDTO() {}

	public UserDTO(String id, String pw, String name, String admin, String email, long money) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.admin = admin;
		this.email = email;
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}
	
	
	
	
}
