package employees;

public class EmpDTO {
//	private int employeeId, phoneNumber, departmentId, locationId;
//	private String name, email, departmentName, adrAll, minSalary, maxSalary, avgSalary;
//	private String phone_number, first_name, last_name, email, department_name, country_name, street_address, postal_code, city, state_province, country_id, max_sal, min_sal, avg_sal;
	private int eid;
	private String phone, did, name, email, dname, adrAll, max_sal, min_sal, avg_sal;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
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
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getAdrAll() {
		return adrAll;
	}
	public void setAdrAll(String adrAll) {
		this.adrAll = adrAll;
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