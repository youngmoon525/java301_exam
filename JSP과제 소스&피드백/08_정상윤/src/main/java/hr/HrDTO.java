package hr;

public class HrDTO {
	String employee_id, name, email, phone_number, department_name, address;
	Double max_sal, min_sal, avg_sal;
	

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

	public Double getMax_sal() {
		return max_sal;
	}

	public void setMax_sal(Double max_sal) {
		this.max_sal = max_sal;
	}

	public Double getMin_sal() {
		return min_sal;
	}

	public void setMin_sal(Double min_sal) {
		this.min_sal = min_sal;
	}

	public Double getAvg_sal() {
		return avg_sal;
	}

	public void setAvg_sal(Double avg_sal) {
		this.avg_sal = avg_sal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
