package employee;

public class EmployeeDTO {
	private String employee_id, name, e_mail,department_id, phone_number, department_name, addr, max_sal,min_sal, avg_sal;

	public EmployeeDTO(String employee_id, String name, String e_mail, String department_id, String phone_number,
			String department_name, String addr, String max_sal, String min_sal, String avg_sal) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.e_mail = e_mail;
		this.department_id = department_id;
		this.phone_number = phone_number;
		this.department_name = department_name;
		this.addr = addr;
		this.max_sal = max_sal;
		this.min_sal = min_sal;
		this.avg_sal = avg_sal;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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
	

	
		
}
