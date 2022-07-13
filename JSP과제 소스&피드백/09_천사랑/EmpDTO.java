package Emp;

public class EmpDTO {
	private int employee_id, no;
	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getno() {
		return no;
	}

	public void setno(int emp_no) {
		this.no = emp_no;
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

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getSalary_max() {
		return salary_max;
	}

	public void setSalary_max(String salary_max) {
		this.salary_max = salary_max;
	}

	public String getSalary_min() {
		return salary_min;
	}

	public void setSalary_min(String salary_min) {
		this.salary_min = salary_min;
	}

	public String getSalary_avg() {
		return salary_avg;
	}

	public void setSalary_avg(String salary_avg) {
		this.salary_avg = salary_avg;
	}

	private String name, email, phone_number, department_name, address, department_id, salary_max, salary_min, salary_avg;
	
	
	
}
