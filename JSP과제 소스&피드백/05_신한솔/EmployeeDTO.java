package employee;

public class EmployeeDTO {
	
	//번호 사번 이름 이메일 department_id 휴대전화 부서명 전체주소 부서최대급여 부서최소급여 부서평균급여 department_id_1
	private int no, employee_id;
	private String name, email,department_id, phone_number, department_name, address, max_sal, min_sal, avg_sal, department_id_1;
	
	public EmployeeDTO() {}

	public EmployeeDTO(int no, int employee_id, String name, String email, String department_id, String phone_number,
			String department_name, String address, String max_sal, String min_sal, String avg_sal,
			String department_id_1) {
		super();
		this.no = no;
		this.employee_id = employee_id;
		this.name = name;
		this.email = email;
		this.department_id = department_id;
		this.phone_number = phone_number;
		this.department_name = department_name;
		this.address = address;
		this.max_sal = max_sal;
		this.min_sal = min_sal;
		this.avg_sal = avg_sal;
		this.department_id_1 = department_id_1;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMax_sal() {
		return max_sal;
	}

	public void setMax_sal(String max_sal) {
		this.max_sal = max_sal;
	}

	public String getMin_sal() {
		return min_sal;
	}

	public void setMin_sal(String min_sal) {
		this.min_sal = min_sal;
	}

	public String getAvg_sal() {
		return avg_sal;
	}

	public void setAvg_sal(String avg_sal) {
		this.avg_sal = avg_sal;
	}

	public String getDepartment_id_1() {
		return department_id_1;
	}

	public void setDepartment_id_1(String department_id_1) {
		this.department_id_1 = department_id_1;
	}
	
}//class